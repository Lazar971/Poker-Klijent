package model;

public class Karta {

	private int broj;
	private int znak;
	
	
	
	public Karta(int broj, int znak) {
		super();
		this.broj = broj;
		this.znak = znak;
	}
	
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	public int getZnak() {
		return znak;
	}
	public void setZnak(int znak) {
		this.znak = znak;
	}
	
	
}
