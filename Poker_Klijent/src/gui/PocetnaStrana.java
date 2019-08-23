package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PocetnaStrana extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PocetnaStrana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDobrodosli = new JLabel("DOBRODOSLI");
		lblDobrodosli.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblDobrodosli.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDobrodosli, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIzaberiteOpciju = new JLabel((String) null);
		lblIzaberiteOpciju.setBounds(211, 5, 0, 0);
		panel.add(lblIzaberiteOpciju);
		
		JLabel lblIzaberiteOpciju_1 = new JLabel("Izaberite opciju");
		lblIzaberiteOpciju_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzaberiteOpciju_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIzaberiteOpciju_1.setBounds(235, 34, 171, 33);
		panel.add(lblIzaberiteOpciju_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.otvoriLogin();
			}
		});
		btnLogin.setBounds(235, 80, 171, 25);
		panel.add(btnLogin);
		
		JButton btnRegistrovanje = new JButton("Registrovanje");
		btnRegistrovanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.otvoriRegister();
			}
		});
		btnRegistrovanje.setBounds(235, 135, 171, 25);
		panel.add(btnRegistrovanje);
		
		
		
	}
}
