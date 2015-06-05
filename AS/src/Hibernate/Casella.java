package Hibernate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Casella implements Serializable{
	
	CompoundKey compoundkey; 
	
	private Integer numero;
	
	/*private Partida Partida; 
	
	@ManyToOne
	@JoinColumn(name ="Ident Partida")
	public Partida getPartida() {
		return Partida;
	}

	public void setPartida(Partida partida) {
		this.Partida = partida;
	}
*/
	@Id
	public CompoundKey getCompoundkey() {
		return compoundkey;
	}

	public void setCompoundkey(CompoundKey compoundkey) {
		this.compoundkey = compoundkey;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	} 
	
	
	

}