package DomainLayer.DataInterface;

import java.util.ArrayList;

import DomainLayer.Classes.Casella;

public interface ICtrlCasella {
	
	public Casella getCasella(int id, int fila, int col);
	public boolean existeix(int id, int fila, int col);
	public ArrayList<Casella> tots();
	public void insertaCasella(Casella casella); 
	//Faltaria un dame todas las casillas de una partida?

}
