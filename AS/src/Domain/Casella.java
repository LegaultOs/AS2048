package Domain;

import Domain.DTO.CasellaDTO;

public class Casella {
	
	int numeroFila;
	int numeroColumna;
	int numero;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Casella (int i , int j)
	{
		
		numeroFila=i;
		numeroColumna=j;
	}

	public CasellaDTO getInfo()
	{
		
		return new CasellaDTO(numeroFila, numeroColumna, numero);
		
	}
	
	
}
