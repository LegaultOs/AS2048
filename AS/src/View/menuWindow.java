package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuWindow extends JFrame {

	private JPanel contentPane;
	private JugarPartidaController cv;

	

	/**
	 * Create the frame.
	 */
	public menuWindow() {
		cv=JugarPartidaController.getInstance();
		setTitle("Joc 2048 - Jugar Partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Jugar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cv.PrJugar();
				dispose();
			}
		});
		button.setBounds(163, 117, 122, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cv.PrCancel();
			}
		});
		button_1.setBounds(341, 239, 91, 23);
		contentPane.add(button_1);
	}

}
