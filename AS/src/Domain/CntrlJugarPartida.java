package Domain;

import java.util.ArrayList;

import Domain.DTO.CasellaDTO;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;

public class CntrlJugarPartida {

	private Jugador jugador;
	private Partida p;
	
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
	
	
	public void  ferAutenticacio(String userN, String passwd)
	{
		//aqui se crear? el jugador y tal y cual
		
		
	}
	
	
	public MovimentDTO ferMoviment(String tipusMov)
	{
		MovimentDTO mov = p.ferMoviment(tipusMov);
		
		mov.setMillorPunt(jugador.getMillorPuntuacio());
		
		return mov;
	}
	
	
	
	
	
	public ArrayList<JugadorDTO> obtenirRanking() throws Exception
	
	{
		CtrlConsultarRanquing ccr =  new CtrlConsultarRanquing();
		
		ArrayList<JugadorDTO> result = ccr.consultarRanking();
		return result ;
		
	}
}
