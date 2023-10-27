package model;

public class TehnickaRoba extends Roba {
    private double nominalnaSnaga;
    private double radniNapon;
    private String boja;

    public TehnickaRoba(String naziv, double cena, String model, String jedinicaMere, String proizvodjac,
            double nominalnaSnaga, double radniNapon, String boja) {
        super(naziv, cena, model, jedinicaMere, proizvodjac);
        this.nominalnaSnaga = nominalnaSnaga;
        this.radniNapon = radniNapon;
        this.boja = boja;
    }

    public double getNominalnaSnaga() {
        return nominalnaSnaga;
    }

    public void setNominalnaSnaga(double nominalnaSnaga) {
        this.nominalnaSnaga = nominalnaSnaga;
    }

    public double getRadniNapon() {
        return radniNapon;
    }

    public void setRadniNapon(double radniNapon) {
        this.radniNapon = radniNapon;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

}
