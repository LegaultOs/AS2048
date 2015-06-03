package Domain;

public class UsuariRegistrat {
	
	private String nom;
	private String cognom;
	private String username;
	private String pwd;
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
