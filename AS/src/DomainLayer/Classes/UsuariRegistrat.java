package DomainLayer.Classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "UsuariRegistrat")
@Inheritance(strategy=InheritanceType.JOINED)
public class UsuariRegistrat {
	

	@Column(name = "NomU")
	private String nom;
	
	@Column(name = "Cognom")
	private String cognom;
	
	@Id
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Password")
	private String pwd;
	
	public UsuariRegistrat() {
	}
	
	public UsuariRegistrat(String nom, String cognom, String userN, String pwd) {
		this.nom = nom;
		this.cognom = cognom;
		this.username = userN;
		this.pwd = pwd;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPass() {
		return pwd;
	}
	
	public boolean etsJugador()
	{
		return false;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getCognom() {
		return cognom;
	}
	
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public void setPass(String pwd) {
		this.pwd = pwd;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
}
