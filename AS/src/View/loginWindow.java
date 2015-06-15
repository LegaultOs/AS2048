package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class loginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsername;
	private JPasswordField campoPassword;
	private JugarPartidaController cv;
	JLabel areaDeMissatge;

	/**
	 * Create the frame.
	 */
	public loginWindow() {
		cv = JugarPartidaController.getInstance();
		setTitle("Joc 2048 - Jugar Partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		campoUsername = new JTextField();
		campoUsername.setBounds(124, 37, 129, 20);
		contentPane.add(campoUsername);
		campoUsername.setColumns(10);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(124, 94, 129, 20);
		contentPane.add(campoPassword);
		campoPassword.setColumns(10);
		
		JButton botonLogin = new JButton("Login");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// caso de uso de Login
				if (campoUsername.getText().replace(" ", "").equals("")
						|| new String(campoPassword.getPassword()).replace(" ", "").equals("")) {
					mostraMissatge("No ha possat username o password");
				} 
				else {
					cv.PrLogin(campoUsername.getText(), new String(campoPassword.getPassword()));
				}
			}
		});
		botonLogin.setBounds(51, 255, 91, 23);
		contentPane.add(botonLogin);

		JButton botonCancel = new JButton("Cancel");
		botonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cv.PrCancel();
			}
		});
		botonCancel.setBounds(230, 255, 91, 23);
		contentPane.add(botonCancel);

		JLabel lUsername = new JLabel("Username");
		lUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lUsername.setBounds(24, 40, 73, 14);
		contentPane.add(lUsername);

		JLabel lPassword = new JLabel("Password");
		lPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lPassword.setBounds(24, 97, 73, 14);
		contentPane.add(lPassword);

		areaDeMissatge = new JLabel("Area de Missatge");
		areaDeMissatge.setHorizontalAlignment(SwingConstants.CENTER);
		areaDeMissatge.setBounds(60, 176, 220, 49);
		contentPane.add(areaDeMissatge);
		
	}
	
	public void mostraMissatge(String string) {
		areaDeMissatge.setText(string);
	}
}
