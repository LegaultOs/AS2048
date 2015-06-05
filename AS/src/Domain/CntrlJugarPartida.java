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
		ArrayList<CasellaDTO> info = new ArrayList<CasellaDTO>();
		
		InfoPartidaDTO result = new InfoPartidaDTO();
		
		Joc2048 joc =Joc2048.getInstance();
		
		int id=joc.getIdPartida();
		
		id++;
		/*esto de aqui nose si tenemos que hacerlo aqui o dentro de assignaEstrategiaOrdenacioPunts, 
		 * por que en los diagramas me he encontrado las 2 cosas .
		 * de momento se queda aquí*/
		EstrategiaOrdenacioFactory eof= EstrategiaOrdenacioFactory.getInstance();
		
		EstrategiaOrdenacio op = eof.creaEstrategiaOrdenacioPunts();
		
		joc.assignaEstrategiaOrdenacioPunts(op);
		/*----------------------------------------------*/
		p = new Partida(id);
		
		p.inicializar();
		
		info = p.casellesAmbNumero();
		
		int pi = p.getPuntuacio();
		
		int mp = jugador.getMillorPuntuacio();
		
		
		result.setInfo(info);
		result.setMillorPuntuacio(mp);
		result.setPuntuacio(pi);
		
		return result;
			
	}
	
	
	public void  ferAutenticacio(String userN, String passwd)
	{
		//aqui se creará el jugador y tal y cual
		
		
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
