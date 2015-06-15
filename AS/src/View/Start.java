package View;

import Domain.Jugador;
import Domain.UsuariRegistrat;
import Hibernate.AdminBD;

public class Start {

	public static void main(String[] args) {
		JugarPartidaView.getInstance().getStartWindow();
		
		try{
		AdminBD abd = new AdminBD(); 
		//abd.insertaPartida();
		Jugador u = abd.insertaUsuaris("OlgaC");
		System.out.println(u.getCognom() + " " + u.getNom() + " " + u.getPass() + " " + u.getUsername() + " " + u.getEmail());
		
		}
		catch (Exception e){ 	
			System.out.println(e.getMessage()); 
		}
	}

}
