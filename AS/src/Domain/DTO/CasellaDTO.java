package Domain.DTO;

public class CasellaDTO {
	
	int i,j;
	Integer numero;
	public CasellaDTO (int i,int j, int num)
	{
		this.i=i;
		this.j=j;
		this.numero=num;
		
		
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	

}
