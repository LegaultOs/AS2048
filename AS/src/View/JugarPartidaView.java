package View;

import java.util.ArrayList;

import javax.swing.JFrame;

import Domain.CntrlJugarPartida;
import Domain.DTO.CasellaDTO;
import Domain.DTO.JugadorDTO;
import Domain.DTO.MovimentDTO;

public class JugarPartidaView {
	
	private static JugarPartidaView instance;
	private JFrame actual;
	
	private JugarPartidaView(){}
	
	public static JugarPartidaView getInstance()
	{
		if(instance==null)
		{
			
			instance = new JugarPartidaView();
		}
		
		return instance;
	}
	
	
	public void mostrarJoc(Integer punt,Integer millorPunt,ArrayList<CasellaDTO> casellesAmbNumero) {
		actual= new gameWindow(punt,millorPunt,casellesAmbNumero) ;
		actual.setVisible(true);
	}
	public void mostrarLogin() {
		actual= new loginWindow();
		actual.setVisible(true);
	}
	public void mostrarWindowJugar() {
		actual= new menuWindow();
		actual.setVisible(true);
	}
	public void getRankingWindow() {
		actual= new rankingWindow();
		actual.setVisible(true);
	}
	public void getStartWindow() {
		actual= new startWindow();
		actual.setVisible(true);
	}

	public void mostraMissatge(String string) {
		// TODO Auto-generated method stub
		
	}

	public void updateJoc(Integer puntuacio,
			ArrayList<CasellaDTO> casellesAmbNumero) {
		
		MovimentDTO info = new MovimentDTO();
		info.setPuntuacio(puntuacio);
		info.setCasellesAmbNumero(casellesAmbNumero);
		((gameWindow)actual).actualitzarVista(info);
		
		
	}

	public void mostrarWindowPerduda() {
		// TODO Auto-generated method stub
		
	}

	public void mostrarWindowGuanyada() {
		// TODO Auto-generated method stub
		
	}

	public void tancar() {
		System.exit(0);// esto?
		
	}

	public void mostrarVolConsultar() {
		// TODO Auto-generated method stub
		
	}

	public void mostrarNoPartidaJugada() {
		// TODO Auto-generated method stub
		
	}

	public void mostrarRanking(ArrayList<JugadorDTO> rank) {
		// TODO Auto-generated method stub
		
	}

}
