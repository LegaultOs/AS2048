package Domain;

import java.util.ArrayList;

import Domain.DTO.CasellaDTO;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;

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
		Joc2048 joc =Joc2048.getInstance();
		int id=joc.getIdPartida();
		id++;
		joc.setId(id);

		EstrategiaOrdenacioFactory eof= EstrategiaOrdenacioFactory.getInstance();
		EstrategiaOrdenacio op = eof.creaEstrategiaOrdenacioPunts();
		joc.assignaEstrategiaOrdenacioPunts(op);
		
		p = new Partida(id);
		p.inicializar();
		
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
		
		jugador= ctrlLogin.autentica(userN, passwd);
		
		
		
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
			
			m.enviarMissatge(miss);
			
			
				
		}
		if (res.isAcabada()) jugador.acualitzaAssoc(res.getPuntuacio(), p);
		
		return res;
	}
	
	
	
	
	
	public ArrayList<JugadorDTO> obtenirRanking() throws Exception
	
	{
		
		
		ArrayList<JugadorDTO> result = ctrlCR.consultarRanking();
		return result ;
		
	}
}
