package DomainLayer.Controllers;

import java.util.ArrayList;

import Domain.DTO.JugadorDTO;
import Domain.DTO.RankingDTO;
import DomainLayer.Classes.Joc2048;
import DomainLayer.Classes.Jugador;
import DomainLayer.DataInterface.CtrlDataFactory;
import DomainLayer.DataInterface.ICtrlJugador;

public class CtrlConsultarRanquing {

	public ArrayList<JugadorDTO> consultarRanking() throws Exception {
		Joc2048 j = Joc2048.getInstance();
		CtrlDataFactory cdf = CtrlDataFactory.getInstance();	
		ICtrlJugador cj = cdf.getCtrlJugador();
		ArrayList<Jugador>jug= cj.tots();
		RankingDTO info=j.obtenirRanquing(jug, 0);
		if(info.getCont() == 0)throw new Exception("noHiHaPartides");
		return info.getInfo();
	}

}
