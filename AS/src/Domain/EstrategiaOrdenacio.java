package Domain;

import java.util.ArrayList;

import Domain.DTO.JugadorDTO;

public interface EstrategiaOrdenacio {
	
	public ArrayList<JugadorDTO> getRanquing(ArrayList<Jugador> jug,int cont);
		

}
