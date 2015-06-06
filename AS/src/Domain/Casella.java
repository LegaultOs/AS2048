package Domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Domain.DTO.CasellaDTO;
import Hibernate.CompoundKey;

@Entity
public class Casella implements Serializable{
	
	CompoundKey compoundkey; 
	
	private int numeroFila;
	private int numeroColumna;
	private Integer numero;
	
	@Id
	public CompoundKey getCompoundkey(){
		return compoundkey; 
	}
	
	public void setCompoundkey(CompoundKey compoundkey) {
		this.compoundkey = compoundkey;
	}

	
	public Integer getNumero() {
		if(numero!=null)return numero;
		else return 0;
	}

	public void setNumero(int numero) {
		if(numero!=0)this.numero = numero;
		else this.numero=null;
	}

	public Casella (int i, int j)
	{
		numeroFila=i;
		numeroColumna=j;
	}

	public CasellaDTO getInfo()
	{
		
		return new CasellaDTO(numeroFila, numeroColumna, numero);
		
	}

	
	public boolean equals(Casella obj) {
		
		return this.numero == obj.getNumero();
	
		
	}
	
	
}
