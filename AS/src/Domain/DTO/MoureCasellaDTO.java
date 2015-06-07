package Domain.DTO;

public class MoureCasellaDTO {
	
	boolean b, m, espaiblanc;
	
	public MoureCasellaDTO (boolean b, boolean m, boolean espaiblanc) {
		this.b = b;
		this.m = m;
		this.espaiblanc = espaiblanc;
	}
	
	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public boolean isM() {
		return m;
	}

	public void setM(boolean m) {
		this.m = m;
	}

	public boolean isEspaiblanc() {
		return espaiblanc;
	}

	public void setEspaiblanc(boolean espaiblanc) {
		this.espaiblanc = espaiblanc;
	}

	
}


