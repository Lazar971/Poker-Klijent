package gui;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import model.Igrac;

public class Sto extends JPanel {

	
	private int[] koordinateX=new int[]{120,120,500,500,880,810};
	private int[] koordinateY=new int[]{300,640,260,700,300,700};
	private int[] karteX;
	private int[] karteY;
	private String[][] putanjeDoKarata=new String[][]{
		{}
	};
	public  Sto() {
		super();
		this.setOpaque(false);
		this.setLayout(new OverlayLayout(this));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource("/resources/prazan sto.jpeg")), 100,100,  null);
		for(int i=0;i<GUIKontroler.igraci.size();i++){
			g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource("/resources/pngtree-manager-character-icon-png-image_780277.jpg")),
						koordinateX[i], koordinateY[i], 50, 80, null);
			String podaci=GUIKontroler.igraci.get(i).getIme()+"  "+GUIKontroler.igraci.get(i).getNovac();
			String drugiRed="\nUlog: "+GUIKontroler.igraci.get(i).getUlog();
			g.drawBytes(podaci.getBytes(), 0, podaci.getBytes().length, koordinateX[i], koordinateY[i]+90);
			g.drawBytes(drugiRed.getBytes(), 0, drugiRed.getBytes().length, koordinateX[i], koordinateY[i]+100);
		}
	}
}
