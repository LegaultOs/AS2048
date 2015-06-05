package Hibernate;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompoundKey implements Serializable {
	
	private Integer numColumna; 
	private Integer numFila;
	
	public CompoundKey(Integer numColumna, Integer numFila){
		this.numColumna = numColumna;
		this.numFila = numFila; 
	}
	
	public Integer getNumColumna() {
		return numColumna;
	}
	public void setNumColumna(Integer numColumna) {
		this.numColumna = numColumna;
	}
	public Integer getNumFila() {
		return numFila;
	}
	public void setNumFila(Integer numFila) {
		this.numFila = numFila;
	}
	
	

}
