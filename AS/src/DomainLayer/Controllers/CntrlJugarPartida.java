package DomainLayer.Controllers;

import java.util.ArrayList;

import Domain.DTO.CasellaDTO;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;
import DomainLayer.Adapters.Factoria;
import DomainLayer.Adapters.IMissatgeriaAdapter;
import DomainLayer.Classes.Casella;
import DomainLayer.Classes.EstrategiaOrdenacio;
import DomainLayer.Classes.EstrategiaOrdenacioFactory;
import DomainLayer.Classes.Joc2048;
import DomainLayer.Classes.Jugador;
import DomainLayer.Classes.Partida;
import DomainLayer.Classes.UsuariRegistrat;
import DomainLayer.DataInterface.CtrlDataFactory;
import DomainLayer.DataInterface.ICtrlUsuariRegistrat;
import Hibernate.CompoundKey;

public class CntrlJugarPartida {

	private Jugador jugador;
	private Partida p;
	private CtrlLogin ctrlLogin;
	private CtrlConsultarRanquing ctrlCR;
	
	public CntrlJugarPartida () {
		ctrlCR = new CtrlConsultarRanquing();
		ctrlLogin = new CtrlLogin();
		p = null;
		jugador = null;
	}
	
	
	public InfoPartidaDTO crearPartida()
	{	
		//Joc2048 joc =Joc2048.getInstance();
		
		Joc2048 joc = CtrlDataFactory.getInstance().getCtrlJoc2048().get(1);
		if (joc == null) joc = Joc2048.getInstance();
		int id=joc.getIdPartida();
		id++;
		joc.setId(id);

		EstrategiaOrdenacioFactory eof= EstrategiaOrdenacioFactory.getInstance();
		EstrategiaOrdenacio op = eof.creaEstrategiaOrdenacioPunts();
		joc.assignaEstrategiaOrdenacioPunts(op);
		CtrlDataFactory.getInstance().getCtrlJoc2048().insertaJoc(joc);
		p = new Partida(id);
		p.inicializar();

		CtrlDataFactory.getInstance().getCtrlPartida().insertaPartida(p);
		
		//per mantenir persistent les dades de les caselles
		Casella[][] cs = p.obteCaselles();
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				Casella c = cs[i][j];
				c.setCompoundkey(new CompoundKey(p.getIdPartida(), i+1, j+1));
				CtrlDataFactory.getInstance().getCtrlCasella().insertaCasella(c);
			}
		}
		
		ArrayList<CasellaDTO> info = new ArrayList<CasellaDTO>();
		info = p.casellesAmbNumero();
		
		int pi = p.getPuntuacio();
		int mp = jugador.getMillorPuntuacio();
		
		InfoPartidaDTO result = new InfoPartidaDTO();
		result.setInfo(info);
		result.setMillorPuntuacio(mp);
		result.setPuntuacio(pi);
		return result;
	}
	
	
	public void  ferAutenticacio(String userN, String passwd) throws Exception
	{
		
		ctrlLogin.Login(userN, passwd);
		CtrlDataFactory cdf=CtrlDataFactory.getInstance();
		ICtrlUsuariRegistrat icur = cdf.getCtrlUsuariRegistrat();
		UsuariRegistrat ur = icur.getUsuari(userN);
		if (!ur.etsJugador()) throw new Exception("usuariNoJugador");
		this.jugador = (Jugador) ur; 
	}
	
	
	public MovimentDTO ferMoviment(String tipusMov)
	{
		MovimentDTO res = p.ferMoviment(tipusMov);
		res.setMillorPunt(jugador.getMillorPuntuacio());
		if(res.isGuanyada()== true)
		{
			Factoria f = Factoria.getInstance();
			IMissatgeriaAdapter m = f.getMissatgeria();
			String miss = new String();
			miss = p.getIdPartida()+" "+res.getPuntuacio();
			m.enviarMissatge(miss,jugador.getEmail());
				
		}
		if (res.isAcabada()) jugador.acualitzaAssoc(res.getPuntuacio(), p);
		
		//update de partida al BD
		CtrlDataFactory.getInstance().getCtrlPartida().insertaPartida(p);
		//update de les caselles al BD
		Casella[][] cs = p.obteCaselles();
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				Casella c = cs[i][j];
				c.setCompoundkey(new CompoundKey(p.getIdPartida(), i+1, j+1));
				CtrlDataFactory.getInstance().getCtrlCasella().insertaCasella(c);
			}
		}
		return res;
	}
	
	public ArrayList<JugadorDTO> obtenirRanking() throws Exception
	{
		ArrayList<JugadorDTO> result = ctrlCR.consultarRanking();
		return result ;
	}
}
