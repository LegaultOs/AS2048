package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class gameWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameWindow frame = new gameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gameWindow() {
		setTitle("Joc 2048 - Jugar Partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("High Score:");
		lblNewLabel.setBounds(10, 30, 65, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("score");
		lblNewLabel_1.setBounds(83, 30, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Current Score:");
		lblNewLabel_2.setBounds(184, 30, 83, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("cScore");
		lblNewLabel_3.setBounds(277, 30, 56, 14);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(10, 69, 323, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBackground(new Color(255, 153, 102));
		lblNewLabel_4.setBounds(10, 11, 68, 62);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBackground(new Color(255, 153, 102));
		lblNewLabel_5.setBounds(10, 84, 68, 62);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBackground(new Color(255, 153, 102));
		lblNewLabel_6.setBounds(10, 157, 68, 61);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setBackground(new Color(255, 153, 102));
		lblNewLabel_7.setBounds(10, 229, 68, 64);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setBackground(new Color(255, 153, 102));
		lblNewLabel_8.setBounds(88, 11, 68, 62);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBackground(new Color(255, 153, 102));
		lblNewLabel_9.setBounds(244, 11, 68, 62);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setOpaque(true);
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
		lblNewLabel_10.setBackground(new Color(255, 153, 102));
		lblNewLabel_10.setBounds(166, 11, 68, 62);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setBackground(new Color(255, 153, 102));
		lblNewLabel_11.setBounds(88, 84, 68, 62);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setOpaque(true);
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setBackground(new Color(255, 153, 102));
		lblNewLabel_12.setBounds(88, 157, 68, 61);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setOpaque(true);
		lblNewLabel_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_13.setBackground(new Color(255, 153, 102));
		lblNewLabel_13.setBounds(88, 229, 68, 64);
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setOpaque(true);
		lblNewLabel_14.setForeground(new Color(0, 0, 0));
		lblNewLabel_14.setBackground(new Color(255, 153, 102));
		lblNewLabel_14.setBounds(166, 84, 68, 62);
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setOpaque(true);
		lblNewLabel_15.setForeground(new Color(0, 0, 0));
		lblNewLabel_15.setBackground(new Color(255, 153, 102));
		lblNewLabel_15.setBounds(166, 157, 68, 61);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setOpaque(true);
		lblNewLabel_16.setForeground(new Color(0, 0, 0));
		lblNewLabel_16.setBackground(new Color(255, 153, 102));
		lblNewLabel_16.setBounds(166, 229, 68, 64);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setOpaque(true);
		lblNewLabel_17.setForeground(new Color(0, 0, 0));
		lblNewLabel_17.setBackground(new Color(255, 153, 102));
		lblNewLabel_17.setBounds(244, 84, 68, 62);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setOpaque(true);
		lblNewLabel_18.setForeground(new Color(0, 0, 0));
		lblNewLabel_18.setBackground(new Color(255, 153, 102));
		lblNewLabel_18.setBounds(244, 157, 68, 61);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setOpaque(true);
		lblNewLabel_19.setForeground(new Color(0, 0, 0));
		lblNewLabel_19.setBackground(new Color(255, 153, 102));
		lblNewLabel_19.setBounds(244, 229, 68, 64);
		panel.add(lblNewLabel_19);
		
		addKeyListener(new KeyListener() {
		    public void keyPressed(KeyEvent e) {int code = e.getKeyCode();
		  //caso de uso Mover casilla
		    switch(code)
		    {
		    
		    
		    case KeyEvent.VK_UP:System.out.println("Up");
		    					break;
		    case KeyEvent.VK_DOWN:System.out.println("Down");
								break;
		    case KeyEvent.VK_LEFT:System.out.println("Left");
								break;
		    case KeyEvent.VK_RIGHT:System.out.println("Right");
								break;
		    default:	System.out.println("Tecla incorrecta");
		    					break;
		    
		    }
			}

		    public void keyReleased(KeyEvent e) { }

		    public void keyTyped(KeyEvent e) { }
		});
	}

	
}
