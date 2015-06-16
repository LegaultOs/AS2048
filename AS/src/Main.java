import PresentationLayer.JugarPartidaController;
import Hibernate.AdminBD;

public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		
		public void run() {
			try{
				AdminBD abd = new AdminBD(); 
				//abd.insertaPartida();
				//UsuariRegistrat j = abd.insertaUsuaris();
				//System.out.println(j.getNom() + " " + j.getCognom() + " " + j.getUsername() + " " + j.getPass() + " " + j.etsJugador());
				abd.insertaJugador();

			}
			catch (Exception e){ 	
				System.out.println(e.getMessage()); 
			}
			
			JugarPartidaController mainWindow = JugarPartidaController.getInstance();
			mainWindow.initialize();
		}
	});

}
}
