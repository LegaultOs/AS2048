package Domain;

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
		
		return null;
		
	}
	
	
}
