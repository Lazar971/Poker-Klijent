package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField ime;
	private JTextField sifra;

	
	

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
		lblKorisnickoIme.setBounds(45, 44, 100, 16);
		contentPane.add(lblKorisnickoIme);
		
		ime = new JTextField();
		ime.setBounds(170, 41, 116, 22);
		contentPane.add(ime);
		ime.setColumns(10);
		
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(45, 79, 88, 16);
		contentPane.add(lblSifra);
		
		sifra = new JTextField();
		sifra.setBounds(170, 76, 116, 22);
		contentPane.add(sifra);
		sifra.setColumns(10);
		
		JButton btnNewButton = new JButton("Uloguj se");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.posaljiPodatkeOdLogina(ime.getText(), sifra.getText());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(45, 111, 241, 72);
		contentPane.add(btnNewButton);
	}




	public JTextField getIme() {
		return ime;
	}
	
}
