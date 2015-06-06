package Domain;

import java.util.ArrayList;

import Domain.DTO.JugadorDTO;

public class Joc2048 {
	
	private static Joc2048 instance;
	private int idPartida;	
	private EstrategiaOrdenacio estrategia;
	
	private Joc2048()
	{	}
	
	public static Joc2048 getInstance()
	{
		
		if(instance==null)
		{
			instance= new Joc2048();
		}
		
		return instance;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setId(int idPartida) {
		this.idPartida = idPartida;
	}
	
	public void assignaEstrategiaOrdenacioPunts(EstrategiaOrdenacio op)
	{
		if(op.getClass().equals(EstrategiaOrdenacioPunts.class))
			estrategia=op;
	}
	
	public ArrayList<JugadorDTO> obtenirRanquing(ArrayList<Jugador>jug ,int cont)
	{
		return estrategia.getRanquing(jug, cont);
	}
		
}
