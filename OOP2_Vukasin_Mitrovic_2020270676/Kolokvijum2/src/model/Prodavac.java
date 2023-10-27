package model;

public class Prodavac extends Radnik {

    private static final long serialVersionUID = 1L;
    private int odsustva;
    private String primedbe;

    public Prodavac(String ime, String prezime, String biografija, double plata, int odsustva, String primedbe) {
        super(ime, prezime, biografija, plata);
        this.odsustva = odsustva;
        this.primedbe = primedbe;
    }

    public int getOdsustva() {
        return odsustva;
    }

    public void setOdsustva(int odsustva) {
        this.odsustva = odsustva;
    }

    public String getPrimedbe() {
        return primedbe;
    }

    public void setPrimedbe(String primedbe) {
        this.primedbe = primedbe;
    }

    @Override
    public String toString() {
        return getIme() + "|" + getPrezime() + "|" + getBiografija() + "|" + getPlata() + "|" + odsustva + "|"
                + primedbe;
    }
}