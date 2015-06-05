package Domain;

import Domain.DTO.CasellaDTO;


//provaprovaporva



public class Casella {
	
	int numeroFila;
	int numeroColumna;
	Integer numero;
	
	public Integer getNumero() {
		if(numero!=null)return numero;
		else return 0;
	}

	public void setNumero(int numero) {
		if(numero!=0)this.numero = numero;
		else this.numero=null;
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

	
	public boolean equals(Casella obj) {
		
		return this.numero == obj.getNumero();
	
		
	}
	
	
}
