package PresentationLayer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Domain.DTO.CasellaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;

public class JugarPartidaView {
	
	private JFrame actual;
	
	public JugarPartidaView() {
		
	}
	
	public void getStartWindow() {
		actual= new startWindow();
		actual.setVisible(true);
	}
	
	public void mostrarLogin() {
		actual= new loginWindow();
		actual.setVisible(true);
	}
	
	public void mostraMissatge(String string) {
		loginWindow log = (loginWindow) actual;
		log.mostraMissatge(string);
	}
	
	public void mostrarWindowJugar() {
		actual.dispose();
		actual= new menuWindow();
		actual.setVisible(true);
	}
	
	public void mostrarJoc(Integer punt, Integer millorPunt, ArrayList<CasellaDTO> casellesAmbNumero) {
		actual= new gameWindow(punt,millorPunt,casellesAmbNumero) ;
		actual.setVisible(true);
	}

	//@Canvi respecte entrega anterior, es pasa a la vista tambe la millor puntuacio del jugador 
	public void updateJoc(Integer puntuacio, Integer millorP, ArrayList<CasellaDTO> casellesAmbNumero) {
		MovimentDTO info = new MovimentDTO();
		info.setPuntuacio(puntuacio);
		info.setMillorPunt(millorP);
		info.setCasellesAmbNumero(casellesAmbNumero);
		((gameWindow) actual).actualitzarVista(info);
	}

	public void mostrarWindowPerduda() {
		Object[] options = {"Ok"};
		int response=JOptionPane.showOptionDialog(null, "Has perdut la partida", "Quina pena!",JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if(response==0) {
			actual.dispose();
			JugarPartidaController.getInstance().PrOkAConsultar();
		}
	}

	public void mostrarWindowGuanyada(String punt) {
		Object[] options = {"Ok"};
		int response=JOptionPane.showOptionDialog(null, "Has guanyat la partida! puntuacio:" + punt, "Felicitats!",JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if(response==0) {
			actual.dispose();
			JugarPartidaController.getInstance().PrOkAConsultar();
		}
	}

	public void tancar() {
		System.exit(0);
		
	}

	public void mostrarVolConsultar() {
		Object[] options = {"Si", "No"};
		int response=JOptionPane.showOptionDialog(null, "Vols consultar el ranking?", "",JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if(response==0) JugarPartidaController.getInstance().PrVullConsultar();
		else tancar();
	}

	public void mostrarNoPartidaJugada() {
		try {
			Object[] options = {"Ok"};
			int response=JOptionPane.showOptionDialog(null, "No hi ha partides jugades al sistema!", "",JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
		catch (Exception e) {
			
		}
	}

	public void mostrarRanking(ArrayList<JugadorDTO> rank) {
		Object[][] data = new Object[rank.size()][2];
		int i =0;
		for(JugadorDTO jd: rank)
		{
			data[i][0]=jd.getUsername();
			data[i][1]=jd.getPunt();
			i++;
		}
		actual= new rankingWindow(data);
		actual.setVisible(true);
	}

}
