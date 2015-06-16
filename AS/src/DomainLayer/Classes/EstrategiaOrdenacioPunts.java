package DomainLayer.Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Domain.DTO.JugadorDTO;
import Domain.DTO.RankingDTO;

public class EstrategiaOrdenacioPunts implements EstrategiaOrdenacio {

	@Override
	public RankingDTO getRanquing(ArrayList<Jugador> jug, int cont) {
		System.out.println("-------------------------------------------"+jug.size());
		ArrayList<JugadorDTO> ranking = new ArrayList<JugadorDTO>();
		for(Jugador j : jug)     //hay que recuperar les partidas jugadas
		{
			JugadorDTO player = new JugadorDTO();
			player.setUsername(j.getUsername());
			player.setPunt(j.getMillorPuntuacio());
			cont+=j.numPartidaJugada();
			System.out.println("-------------------------------------------"+j.numPartidaJugada());
			ranking.add(player);
		}

		//Sorting
		Collections.sort(ranking, new Comparator<JugadorDTO>() {
				@Override
				public int compare(JugadorDTO  j1, JugadorDTO  j2)
				{

					return  j1.getPunt()-j2.getPunt();
				}
		});
			
		return new RankingDTO(ranking, cont);
	}

}