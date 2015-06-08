package Domain.DTO;

import java.util.ArrayList;

public class InfoPartidaDTO {
	int puntuacio;
	int millorPuntuacio;
	ArrayList<CasellaDTO> info;
	public Integer getPuntuacio() {
		return puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	public Integer getMillorPuntuacio() {
		return millorPuntuacio;
	}
	public void setMillorPuntuacio(int millorPuntuacio) {
		this.millorPuntuacio = millorPuntuacio;
	}
	public ArrayList<CasellaDTO> getInfo() {
		return info;
	}
	public void setInfo(ArrayList<CasellaDTO> info) {
		this.info = info;
	}

	
}
