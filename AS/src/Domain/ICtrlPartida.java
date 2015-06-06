package Domain;

import java.util.ArrayList;

public interface ICtrlPartida {
	
	public Partida getPartida(int idPartida);
	public boolean existeix(int id);
	public ArrayList<Partida> tots();
	public void insertaPartida(Partida partida); 

}
