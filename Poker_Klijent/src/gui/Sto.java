package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import model.Igrac;

public class Sto extends JPanel {

	
	private int[] koordinateX=new int[]{120,120,500,500,880,810};
	private int[] koordinateY=new int[]{300,640,260,700,300,700};
	private int[] karteX=new int[]{450,500,550,600,650};
	private String[] znakovi=new String[]{"J","Q","K","A"};
	
	public  Sto() {
		super();
		this.setOpaque(false);
		this.setLayout(new OverlayLayout(this));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		String a="";
		if(GUIKontroler.trenutniIgrac.equals(GUIKontroler.igrac.getIme())){
			a="Vi ste na potezu";
		}else
			a="Na potezu je igrac: "+GUIKontroler.trenutniIgrac;
		String ulog="Trenutni ulog je: "+GUIKontroler.minUlog;
		
		g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource("/resources/prazan sto.jpeg")), 100,100,  null);
		for(int i=0;i<GUIKontroler.igraci.size();i++){
			Igrac igrac=GUIKontroler.igraci.get(i);
			g.drawImage(Toolkit.getDefaultToolkit().getImage(Igra.class.getResource("/resources/pngtree-manager-character-icon-png-image_780277.jpg")),
						koordinateX[i], koordinateY[i], 100, 150, null);
			String podaci=igrac.getIme()+"  "+GUIKontroler.igraci.get(i).getNovac();
			String drugiRed="\nUlog: "+GUIKontroler.igraci.get(i).getUlog();
			g.drawBytes(podaci.getBytes(), 0, podaci.getBytes().length, koordinateX[i], koordinateY[i]+90);
			g.drawBytes(drugiRed.getBytes(), 0, drugiRed.getBytes().length, koordinateX[i], koordinateY[i]+100);
			if(igrac.getPrvaKarta()!=null){
				int prviBroj=igrac.getPrvaKarta().getBroj();
				int prviZnak=igrac.getPrvaKarta().getZnak();
				g.drawRect(koordinateX[i], koordinateY[i]-85, 40, 80);
				if(prviBroj>0){
					g.drawString((prviBroj>10)?znakovi[prviBroj-11]:prviBroj+" ", koordinateX[i]+5, koordinateY[i]-70);
					g.drawString(znak(prviZnak)+" ", koordinateX[i]+5, koordinateY[i]-50);
				}
			}
			if(igrac.getDrugaKarta()!=null){
				int drugiBroj=igrac.getDrugaKarta().getBroj();
				int drugiZnak=igrac.getDrugaKarta().getZnak();
				g.drawRect(koordinateX[i]+45, koordinateY[i]-85, 40, 80);
				if(drugiBroj>0){
					g.drawString((drugiBroj>10)?znakovi[drugiBroj-11]:drugiBroj+" ", koordinateX[i]+50, koordinateY[i]-70);
					g.drawString(znak(drugiZnak)+" ", koordinateX[i]+50, koordinateY[i]-50);
				}
			}
		}
		for(int i=0;i<GUIKontroler.brojKarata;i++){
			int drugiBroj=GUIKontroler.karteNaStolu[i].getBroj();
			int drugiZnak=GUIKontroler.karteNaStolu[i].getZnak();
			g.drawRect(karteX[i], 490, 40, 80);
			if(drugiBroj>0){
				g.drawString((drugiBroj>10)?znakovi[drugiBroj-11]:drugiBroj+" ", karteX[i]+5, 500+20);
				g.drawString(znak(drugiZnak)+" ", karteX[i]+5, 500+40);
			}
		}
		g.drawString(a, 400, 290);	
		g.drawString(ulog, 400, 620);
		
		
		
	}
	private String znak(int i){
		i=i%4;
		if(i==0)
			return "Herc";
		if(i==1)
			return "Tref";
		if(i==2){
			return "Pik";
		}
		return "Karo";
	}
}
