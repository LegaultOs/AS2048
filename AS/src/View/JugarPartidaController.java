package View;

import java.util.ArrayList;

import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;
import DomainLayer.Controllers.CntrlJugarPartida;

public class JugarPartidaController {
	
	private CntrlJugarPartida cjp;
	private JugarPartidaView jpv;
	private static JugarPartidaController instance;
	
	public static JugarPartidaController getInstance()
	{
		if(instance==null)
		{
			instance = new JugarPartidaController();
		}
		return instance;
	}
	
	private JugarPartidaController() {
		jpv = new JugarPartidaView ();
		cjp = new CntrlJugarPartida();
	}

	public void initialize() {
		jpv.getStartWindow();
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
			if(e.getMessage().equals("usernameNoExisteix")) {
				jpv.mostraMissatge("Nom d'usuari no existeix");
			}
			else if(e.getMessage().equals("pwdIncorrecte")) {
				jpv.mostraMissatge("El password es incorrecte");
			}
			else if(e.getMessage().equals("usuariNoJugador")) {
				jpv.mostraMissatge("L'usuari no es un jugador");
			}
			//aqui iran todas las excepciones del login
		}
	}

	public void PrJugar() {
		InfoPartidaDTO res = cjp.crearPartida();
		jpv.mostrarJoc(res.getPuntuacio(), res.getMillorPuntuacio(), res.getInfo());
	}
	
	public void PrFerMoviment(String tipus) {
		MovimentDTO res = cjp.ferMoviment(tipus);
		if(res.isAcabada()==false && res.isGuanyada()==false) jpv.updateJoc(res.getPuntuacio(), res.getMillorPunt(), res.getCasellesAmbNumero());//No actualizamos el High score cuando el current lo sobrepasa?
		else if(res.isAcabada()==true && res.isGuanyada()==false) jpv.mostrarWindowPerduda();
		else if(res.isGuanyada()==true) jpv.mostrarWindowGuanyada(res.getPuntuacio().toString());
	}
	
	public void PrOkAConsultar()
	{
		jpv.mostrarVolConsultar();
	}
	
	public void PrVullConsultar()
	{
		try {
			ArrayList<JugadorDTO> rank= cjp.obtenirRanking();
			jpv.mostrarRanking(rank);
		} 
		catch (Exception e) {
			if(e.getMessage().equals("noHiHaPartides")) jpv.mostrarNoPartidaJugada();
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

}
