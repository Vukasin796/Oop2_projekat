package model;

public class RobaOgranicenogTrajanja extends Roba {
    private String rokTrajanja;
    private String uputstvoZaSkladistenje;

    public RobaOgranicenogTrajanja(String naziv, double cena, String model, String jedinicaMere, String proizvodjac,
            String rokTrajanja, String uputstvoZaSkaldistenje) {
        super(naziv, cena, model, jedinicaMere, proizvodjac);
        this.rokTrajanja = rokTrajanja;
        this.uputstvoZaSkladistenje = uputstvoZaSkaldistenje;
    }

    public String getRokTrajanja() {
        return rokTrajanja;
    }

    public void setRokTrajanja(String rokTrajanja) {
        this.rokTrajanja = rokTrajanja;
    }

    public String getUputstvoZaSkladistenje() {
        return uputstvoZaSkladistenje;
    }

    public void setUputstvoZaSkladistenje(String uputstvoZaSkladistenje) {
        this.uputstvoZaSkladistenje = uputstvoZaSkladistenje;
    }

}
