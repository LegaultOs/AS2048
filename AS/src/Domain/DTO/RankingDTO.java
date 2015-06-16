package Domain.DTO;

import java.util.ArrayList;

public class RankingDTO {
	
	private ArrayList<JugadorDTO>info;
	private int cont;
	
	public RankingDTO(ArrayList<JugadorDTO> info, int n) {
		this.info = info;
		this.cont = n;
	}
	
	public ArrayList<JugadorDTO> getInfo() {
		return info;
	}
	
	public void setInfo(ArrayList<JugadorDTO> info) {
		this.info = info;
	}
	
	public int getCont() {
		return cont;
	}
	
	public void setCont(int cont) {
		this.cont = cont;
	}
	
}
