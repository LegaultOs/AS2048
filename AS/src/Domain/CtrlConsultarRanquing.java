package Domain;

import java.util.ArrayList;

import Domain.DTO.JugadorDTO;

public class CtrlConsultarRanquing {

	public ArrayList<JugadorDTO> consultarRanking() throws Exception {
		int cont =0;
		Joc2048 j =Joc2048.getInstance();
		CtrlDataFactory cdf = CtrlDataFactory.getInstance();	
		ICtrlJugador cj = cdf.getCtrlJugador();
		ArrayList<Jugador>jug=cj.tots();
		ArrayList<JugadorDTO>info=j.obtenirRanquing(jug, cont);
		if(cont==0)throw new Exception("noHiHaPartides");
		return info;
	}

}
