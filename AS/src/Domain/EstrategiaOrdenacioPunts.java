package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Domain.DTO.JugadorDTO;

public class EstrategiaOrdenacioPunts implements EstrategiaOrdenacio {

	@Override
	public ArrayList<JugadorDTO> getRanquing(ArrayList<Jugador> jug, int cont) {
		ArrayList<JugadorDTO> ranking = new ArrayList<JugadorDTO>();
		for(Jugador j : jug)
		{
			JugadorDTO player = new JugadorDTO();
			player.setUsername(j.getUsername());
			player.setPunt(j.getMillorPuntuacio());
			cont+=j.numPartidaJugada();
		


		}




		//Sorting
		Collections.sort(ranking, new Comparator<JugadorDTO>() {
				@Override
				public int compare(JugadorDTO  j1, JugadorDTO  j2)
				{

					return  j1.getPunt()-j2.getPunt();
				}
			});
			
			return ranking;
	}

}
