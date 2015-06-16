package DomainLayer.Classes;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import Domain.DTO.RankingDTO;

@Entity
public class Joc2048 {
	
	private static Joc2048 instance;
	@Transient
	private EstrategiaOrdenacio ordenacio;
	
	@Column
	private int idPartida;	
	
	//para guardar el tipo de estrategia de ordenacion
	@Column
	private String estrategia;
	
	@Id
	@Column
	private int idArtificial = 1;  //es un id artificial para guardar en bd
	
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
			estrategia = "Punts";
	}
	
	//@ tipo de retorno ha cambiado respecto entrega anterior, porque out cont es dificil con java 
	public RankingDTO obtenirRanquing(ArrayList<Jugador>jug ,int cont)
	{
		return ordenacio.getRanquing(jug, cont);
	}

	public String getEstrategia() {
		return estrategia;
	}

	public void setEstrategia(String estrategia) {
		this.estrategia = estrategia;
	}
		
}
