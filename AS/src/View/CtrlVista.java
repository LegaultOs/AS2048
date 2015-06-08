package View;

import Domain.CntrlJugarPartida;
import Domain.CtrlDataFactory;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.MovimentDTO;

public class CtrlVista {
	
	/*private gameWindow gw;
	private loginWindow lw;
	private menuWindow mw;
	private rankingWindow rw;
	private startWindow sw;*/
	
	private static CtrlVista instance;
	
	//la duda aquí es si les devolvemos ventanas nuevas o le devolvemos la ventana en el estado que tenia antes.
	private static CntrlJugarPartida cjp;
	
	private CtrlVista(){}
	
	public static CtrlVista getInstance()
	{
		if(instance==null)
		{
			cjp = new CntrlJugarPartida();
			instance = new CtrlVista();
		}
		
		return instance;
	}
	
	
	public gameWindow getGameWindow() {
		return new gameWindow() ;
	}
	public loginWindow getLoginWindow() {
		return new loginWindow();
	}
	public menuWindow getMenuWindow() {
		return new menuWindow();
	}
	public rankingWindow getRankingWindow() {
		return new rankingWindow();
	}
	public startWindow getStartWindow() {
		return new startWindow();
	}

	public MovimentDTO ferMoviment(String codigo) {
		
		return cjp.ferMoviment(codigo);
	}

	public void ferAutenticacio(String text, String text2) throws Exception {
		
		cjp.ferAutenticacio(text, text2);
		
	}

	public InfoPartidaDTO crearPartida() {
		return cjp.crearPartida();
		
	}
	
	//aqui iremos poniendo las operaciones que se llamaran desde la vista.
	
	
	
	

}
