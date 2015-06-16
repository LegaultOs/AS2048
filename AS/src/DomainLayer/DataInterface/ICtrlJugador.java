package DomainLayer.DataInterface;

import java.util.ArrayList;

import DomainLayer.Classes.Jugador;

public interface ICtrlJugador {
	
	public Jugador getJugadorPerNom(String userN);
	
	public boolean existeix(String userN);
	
	public ArrayList<Jugador> tots();
	
	public Jugador getJugadorPerEmail(String email);
	
	public boolean existeixEmail (String email);
	
	public void insertaJugador(Jugador jugador); 

}
