package Domain;

import java.util.ArrayList;

public interface ICtrlPartida {
	
	public Partida get(int id);
	public boolean existeix(int id);
	public ArrayList<Partida> tots();

}
