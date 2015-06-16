package DomainLayer.Classes;

import java.util.ArrayList;

import Domain.DTO.JugadorDTO;
import Domain.DTO.RankingDTO;

public interface EstrategiaOrdenacio {

	public RankingDTO getRanquing(ArrayList<Jugador> jug,int cont);

}
