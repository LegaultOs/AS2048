package View;

import Domain.Jugador;
import Hibernate.AdminBD;

public class Start {

	public static void main(String[] args) {
		JugarPartidaView.getInstance().getStartWindow();
		
		try{
		AdminBD abd = new AdminBD(); 
		//abd.insertaPartida();
		Jugador j = abd.insertaUsuaris();
		System.out.println(j.getNom() + " " + j.getCognom() + " " + j.getUsername() + " " + j.getPass() + " " + j.getEmail() + " " + j.getMillorPuntuacio());
		}
		catch (Exception e){ 	
			System.out.println(e.getMessage()); 
		}
	}

}
