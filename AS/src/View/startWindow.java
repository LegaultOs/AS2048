package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class startWindow extends JFrame {

	private JPanel contentPane;
	private JugarPartidaController cv;

	

	/**
	 * Create the frame.
	 */
	public startWindow() {
		cv=JugarPartidaController.getInstance();
		setTitle("Joc 2048");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Jugar Partida");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cargaremos la ventana de login
				cv.PrJugarPartida();
				
				
				dispose();
			}
		});
		btnNewButton.setBounds(90, 86, 122, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancel");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(221, 181, 91, 23);
		contentPane.add(btnCancelar);
	}
}
