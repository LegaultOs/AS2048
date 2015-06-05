package Domain.DTO;

import java.util.ArrayList;

public class MovimentDTO {
	private boolean guanyada;
	private boolean acabada;
	private int millorPunt;
	private int puntuacio;
	private ArrayList<CasellaDTO> casellesAmbNumero;
	public boolean isGuanyada() {
		return guanyada;
	}
	public void setGuanyada(boolean guanyada) {
		this.guanyada = guanyada;
	}
	public boolean isAcabada() {
		return acabada;
	}
	public void setAcabada(boolean acabada) {
		this.acabada = acabada;
	}
	public int getMillorPunt() {
		return millorPunt;
	}
	public void setMillorPunt(int millorPunt) {
		this.millorPunt = millorPunt;
	}
	public int getPuntuacio() {
		return puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	public ArrayList<CasellaDTO> getCasellesAmbNumero() {
		return casellesAmbNumero;
	}
	public void setCasellesAmbNumero(ArrayList<CasellaDTO> casellesAmbNumero) {
		this.casellesAmbNumero = casellesAmbNumero;
	}

}
