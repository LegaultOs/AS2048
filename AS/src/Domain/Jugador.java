package Domain;

import java.util.ArrayList;

public class Jugador extends UsuariRegistrat {
	
	private String email;
	private int millorPuntuacio;
	private ArrayList<Partida> partidesJugades;//relacion con Partida
	
	public ArrayList<Partida> getPartidesJugades() {
		return partidesJugades;
	}
	public void setPartidesJugades(ArrayList<Partida> partidesJugades) {
		this.partidesJugades = partidesJugades;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMillorPuntuacio() {
		return millorPuntuacio;
	}
	public void setMillorPuntuacio(int millorPuntuacio) {
		this.millorPuntuacio = millorPuntuacio;
	}
	
	public int getPuntuacioMitja()
	{
		int punt=0;
		for(Partida p : partidesJugades)
		{
			punt+=p.getPuntuacio();			
		}
		
		return punt/partidesJugades.size();
	}
	
	
	public void acualitzaAssoc(int puntuacio, Partida p) {
		if (puntuacio > this.millorPuntuacio) this.millorPuntuacio = puntuacio;
		partidesJugades.add(p);
	}
		
	@Override
	public boolean etsJugador() {
		
		return true;
	}
	
	public int numPartidaJugada()
	{return partidesJugades.size();}

}
