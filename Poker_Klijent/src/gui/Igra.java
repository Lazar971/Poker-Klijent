package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Igrac;

import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.Canvas;

public class Igra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6751935266861541674L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Igra frame = new Igra();
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
	public Igra() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource("/resources/prazan sto.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Sto sto =new Sto();
		Igrac i=new Igrac("laza","");
		i.setNovac(5000);
		Igrac i2=new Igrac("laza","");
		sto.igraci.add(new Igrac("laza",""));
		sto.igraci.add(new Igrac("laza",""));
		sto.igraci.add(new Igrac("laza",""));
		sto.igraci.add(new Igrac("laza",""));
		i2.setNovac(5000);
		sto.igraci.add(i);
		sto.igraci.add(i2);
		contentPane.add(sto);
		
	}
	

}
