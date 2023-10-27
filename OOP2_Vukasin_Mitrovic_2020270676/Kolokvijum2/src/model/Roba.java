package model;

public class Roba {
    private String naziv;
    private double cena;
    private String model;
    private String jedinicaMere;
    private String proizvodjac;

    public Roba(String naziv, double cena, String model, String jedinicaMere, String proizvodjac) {
        this.naziv = naziv;
        this.cena = cena;
        this.model = model;
        this.jedinicaMere = jedinicaMere;
        this.proizvodjac = proizvodjac;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

}
