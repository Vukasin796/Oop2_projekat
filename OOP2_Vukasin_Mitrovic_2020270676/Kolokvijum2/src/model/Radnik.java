package model;

import java.io.Serializable;

public class Radnik implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime;
    private String prezime;
    private String biografija;
    private double plata;

    public Radnik(String ime, String prezime, String biografija, double plata) {
        this.ime = ime;
        this.prezime = prezime;
        this.biografija = biografija;
        this.plata = plata;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

}
