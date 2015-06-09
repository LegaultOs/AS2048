package View;

import Hibernate.AdminBD;

public class Start {

	public static void main(String[] args) {
		JugarPartidaView.getInstance().getStartWindow();
		
		AdminBD abd = new AdminBD(); 
		abd.insertaUsuaris();

	}

}
