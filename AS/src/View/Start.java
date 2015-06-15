package View;

import Hibernate.AdminBD;

public class Start {

	public static void main(String[] args) {
		JugarPartidaView.getInstance().getStartWindow();
		
		try{
		AdminBD abd = new AdminBD(); 
		abd.insertaPartida();
		//abd.insertaUsuaris();
		}
		catch (Exception e){ 	
			System.out.println(e.getMessage()); 
		}
	}

}
