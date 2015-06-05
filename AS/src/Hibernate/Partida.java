package Hibernate;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Partida")
public class Partida implements Serializable{
	
	private Integer idPartida;
	private boolean estaAcabada; 
	private boolean estaGuanyada; 
	private Integer puntuacio;
	/*private Set<Casella> caselles; 
	
	
	@OneToMany(targetEntity=Partida.class, mappedBy="Partida", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<Casella> getCaselles() {
		return caselles;
	}
	public void setCaselles(Set<Casella> caselles) {
		this.caselles = caselles;
	}*/
	@Id
	@Column(nullable = false)
	public Integer getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}
	public boolean isEstaAcabada() {
		return estaAcabada;
	}
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	public boolean isEstaGuanyada() {
		return estaGuanyada;
	}
	public void setEstaGuanyada(boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}
	public Integer getPuntuacio() {
		return puntuacio;
	}
	public void setPuntuacio(Integer puntuacio) {
		this.puntuacio = puntuacio;
	} 

}
