package data;

import java.io.*;
import java.util.ArrayList;

import model.Menadzer;
import model.Prodavac;
import model.Radnik;
import model.Roba;
import model.RobaOgranicenogTrajanja;
import model.TehnickaRoba;

public class DataHandler {
    public static void sacuvajRadnikeUFajl(ArrayList<Radnik> radnici, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Radnik radnik : radnici) {
                String line = radnik.getIme() + "|" + radnik.getPrezime() + "|" + radnik.getBiografija() + "|"
                        + radnik.getPlata();
                writer.write(line);
                writer.newLine(); // Novi red za svakog radnika
            }
            System.out.println("Podaci o radnicima su uspesno sacuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Radnik> ucitajRadnikeIzFajla(String filename) {
        ArrayList<Radnik> radnici = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String ime = parts[0];
                    String prezime = parts[1];
                    String biografija = parts[2];
                    double plata = Double.parseDouble(parts[3]);
                    Radnik radnik = new Radnik(ime, prezime, biografija, plata);
                    radnici.add(radnik);
                }
            }
            System.out.println("Podaci o radnicima su uspesno ucitani iz datoteke.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return radnici;
    }

    public static void sacuvajMenadzereUFajl(ArrayList<Menadzer> menadzeri, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Menadzer menadzer : menadzeri) {
                String line = menadzer.getIme() + "|" + menadzer.getPrezime() + "|" + menadzer.getBiografija() + "|"
                        + menadzer.getPlata() + "|" + menadzer.getDepartman();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Podaci o menadzerima su uspesno sacuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Menadzer> ucitajMenadzereIzFajla(String filename) {
        ArrayList<Menadzer> menadzeri = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String ime = parts[0];
                    String prezime = parts[1];
                    String biografija = parts[2];
                    double plata = Double.parseDouble(parts[3]);
                    ArrayList<Radnik> departman = new ArrayList<Radnik>();

                    Menadzer menadzer = new Menadzer(ime, prezime, biografija, plata, departman);
                    menadzeri.add(menadzer);
                }
            }
            System.out.println("Podaci o menadzerima su uspesno ucitani iz datoteke.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menadzeri;
    }

    public static void sacuvajRobuUFajl(ArrayList<Roba> roba, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Roba robaItem : roba) {
                String line = robaItem.getNaziv() + "|" + robaItem.getCena() + "|" + robaItem.getModel() + "|"
                        + robaItem.getJedinicaMere() + "|" + robaItem.getProizvodjac();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Podaci o robi su uspesno sacuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Roba> ucitajRobuIzFajla(String filename) {
        ArrayList<Roba> roba = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String naziv = parts[0];
                    double cena = Double.parseDouble(parts[1]);
                    String model = parts[2];
                    String jedinicaMere = parts[3];
                    String proizvodjac = parts[4];

                    Roba robaItem = new Roba(naziv, cena, model, jedinicaMere, proizvodjac);
                    roba.add(robaItem);
                }
            }
            System.out.println("Podaci o robi su uspesno ucitani iz datoteke.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roba;
    }

    public static void sacuvajRobuOgranicenogTrajanjaUFajl(ArrayList<RobaOgranicenogTrajanja> roba, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (RobaOgranicenogTrajanja robaItem : roba) {
                String line = robaItem.getNaziv() + "|" + robaItem.getCena() + "|" + robaItem.getModel() + "|"
                        + robaItem.getJedinicaMere() + "|" + robaItem.getProizvodjac() + "|" + robaItem.getRokTrajanja()
                        +
                        "|" + robaItem.getUputstvoZaSkladistenje();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Podaci o robi ogranicenog trajanjem su uspesno sacuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<RobaOgranicenogTrajanja> ucitajRobuOgranicenogTrajanjaIzFajla(String filename) {
        ArrayList<RobaOgranicenogTrajanja> roba = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 7) {
                    String naziv = parts[0];
                    double cena = Double.parseDouble(parts[1]);
                    String model = parts[2];
                    String jedinicaMere = parts[3];
                    String proizvodjac = parts[4];
                    String rokTrajanja = parts[5];
                    String uputstvo = parts[6];

                    RobaOgranicenogTrajanja robaItem = new RobaOgranicenogTrajanja(naziv, cena, model, jedinicaMere,
                            proizvodjac, rokTrajanja, uputstvo);
                    roba.add(robaItem);
                }
            }
            System.out.println("Podaci o robi ogranicenog trajanja su uspesno ucitani iz datoteke.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roba;
    }

    public static void sacuvajTehnickuRobuUFajl(ArrayList<TehnickaRoba> tehnickaRoba, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (TehnickaRoba roba : tehnickaRoba) {
                String line = roba.getNaziv() + "|" + roba.getCena() + "|" + roba.getModel() + "|"
                        + roba.getJedinicaMere() + "|" + roba.getProizvodjac() + "|" + roba.getNominalnaSnaga() + "|"
                        + roba.getRadniNapon() + "|" + roba.getBoja();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Podaci o tehnickoj robi su uspesno sacuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TehnickaRoba> ucitajTehnickuRobuIzFajla(String filename) {
        ArrayList<TehnickaRoba> tehnickaRoba = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 8) {
                    String naziv = parts[0];
                    double cena = Double.parseDouble(parts[1]);
                    String model = parts[2];
                    String jedinicaMere = parts[3];
                    String proizvodjac = parts[4];
                    double nominalnaSnaga = Double.parseDouble(parts[5]);
                    double radniNapon = Double.parseDouble(parts[6]);
                    String boja = parts[7];

                    TehnickaRoba roba = new TehnickaRoba(naziv, cena, model, jedinicaMere, proizvodjac, nominalnaSnaga,
                            radniNapon, boja);
                    tehnickaRoba.add(roba);
                }
            }
            System.out.println("Podaci o tehnickoj robi su uspešno ucitani iz datoteke.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tehnickaRoba;
    }

    public static void sacuvajProdavceUFajl(ArrayList<Prodavac> prodavci, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Prodavac prodavac : prodavci) {
                String line = prodavac.getIme() + "|" + prodavac.getPrezime() + "|" + prodavac.getBiografija() + "|"
                        + prodavac.getPlata() + "|" + prodavac.getOdsustva() + "|" + prodavac.getPrimedbe();
                writer.write(line);
                writer.newLine(); // Novi red za svakog radnika
            }
            System.out.println("Podaci o prodavcima su uspesno sacuvani u datoteku.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Prodavac> ucitajProdavceIzFajla(String filename) {
        ArrayList<Prodavac> prodavci = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 6) {
                    String ime = parts[0];
                    String prezime = parts[1];
                    String biografija = parts[2];
                    double plata = Double.parseDouble(parts[3]);
                    int odsustva = Integer.parseInt(parts[4]);
                    String primedbe = parts[5];
                    Prodavac prodavac = new Prodavac(ime, prezime, biografija, plata, odsustva, primedbe);
                    prodavci.add(prodavac);
                }
            }
            System.out.println("Podaci o prodavcima su uspesno ucitani iz datoteke.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prodavci;
    }
}