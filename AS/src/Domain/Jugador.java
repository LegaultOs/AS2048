package Domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Jugador")
@PrimaryKeyJoinColumn(name="Username")
public class Jugador extends UsuariRegistrat {
	
	private String email;
	@Column
	private int millorPuntuacio;
	//private ArrayList<Partida> partidesJugades;//relacion con Partida
	
	public Jugador() {
		millorPuntuacio = 0;
	}
	
	public Jugador (String nom, String cognom, String userN, String pwd, String email) {
		super(nom, cognom, userN, pwd);
		this.email = email;
		millorPuntuacio = 0;
	}
	
	/*public ArrayList<Partida> getPartidesJugades() {
		return partidesJugades;
	}*/
	/*public void setPartidesJugades(ArrayList<Partida> partidesJugades) {
		this.partidesJugades = partidesJugades;
	}*/
	
	@Column(unique = true, nullable = false) 
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
	
	public int PuntuacioMitja()
	{
		/*int punt=0;
		for(Partida p : partidesJugades)
		{
			punt+=p.getPuntuacio();			
		}
		
		return punt/partidesJugades.size();*/ return 0;
	}
	
	
	public void acualitzaAssoc(int puntuacio, Partida p) {
		if (puntuacio > this.millorPuntuacio) this.millorPuntuacio = puntuacio;
		//partidesJugades.add(p);
	}
		
	@Override
	public boolean etsJugador() {
		
		return true;
	}
	
	public int numPartidaJugada()
	{//return partidesJugades.size(); 
		return 0;
	}

}
