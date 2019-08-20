package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrovanje extends JFrame {

	private JPanel contentPane;
	private JTextField imeTextField;
	private JTextField prezimeTextField;
	private JTextField userNameTextField;
	private JTextField sifraTextField;
	private JTextField ponoviSifruTextField;

	
	

	public JTextField getuserNameTextField() {
		return userNameTextField;
	}




	/**
	 * Create the frame.
	 */
	public Registrovanje() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime ");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIme.setBounds(74, 78, 84, 22);
		contentPane.add(lblIme);
		
		imeTextField = new JTextField();
		imeTextField.setBounds(180, 80, 116, 22);
		contentPane.add(imeTextField);
		imeTextField.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrezime.setBounds(74, 113, 84, 16);
		contentPane.add(lblPrezime);
		
		prezimeTextField = new JTextField();
		prezimeTextField.setBounds(180, 110, 116, 22);
		contentPane.add(prezimeTextField);
		prezimeTextField.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(74, 148, 84, 16);
		contentPane.add(lblUsername);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(180, 147, 116, 22);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSifra.setBounds(74, 187, 84, 16);
		contentPane.add(lblSifra);
		
		sifraTextField = new JTextField();
		sifraTextField.setBounds(180, 182, 116, 22);
		contentPane.add(sifraTextField);
		sifraTextField.setColumns(10);
		
		JLabel lblPonoviSifru = new JLabel("Ponovi sifru");
		lblPonoviSifru.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPonoviSifru.setBounds(74, 216, 100, 16);
		contentPane.add(lblPonoviSifru);
		
		ponoviSifruTextField = new JTextField();
		ponoviSifruTextField.setBounds(180, 215, 116, 22);
		contentPane.add(ponoviSifruTextField);
		ponoviSifruTextField.setColumns(10);
		
		JButton btnRegistrujSe = new JButton("Registruj se");
		btnRegistrujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!sifraTextField.getText().equals(ponoviSifruTextField.getText())){
					GUIKontroler.razliciteSifre();
					return;
				}
				GUIKontroler.posaljiPodatkeOdRegistrovanja(imeTextField.getText(), prezimeTextField.getText(), userNameTextField.getText(), sifraTextField.getText());
				
				
			}
		});
		btnRegistrujSe.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRegistrujSe.setBounds(74, 245, 222, 60);
		contentPane.add(btnRegistrujSe);
	}
}
