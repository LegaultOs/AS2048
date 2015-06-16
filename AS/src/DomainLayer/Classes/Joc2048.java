package DomainLayer.Classes;

import java.util.ArrayList;

import javax.persistence.Entity;

import Domain.DTO.JugadorDTO;
import Domain.DTO.RankingDTO;

@Entity
public class Joc2048 {
	
	private static Joc2048 instance;
	private int idPartida;	
	private EstrategiaOrdenacio ordenacio;
	
	private Joc2048()
	{	
		idPartida = 0;
	}
	
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
			ordenacio=op;
	}
	
	//@ tipo de retorno ha cambiado respecto entrega anterior, porque out cont es dificil con java 
	public RankingDTO obtenirRanquing(ArrayList<Jugador>jug ,int cont)
	{
		return ordenacio.getRanquing(jug, cont);
	}
		
}
