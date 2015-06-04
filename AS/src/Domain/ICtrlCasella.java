package Domain;

import java.util.ArrayList;

public interface ICtrlCasella {
	
	public Casella get(int id, int fila, int col);
	public boolean existeix(int id, int fila, int col);
	public ArrayList<Casella> tots();
	
	//Faltaria un dame todas las casillas de una partida?

}
