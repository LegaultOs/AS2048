package Hibernate;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompoundKey implements Serializable {
	private int idPartida;
	private int numColumna; 
	private int numFila;
	
	public CompoundKey(int idPartida, int numColumna, int numFila){
		this.setIdPartida(idPartida);
		this.numColumna = numColumna;
		this.numFila = numFila; 
	}
	
	public int getNumColumna() {
		return numColumna;
	}
	public void setNumColumna(Integer numColumna) {
		this.numColumna = numColumna;
	}
	public int getNumFila() {
		return numFila;
	}
	public void setNumFila(Integer numFila) {
		this.numFila = numFila;
	}

	public int getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	

}
