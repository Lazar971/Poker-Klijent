package model;

public class Igrac {
	private String ime;
	private Karta prvaKarta;
	private Karta drugaKarta;
	private double novac;
	private double ulog;
	
	public Igrac(String ime, double n) {
		super();
		this.ime = ime;
		novac=n;
	}
	public Igrac(String ime){
		this.ime=ime;
	}
	public Igrac(){
		
	}
	public Karta getPrvaKarta() {
		return prvaKarta;
	}
	public void setPrvaKarta(Karta prvaKarta) {
		this.prvaKarta = prvaKarta;
	}
	public Karta getDrugaKarta() {
		return drugaKarta;
	}
	public void setDrugaKarta(Karta drugaKarta) {
		this.drugaKarta = drugaKarta;
	}
	
	public double getNovac() {
		return novac;
	}
	public void setNovac(double novac) {
		this.novac = novac;
	}
	public double getUlog() {
		return ulog;
	}
	public void setUlog(double ulog) {
		this.ulog = ulog;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	
}
