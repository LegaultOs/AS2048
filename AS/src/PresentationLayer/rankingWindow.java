package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rankingWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JugarPartidaController cv;

	public rankingWindow(Object[][] data) {
		cv=JugarPartidaController.getInstance();
		setTitle("Joc 2048 - Jugar Partida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 422, 252);
		contentPane.add(scrollPane);
		String[] columnNames = {"Puntuacio","Jugador" };
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cv.PrOkMissatgeFi();
			}
		});
		btnNewButton.setBounds(341, 279, 91, 23);
		contentPane.add(btnNewButton);
	}
}
