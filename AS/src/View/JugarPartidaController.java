package View;

import java.util.ArrayList;

import Domain.CntrlJugarPartida;
import Domain.CtrlDataFactory;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;

public class JugarPartidaController {
	
	/*private gameWindow gw;
	private loginWindow lw;
	private menuWindow mw;
	private rankingWindow rw;
	private startWindow sw;*/
	
	private static JugarPartidaController instance;
	
	//la duda aquí es si les devolvemos ventanas nuevas o le devolvemos la ventana en el estado que tenia antes.
	private static CntrlJugarPartida cjp;
	private static JugarPartidaView jpv;
	
	private JugarPartidaController(){
		jpv = JugarPartidaView.getInstance();
		cjp = new CntrlJugarPartida();
	}
	
	public static JugarPartidaController getInstance()
	{
		if(instance==null)
		{
			
			instance = new JugarPartidaController();
		}
		
		return instance;
	}
	
	public void PrJugarPartida()
	{
		
		jpv.mostrarLogin();
		
	}
	
	public void PrLogin(String user,String pass) 
	{
		
		
		try {
			cjp.ferAutenticacio(user, pass);
			jpv.mostrarWindowJugar();
		} catch (Exception e) {
			if(e.getMessage().equals("usernameNoExisteix"))jpv.mostraMissatge("Nom d'usuari no existeix");
			else if(e.getMessage().equals("pwdIncorrecte"))jpv.mostraMissatge("El password es incorrecte");
			else if(e.getMessage().equals("usuariNoJugador"))jpv.mostraMissatge("L'usuari no es un jugador");
			else jpv.mostrarWindowJugar();
			//aqui iran todas las excepciones del login
		}
	}


	public void  PrFerMoviment(String codigo) {
		
		MovimentDTO res = cjp.ferMoviment(codigo);
		
		if(res.isAcabada()==false && res.isGuanyada()==false)jpv.updateJoc(res.getPuntuacio(),res.getCasellesAmbNumero());//No actualizamos el High score cuando el current lo sobrepasa?
		else if(res.isAcabada()==true && res.isGuanyada()==false)jpv.mostrarWindowPerduda();
		else if(res.isGuanyada()==true)jpv.mostrarWindowGuanyada();
	}



	

	public void PrJugar() {
	InfoPartidaDTO info = cjp.crearPartida();
	
	jpv.mostrarJoc(info.getPuntuacio(), info.getMillorPuntuacio(), info.getInfo());
		
	}
	
	
	public void PrOkAConsultar()
	{
		
		jpv.mostrarVolConsultar();
		
	}
	
	
	public void PrVullConsultar()
	{
		boolean ex=false;
		
	try {
		ArrayList<JugadorDTO> rank= cjp.obtenirRanking();
		 jpv.mostrarRanking(rank);
	} catch (Exception e) {
		if(e.getMessage().equals("noHiHaPartides"))jpv.mostrarNoPartidaJugada();
		
	}
	
	
		
	}
	
	
	
	public void PrOkMissatgeFi()
	{
		
		
		jpv.tancar();
		
	}
	
	public void PrCancel()
	{
		
		jpv.tancar();
		
		
	}
	
	//aqui iremos poniendo las operaciones que se llamaran desde la vista.
	
	
	
	

}
