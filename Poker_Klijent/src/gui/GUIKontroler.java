package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Igrac;
import model.Karta;


public class GUIKontroler extends Thread{

	private static PocetnaStrana ps;
	private static Igra igra;
	public static Sto sto;
	private static Login login;
	private static Registrovanje register;
	private static Socket soket;
	private static BufferedReader ulaz;
	private static PrintStream izlaz;
	public static Igrac igrac;
	public static Karta[] karteNaStolu=new Karta[5];
	public static int brojKarata=0;
	public static List<Igrac> igraci=new LinkedList<Igrac>();
	public static boolean stanjeMirovanja=true;
	public static double minUlog=0;
	public static double ukupanUlog=0;
	public static boolean mojPotez=false;
	public static String trenutniIgrac="";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					soket=new Socket("localhost",11500);
					ulaz=new BufferedReader(new InputStreamReader(soket.getInputStream()));
					izlaz=new PrintStream(soket.getOutputStream());
					ps = new PocetnaStrana();
					ps.setVisible(true);
					
					GUIKontroler kontroler=new GUIKontroler();
					kontroler.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@Override
	public void run() {
		while(true){
			try {
				if(igra==null)
					igra=new Igra();
				String linija=ulaz.readLine();
				
				if(linija.equals("LOGIN")){
					obradiLogin(login.getIme().getText());
					continue;
				}
				if(linija.equals("REGISTER")){
					
					obradiRegister(register.getuserNameTextField().getText());
					continue;
				}
				if(linija.equals("UPDATE")){
					igraci=inicijalizujIgrace();
					
					igra.repaint();
					continue;
				}
				if(linija.equals("KARTE")){
					primiKarte();
					igra.repaint();
					continue;
				}
				if(linija.equals("ULOG")){
					
					primiUlog();
					
					igra.repaint();
					continue;
				}
				if(linija.equals("TRENUTNI")){
					obradiTrenutni();
					igra.repaint();
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private static void obradiTrenutni() throws IOException {
		String[] podaci=ulaz.readLine().split(" ");
		trenutniIgrac=podaci[0];
		minUlog=Double.parseDouble(podaci[1]);
		ukupanUlog=Double.parseDouble(podaci[2]);
	}

	public static void otvoriLogin(){
		if(login==null){
			login=new Login();
			
		}
		login.setVisible(true);
	}
	public static void otvoriRegister(){
		if(register==null){
			register=new Registrovanje();
			
		}
		register.setVisible(true);
	}
	public static void razliciteSifre(){
		JOptionPane.showMessageDialog(register,"Sifre nisu iste");
	}
	public static void posaljiPodatkeOdLogina(String ime,String sifra){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				stanjeMirovanja=false;
				izlaz.println("LOGIN");
				izlaz.println(ime+" "+sifra);
				
				
			}
		});
	}
	
	private static void obradiLogin(String ime){
		
				try {
					int rez=Integer.parseInt(ulaz.readLine());
					if(rez==1){
						JOptionPane.showMessageDialog(login,"Los user name");
						return;
					}
					if(rez==2){
						JOptionPane.showMessageDialog(login,"Losa sifra");
						return;
					}
					
					if(rez==3){
						JOptionPane.showMessageDialog(register,"Soba je puna");
						return;
					}
					igrac=new Igrac(ime);
					igrac.setNovac(Double.parseDouble(ulaz.readLine()));
					login.dispose();
					ps.dispose();
					
					if(igra==null)
						igra=new Igra();
					igra.setVisible(true);
					
				} catch ( IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	public static void posaljiPodatkeOdRegistrovanja(String ime,String prezime,String userName,String sifra){
		
				EventQueue.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						try{
							
							izlaz.println("REGISTER");
							izlaz.println(ime+" "+prezime+" "+userName+" "+sifra);
							
						}catch(Exception ex){
							ex.printStackTrace();
						}
						
					}
				});
	}
	private static void obradiRegister(String userName){
		
		
				try{
					int a=Integer.parseInt(ulaz.readLine());
					if(a==1){
						JOptionPane.showMessageDialog(register,"Korisnik vec postoji");
						return;
					}
					if(a==2){
						JOptionPane.showMessageDialog(register,"Soba je puna");
						return;
					}
					igrac=new Igrac(userName);
					String novac=ulaz.readLine();
					igrac.setNovac(Double.parseDouble(novac));
					
					register.dispose();
					ps.dispose();
					if(igra==null)
						igra=new Igra();
					igra.setVisible(true);
					
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
			
		
	}
	
	private static List<Igrac> inicijalizujIgrace() throws  IOException{
		List<Igrac> lista=new LinkedList<Igrac>();
		String red=ulaz.readLine();
		int n=Integer.parseInt(red);
		for(int j=0;j<n;j++){
			red=ulaz.readLine();
			String[] podaci=red.split(" ");
			Igrac i = new Igrac(podaci[0]);
			i.setNovac(Double.parseDouble(podaci[1]));
			i.setUlog(Double.parseDouble(podaci[2]));
			if(igrac.getIme().equals(i.getIme())){
				igrac=i;
			}
			lista.add(i);
			String k=ulaz.readLine();
			if(k.equals("1"))
				continue;
			String[] card=ulaz.readLine().split(" ");
			i.setPrvaKarta(new Karta(Integer.parseInt(card[0]),Integer.parseInt(card[1])));
			k=ulaz.readLine();
			if(k.equals("1"))
				continue;
			card=ulaz.readLine().split(" ");
			i.setDrugaKarta(new Karta(Integer.parseInt(card[0]),Integer.parseInt(card[1])));
			
			
		}
		return lista;
	}
	private static void primiKarte(){
		
		
		try {
			int a=Integer.parseInt(ulaz.readLine());
			if(a==-1){
				brojKarata=0;
				return;
			}
			for(int i=0;i<a;i++){
				String[] podaci=ulaz.readLine().split(" ");
				Karta k=new Karta(Integer.parseInt(podaci[0]), Integer.parseInt(podaci[1]));
				karteNaStolu[brojKarata++]=k;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void primiUlog(){
		mojPotez=true;
		Toolkit.getDefaultToolkit().beep();
		try {
			minUlog=Double.parseDouble(ulaz.readLine());
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void obradiCheck(){
		izlaz.println("CHECK");
		mojPotez=false;
	}
	public static void obradiFold(){
		izlaz.println("FOLD");
		mojPotez=false;
	}
	public static void obradiRaise(double d){
		izlaz.println("RAISE "+d);
		mojPotez=false;
	}
}
