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

import Domain.CntrlJugarPartida;
import Domain.Partida;
import Domain.DTO.CasellaDTO;
import Domain.DTO.InfoPartidaDTO;
import Domain.DTO.MovimentDTO;

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
		
		/*JLabel c00 = new JLabel("New label"); //dibujando las casellas
		c00.setHorizontalAlignment(SwingConstants.CENTER);
		c00.setOpaque(true);
		c00.setForeground(new Color(0, 0, 0));
		c00.setBackground(new Color(255, 153, 102));
		c00.setBounds(10, 11, 68, 62);
		panel.add(c00);
		casillas[0][0] = c00;

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBackground(new Color(255, 153, 102));
		lblNewLabel_5.setBounds(10, 84, 68, 62);
		panel.add(lblNewLabel_5);
		casillas[0][1] = lblNewLabel_5;

		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBackground(new Color(255, 153, 102));
		lblNewLabel_6.setBounds(10, 157, 68, 61);
		panel.add(lblNewLabel_6);
		casillas[0][2] = lblNewLabel_6;

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setBackground(new Color(255, 153, 102));
		lblNewLabel_7.setBounds(10, 229, 68, 64);
		panel.add(lblNewLabel_7);
		casillas[0][3] = lblNewLabel_7;

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setBackground(new Color(255, 153, 102));
		lblNewLabel_8.setBounds(88, 11, 68, 62);
		panel.add(lblNewLabel_8);
		casillas[1][0] = lblNewLabel_8;

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBackground(new Color(255, 153, 102));
		lblNewLabel_9.setBounds(244, 11, 68, 62);
		panel.add(lblNewLabel_9);
		casillas[1][1] = lblNewLabel_9;

		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setOpaque(true);
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setBackground(new Color(255, 153, 102));
		lblNewLabel_10.setBounds(166, 11, 68, 62);
		panel.add(lblNewLabel_10);
		casillas[1][2] = lblNewLabel_10;

		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setBackground(new Color(255, 153, 102));
		lblNewLabel_11.setBounds(88, 84, 68, 62);
		panel.add(lblNewLabel_11);
		casillas[1][3] = lblNewLabel_11;

		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setBackground(new Color(255, 153, 102));
		lblNewLabel_12.setBounds(88, 157, 68, 61);
		panel.add(lblNewLabel_12);
		casillas[2][0] = lblNewLabel_12;

		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setOpaque(true);
		lblNewLabel_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_13.setBackground(new Color(255, 153, 102));
		lblNewLabel_13.setBounds(88, 229, 68, 64);
		panel.add(lblNewLabel_13);
		casillas[2][1] = lblNewLabel_13;

		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setOpaque(true);
		lblNewLabel_14.setForeground(new Color(0, 0, 0));
		lblNewLabel_14.setBackground(new Color(255, 153, 102));
		lblNewLabel_14.setBounds(166, 84, 68, 62);
		panel.add(lblNewLabel_14);
		casillas[2][2] = lblNewLabel_14;

		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setOpaque(true);
		lblNewLabel_15.setForeground(new Color(0, 0, 0));
		lblNewLabel_15.setBackground(new Color(255, 153, 102));
		lblNewLabel_15.setBounds(166, 157, 68, 61);
		panel.add(lblNewLabel_15);
		casillas[2][3] = lblNewLabel_15;

		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setOpaque(true);
		lblNewLabel_16.setForeground(new Color(0, 0, 0));
		lblNewLabel_16.setBackground(new Color(255, 153, 102));
		lblNewLabel_16.setBounds(166, 229, 68, 64);
		panel.add(lblNewLabel_16);
		casillas[3][0] = lblNewLabel_16;

		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setOpaque(true);
		lblNewLabel_17.setForeground(new Color(0, 0, 0));
		lblNewLabel_17.setBackground(new Color(255, 153, 102));
		lblNewLabel_17.setBounds(244, 84, 68, 62);
		panel.add(lblNewLabel_17);
		casillas[3][1] = lblNewLabel_17;

		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setForeground(new Color(0, 0, 0));
		lblNewLabel_18.setBackground(new Color(255, 153, 102));
		lblNewLabel_18.setBounds(244, 157, 68, 61);
		panel.add(lblNewLabel_18);
		casillas[3][2] = lblNewLabel_18;

		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setForeground(new Color(0, 0, 0));
		lblNewLabel_19.setBackground(new Color(255, 153, 102));
		lblNewLabel_19.setBounds(244, 229, 68, 64);
		panel.add(lblNewLabel_19);
		casillas[3][3] = lblNewLabel_19;*/
		
		MovimentDTO info = new MovimentDTO();
		info.setMillorPunt(millorPunt);
		info.setPuntuacio(punt);
		info.setCasellesAmbNumero(casellesAmbNumero);
		actualitzarVista(info);

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				// caso de uso Mover casilla
				String codigo = new String();
				switch (code) {
				case KeyEvent.VK_UP:
					codigo = "amunt";
					break;
				case KeyEvent.VK_DOWN:
					codigo = "avall";
					break;
				case KeyEvent.VK_LEFT:
					codigo = "esquerra";
					break;
				case KeyEvent.VK_RIGHT:
					codigo = "dreta";
					break;
				default:
					codigo = "-1";
					break;
				}

				if (!codigo.equals("-1"))cv.PrFerMoviment(codigo);
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
		if(info.getMillorPunt()!=null) maxPunt.setText(info.getMillorPunt().toString());
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
