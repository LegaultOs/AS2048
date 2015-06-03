package Domain;

public class Jugador extends UsuariRegistrat {
	
	private String email;
	private int millorPuntuacio;
	
	
	
	
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
		return 0;}
	
	public void acualitzaAssoc(int puntuacio,Partida p)
	{
		
		
	}
	@Override
	public boolean etsJugador() {
		
		return true;
	}
	
	public int numPartidaJugada()
	{return 0;}

}
