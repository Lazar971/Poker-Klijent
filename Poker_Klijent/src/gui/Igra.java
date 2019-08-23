package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Igra extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6751935266861541674L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

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
		if(GUIKontroler.sto==null)
			GUIKontroler.sto=new Sto();
		contentPane.add(GUIKontroler.sto);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 200));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIKontroler.obradiCheck();
			}
		});
		btnNewButton.setBounds(57, 13, 105, 31);
		btnNewButton.setEnabled(GUIKontroler.mojPotez);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Fold");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.obradiFold();
			}
		});
		btnNewButton_1.setBounds(57, 57, 105, 29);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setEnabled(GUIKontroler.mojPotez);
		panel.add(btnNewButton_1);
		
		JButton btnRaise = new JButton("Raise");
		btnRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.obradiRaise(Double.parseDouble(textField.getText()));
			}
		});
		btnRaise.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRaise.setEnabled(GUIKontroler.mojPotez);
		btnRaise.setBounds(174, 13, 105, 31);
		panel.add(btnRaise);
		
		JButton btnAllIn = new JButton("All in");
		btnAllIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIKontroler.obradiRaise(GUIKontroler.igrac.getNovac());
			}
		});
		btnAllIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAllIn.setEnabled(GUIKontroler.mojPotez);
		btnAllIn.setBounds(174, 56, 105, 31);
		panel.add(btnAllIn);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setBounds(291, 62, 200, 22);
		textField.setEnabled(GUIKontroler.mojPotez);
		panel.add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setEnabled(GUIKontroler.mojPotez);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textField.setText(new Integer(slider.getValue()).toString());
			}
		});
		slider.setValue(0);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMaximum((int)(GUIKontroler.igrac.getNovac()-GUIKontroler.igrac.getUlog()));
		slider.setBounds(291, 13, 200, 31);
		panel.add(slider);
		
		
	}
}
