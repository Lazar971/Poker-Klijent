package model;

public class Igrac {
	private String ime;
	private String password;
	private Karta prvaKarta;
	private Karta drugaKarta;
	private Ruka ruka;
	private double novac;
	private double ulog;
	
	public Igrac(String ime, String password) {
		super();
		this.ime = ime;
		this.password = password;
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
	public Ruka getRuka() {
		return ruka;
	}
	public void setRuka(Ruka ruka) {
		this.ruka = ruka;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
