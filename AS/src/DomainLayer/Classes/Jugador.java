package DomainLayer.Classes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;


@Entity
@Table(name="Jugador")
@PrimaryKeyJoinColumn(name="Username")
public class Jugador extends UsuariRegistrat {
	
	private String email;
	
	@Column
	private int millorPuntuacio;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "Jugador_PartidaJugada", 
	joinColumns = { @JoinColumn(name="username") },
    inverseJoinColumns = { @JoinColumn(name="idpartida") } 
	)
	private List<Partida> partidesJugades;//relacion con Partida
	
	public Jugador() {
		millorPuntuacio = 0;
		partidesJugades =  new ArrayList<Partida>();
	}
	
	public Jugador (String nom, String cognom, String userN, String pwd, String email) {
		super(nom, cognom, userN, pwd);
		this.email = email;
		millorPuntuacio = 0;
		partidesJugades =  new ArrayList<Partida>();
	}
	
	public List<Partida> getPartidesJugades() {
		return partidesJugades;
	}
	public void setPartidesJugades(ArrayList<Partida> partidesJugades) {
		this.partidesJugades = partidesJugades;
	}
	
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
		p.setJugador(this);
	}
		
	@Override
	public boolean etsJugador() {
		
		return true;
	}
	
	public int numPartidaJugada()
	{
		return partidesJugades.size(); 
	}

}
