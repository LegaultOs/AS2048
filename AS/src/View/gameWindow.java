package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Domain.DTO.CasellaDTO;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.MovimentDTO;
import DomainLayer.Classes.Partida;
import DomainLayer.Controllers.CntrlJugarPartida;

public class gameWindow extends JFrame {

	private JPanel contentPane;
	private final int ANCHO = 4;
	private final int ALTO = 4;
	private JLabel[][] casillas = new JLabel[ANCHO][ALTO];
	private JLabel puntosActuales;
	private JLabel maxPunt;
	private JugarPartidaController cv;

	
	/**
	 * Create the frame.
	 */
	public gameWindow(Integer punt,Integer millorPunt,ArrayList<CasellaDTO> casellesAmbNumero ) {
		cv = JugarPartidaController.getInstance();

		setTitle("Joc 2048 - Jugar Partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("High Score:");  //titulo
		lblNewLabel.setBounds(10, 30, 65, 14);
		contentPane.add(lblNewLabel);

		maxPunt = new JLabel("hScore"); //puntuacion
		maxPunt.setBounds(83, 30, 46, 14);
		contentPane.add(maxPunt);

		JLabel lblNewLabel_2 = new JLabel("Punts Actual:"); //titulo
		lblNewLabel_2.setBounds(184, 30, 83, 14);
		contentPane.add(lblNewLabel_2);

		puntosActuales = new JLabel("cScore");
		puntosActuales.setBounds(277, 30, 56, 14); //puntuacion
		contentPane.add(puntosActuales);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255)); //fondo azul
		panel.setBounds(10, 69, 323, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		int x, y;
		int w = 68;
		int h = 62;
		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				JLabel jCasella = new JLabel("New label"); //dibujando las casellas
				jCasella.setHorizontalAlignment(SwingConstants.CENTER);
				jCasella.setOpaque(true);
				jCasella.setForeground(new Color(0, 0, 0));
				jCasella.setBackground(new Color(255, 153, 102));
				if (i == 0) y = 10;              //como que el eje vertical el es eje y, y i indica fila, se aumenta la y con el aumento de i 
				else if (i == 1) y =88;
				else if (i == 2) y = 166;
				else y = 244;
				if (j == 0) x = 10;
				else if (j == 1) x =88;
				else if (j == 2) x = 166;
				else x = 244;
				jCasella.setBounds(x, y, w, h);
				panel.add(jCasella);
				casillas[i][j] = jCasella;
			}
		}
		
		MovimentDTO info = new MovimentDTO();
		info.setMillorPunt(millorPunt);
		info.setPuntuacio(punt);
		info.setCasellesAmbNumero(casellesAmbNumero);
		actualitzarVista(info);

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				// caso de uso Mover casilla
				String tipus = new String();
				switch (code) {
				case KeyEvent.VK_UP:
					tipus = "amunt";
					break;
				case KeyEvent.VK_DOWN:
					tipus = "avall";
					break;
				case KeyEvent.VK_LEFT:
					tipus = "esquerra";
					break;
				case KeyEvent.VK_RIGHT:
					tipus = "dreta";
					break;
				default:
					tipus = "-1";
					break;
				}

				if (!tipus.equals("-1")) cv.PrFerMoviment(tipus);
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}
		});

		
	}

	public void actualitzarVista(MovimentDTO info) {
		setCasellas(info.getCasellesAmbNumero());
		puntosActuales.setText(info.getPuntuacio().toString());
		if(info.getMillorPunt()!=null) {
			if (info.getMillorPunt() >= info.getPuntuacio())
				maxPunt.setText(info.getMillorPunt().toString());
			else maxPunt.setText(info.getPuntuacio().toString());
		}
		this.repaint();
		this.revalidate();
	}

	private void resetCasellas() {

		for (int i = 0; i < ANCHO; i++) {
			for (int j = 0; j < ALTO; j++) {
				casillas[i][j].setText("");
			}
		}
	}

	private void setCasellas(ArrayList<CasellaDTO> info) {
		resetCasellas();
		for (CasellaDTO c : info) {
			casillas[c.getI()-1][c.getJ()-1].setText(c.getNumero().toString());
		}
	}
}
