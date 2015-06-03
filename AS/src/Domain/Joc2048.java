package Domain;

import java.util.ArrayList;

public class Joc2048 {

	private Joc2048 instance;
	private int idPartida;	
	private EstrategiaOrdenacio strat;
	private Joc2048()
	{
		
		
	}
	
	public Joc2048 getInstance()
	{
		
		if(instance==null)
		{
			return new Joc2048();
			
		}
		
		else return instance;
		
		
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	
	public void assignaEstrategiaOrdenacioPunts(EstrategiaOrdenacio op)
	{
		if(op.getClass().equals(EstrategiaOrdenacioPunts.class))
		{
			
			strat=op;
		}
		
		
	}
	
	public ArrayList<JugadorDTO> obtenirRanquing(ArrayList<Jugador>jug ,int cont)
	{
		
		return strat.getRanquing(jug, cont);
		
	}
	
	
}
