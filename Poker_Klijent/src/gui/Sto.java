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
	private int[] karteX=new int[]{450,500,550,600,650};
	private String[][] putanjeDoKarata=new String[][]{
		{"resources/Red_back.jpg","resources/Red_back.jpg","resources/Red_back.jpg","resources/Red_back.jpg"},
		{"resources/2C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/3C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/4C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/5C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/6C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/7C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/8C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/9C.jpg","resources/2D.jpg","resources/2H.jpg","resources/2S.jpg"},
		{"resources/10C.jpg","resources/10D.jpg","resources/10H.jpg","resources/10S.jpg"},
		{"resources/JC.jpg","resources/JD.jpg","resources/JH.jpg","resources/JS.jpg"},
		{"resources/QC.jpg","resources/QD.jpg","resources/QH.jpg","resources/QS.jpg"},
		{"resources/KC.jpg","resources/KD.jpg","resources/KH.jpg","resources/KS.jpg"},
		{"resources/AC.jpg","resources/AD.jpg","resources/AH.jpg","resources/AS.jpg"}
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
			Igrac igrac=GUIKontroler.igraci.get(i);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource("/resources/pngtree-manager-character-icon-png-image_780277.jpg")),
						koordinateX[i], koordinateY[i], 50, 80, null);
			String podaci=igrac.getIme()+"  "+GUIKontroler.igraci.get(i).getNovac();
			String drugiRed="\nUlog: "+GUIKontroler.igraci.get(i).getUlog();
			g.drawBytes(podaci.getBytes(), 0, podaci.getBytes().length, koordinateX[i], koordinateY[i]+90);
			g.drawBytes(drugiRed.getBytes(), 0, drugiRed.getBytes().length, koordinateX[i], koordinateY[i]+100);
			
			g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource(
					putanjeDoKarata[igrac.getPrvaKarta().getBroj()][ igrac.getPrvaKarta().getZnak()])),koordinateX[i],koordinateY[i]+180,40,90,null);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource(
					putanjeDoKarata[igrac.getDrugaKarta().getBroj()][ igrac.getDrugaKarta().getZnak()])),koordinateX[i]+40,koordinateY[i]+180,40,90,null);
		}
		for(int i=0;i<GUIKontroler.karteNaStolu.length;i++){
			g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource(
					putanjeDoKarata[GUIKontroler.karteNaStolu[i].getBroj()][GUIKontroler.karteNaStolu[i].getZnak()])),karteX[i],500,40,90,null);
		}
	}
}
