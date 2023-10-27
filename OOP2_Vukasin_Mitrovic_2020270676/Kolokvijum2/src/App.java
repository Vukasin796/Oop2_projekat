import java.util.ArrayList;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import data.DataHandler;
import model.Menadzer;
import model.Prodavac;
import model.Radnik;
import model.Roba;
import model.RobaOgranicenogTrajanja;
import model.TehnickaRoba;

public class App {
    private static DefaultTableModel model;
    private static ArrayList<Radnik> radnici;
    private static ArrayList<Menadzer> menadzeri;
    private static ArrayList<Prodavac> prodavci;
    private static ArrayList<Roba> roba;
    private static ArrayList<RobaOgranicenogTrajanja> robaOT;
    private static ArrayList<TehnickaRoba> tehnickaRoba;

    public static void main(String[] args) {
        radnici = DataHandler.ucitajRadnikeIzFajla("radnici.txt");
        menadzeri = DataHandler.ucitajMenadzereIzFajla("menadzeri.txt");
        prodavci = DataHandler.ucitajProdavceIzFajla("prodavci.txt");
        roba = DataHandler.ucitajRobuIzFajla("roba.txt");
        robaOT = DataHandler.ucitajRobuOgranicenogTrajanjaIzFajla("robaOgranicenogTrajanja.txt");
        tehnickaRoba = DataHandler.ucitajTehnickuRobuIzFajla("tehnickaRoba.txt");

        JFrame mainWindow = new JFrame("Warehouse Management App");
        mainWindow.setSize(600, 400);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] entities = { "Radnik", "Menadzer", "Prodavac", "Roba", "Roba ogranicenog trajanja", "Tehnicka roba" };
        JComboBox<String> entitySelector = new JComboBox<>(entities);

        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEntity = (String) entitySelector.getSelectedItem();
                displayEntityList(selectedEntity);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.add(entitySelector);
        mainPanel.add(displayButton);

        mainWindow.add(mainPanel);
        mainWindow.setVisible(true);
    }

    public static void displayEntityList(String entity) {
        JFrame entityListWindow = new JFrame(entity + " List");
        entityListWindow.setSize(600, 400);

        if (entity.equals("Radnik")) {
            model = createTableForRadnici(radnici);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Radnik newRadnik = showAddRadnikDialog();
                    if (newRadnik != null) {
                        radnici.add(newRadnik);
                        addRowToTable(newRadnik);
                        DataHandler.sacuvajRadnikeUFajl(radnici, "radnici.txt");
                    }
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Radnik selectedRadnik = radnici.get(selectedRow);
                        Radnik updatedRadnik = showEditRadnikDialog(selectedRadnik);
                        if (updatedRadnik != null) {
                            radnici.set(selectedRow, updatedRadnik);
                            updateRowInTable(updatedRadnik, selectedRow);
                            DataHandler.sacuvajRadnikeUFajl(radnici, "radnici.txt");
                        }
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        radnici.remove(selectedRow);
                        deleteRowFromTable(selectedRow);
                        DataHandler.sacuvajRadnikeUFajl(radnici, "radnici.txt");
                    }
                }
            });

            buttonsPanel.add(addButton);
            buttonsPanel.add(editButton);
            buttonsPanel.add(deleteButton);

            entityListWindow.add(buttonsPanel, BorderLayout.NORTH);
            entityListWindow.add(scrollPane, BorderLayout.CENTER);
        }

        if (entity.equals("Menadzer")) {
            model = createTableForMenadzeri(menadzeri);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Menadzer newMenadzer = showAddMenadzerDialog();
                    if (newMenadzer != null) {
                        menadzeri.add(newMenadzer);
                        addRowToTable(newMenadzer);
                        DataHandler.sacuvajMenadzereUFajl(menadzeri, "menadzeri.txt");
                    }
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Menadzer selectedMenadzer = menadzeri.get(selectedRow);
                        Menadzer updatedMenadzer = showEditMenadzerDialog(selectedMenadzer);
                        if (updatedMenadzer != null) {
                            menadzeri.set(selectedRow, updatedMenadzer);
                            updateRowInTable(updatedMenadzer, selectedRow);
                            DataHandler.sacuvajMenadzereUFajl(menadzeri, "menadzeri.txt");
                        }
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        menadzeri.remove(selectedRow);
                        deleteRowFromTable(selectedRow);
                        DataHandler.sacuvajMenadzereUFajl(menadzeri, "menadzeri.txt");
                    }
                }
            });

            buttonsPanel.add(addButton);
            buttonsPanel.add(editButton);
            buttonsPanel.add(deleteButton);

            entityListWindow.add(buttonsPanel, BorderLayout.NORTH);
            entityListWindow.add(scrollPane, BorderLayout.CENTER);
        }
        if (entity.equals("Prodavac")) {
            model = createTableForProdavci(prodavci);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Prodavac newProdavac = showAddProdavacDialog();
                    if (newProdavac != null) {
                        prodavci.add(newProdavac);
                        addRowToTable(newProdavac);
                        DataHandler.sacuvajProdavceUFajl(prodavci, "prodavci.txt");
                    }
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Prodavac selectedProdavac = prodavci.get(selectedRow);
                        Prodavac updatedProdavac = showEditProdavacDialog(selectedProdavac);
                        if (updatedProdavac != null) {
                            prodavci.set(selectedRow, updatedProdavac);
                            updateRowInTable(updatedProdavac, selectedRow);
                            DataHandler.sacuvajProdavceUFajl(prodavci, "prodavci.txt");
                        }
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        prodavci.remove(selectedRow);
                        deleteRowFromTable(selectedRow);
                        DataHandler.sacuvajProdavceUFajl(prodavci, "prodavci.txt");
                    }
                }
            });

            buttonsPanel.add(addButton);
            buttonsPanel.add(editButton);
            buttonsPanel.add(deleteButton);

            entityListWindow.add(buttonsPanel, BorderLayout.NORTH);
            entityListWindow.add(scrollPane, BorderLayout.CENTER);
        }
        if (entity.equals("Roba")) {
            model = createTableForRoba(roba);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Roba newRoba = showAddRobaDialog();
                    if (newRoba != null) {
                        roba.add(newRoba);
                        addRowToTable(newRoba);
                        DataHandler.sacuvajRobuUFajl(roba, "roba.txt");
                    }
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        Roba selectedroba = roba.get(selectedRow);
                        Roba updateRoba = showEditRobaDialog(selectedroba);
                        if (updateRoba != null) {
                            roba.set(selectedRow, updateRoba);
                            updateRowInTable(updateRoba, selectedRow);
                            DataHandler.sacuvajRobuUFajl(roba, "roba.txt");
                        }
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        roba.remove(selectedRow);
                        deleteRowFromTable(selectedRow);
                        DataHandler.sacuvajRobuUFajl(roba, "roba.txt");
                    }
                }
            });

            buttonsPanel.add(addButton);
            buttonsPanel.add(editButton);
            buttonsPanel.add(deleteButton);

            entityListWindow.add(buttonsPanel, BorderLayout.NORTH);
            entityListWindow.add(scrollPane, BorderLayout.CENTER);
        }
        if (entity.equals("Roba ogranicenog trajanja")) {
            model = createTableForRobaOgranicenogTrajanja(robaOT);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    RobaOgranicenogTrajanja newRoba = showAddRobaOgranicenogTrajanjaDialog();
                    if (newRoba != null) {
                        robaOT.add(newRoba);
                        addRowToTable(newRoba);
                        DataHandler.sacuvajRobuOgranicenogTrajanjaUFajl(robaOT, "robaOgranicenogTrajanja.txt");
                    }
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        RobaOgranicenogTrajanja selectedroba = robaOT.get(selectedRow);
                        RobaOgranicenogTrajanja updateRoba = showEditRobaOgranicenogTrajanjaDialog(selectedroba);
                        if (updateRoba != null) {
                            robaOT.set(selectedRow, updateRoba);
                            updateRowInTable(updateRoba, selectedRow);
                            DataHandler.sacuvajRobuOgranicenogTrajanjaUFajl(robaOT, "robaOgranicenogTrajanja.txt");
                        }
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        robaOT.remove(selectedRow);
                        deleteRowFromTable(selectedRow);
                        DataHandler.sacuvajRobuOgranicenogTrajanjaUFajl(robaOT, "robaOgranicenogTrajanja.txt");
                    }
                }
            });

            buttonsPanel.add(addButton);
            buttonsPanel.add(editButton);
            buttonsPanel.add(deleteButton);

            entityListWindow.add(buttonsPanel, BorderLayout.NORTH);
            entityListWindow.add(scrollPane, BorderLayout.CENTER);
        }
        if (entity.equals("Tehnicka roba")) {
            model = createTableForTehnickaRoba(tehnickaRoba);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);

            JPanel buttonsPanel = new JPanel();
            buttonsPanel.setLayout(new GridLayout(1, 3));

            JButton addButton = new JButton("Add");
            JButton editButton = new JButton("Edit");
            JButton deleteButton = new JButton("Delete");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    TehnickaRoba newRoba = showAddTehnickaRobaDialog();
                    if (newRoba != null) {
                        tehnickaRoba.add(newRoba);
                        addRowToTable(newRoba);
                        DataHandler.sacuvajTehnickuRobuUFajl(tehnickaRoba, "tehnickaRoba.txt");
                    }
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        TehnickaRoba selectedroba = tehnickaRoba.get(selectedRow);
                        TehnickaRoba updateRoba = showEditTehnickaRobaDialog(selectedroba);
                        if (updateRoba != null) {
                            tehnickaRoba.set(selectedRow, updateRoba);
                            updateRowInTable(updateRoba, selectedRow);
                            DataHandler.sacuvajTehnickuRobuUFajl(tehnickaRoba, "tehnickaRoba.txt");
                        }
                    }
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        tehnickaRoba.remove(selectedRow);
                        deleteRowFromTable(selectedRow);
                        DataHandler.sacuvajTehnickuRobuUFajl(tehnickaRoba, "tehnickaRoba.txt");
                    }
                }
            });

            buttonsPanel.add(addButton);
            buttonsPanel.add(editButton);
            buttonsPanel.add(deleteButton);

            entityListWindow.add(buttonsPanel, BorderLayout.NORTH);
            entityListWindow.add(scrollPane, BorderLayout.CENTER);
        }

        entityListWindow.setVisible(true);
    }

    public static DefaultTableModel createTableForRadnici(ArrayList<Radnik> radnici) {
        String[] columnNames = { "Ime", "Prezime", "Biografija", "Plata" };
        model = new DefaultTableModel(columnNames, 0);

        for (Radnik radnik : radnici) {
            addRowToTable(radnik);
        }

        return model;

    }

    public static DefaultTableModel createTableForMenadzeri(ArrayList<Menadzer> menadzers) {
        String[] columnNames = { "Ime", "Prezime", "Biografija", "Plata", "Dept" };
        model = new DefaultTableModel(columnNames, 0);

        for (Menadzer m : menadzers) {
            addRowToTable(m);
        }

        return model;
    }

    public static DefaultTableModel createTableForProdavci(ArrayList<Prodavac> prodavacs) {
        String[] columnNames = { "Ime", "Prezime", "Biografija", "Plata", "Odsustva", "Primedbe" };
        model = new DefaultTableModel(columnNames, 0);

        for (Prodavac m : prodavacs) {
            addRowToTable(m);
        }

        return model;
    }

    public static DefaultTableModel createTableForRoba(ArrayList<Roba> roba1) {
        String[] columnNames = { "Naziv", "Cena", "Model", "JedinicaMere", "Proizvodjac" };
        model = new DefaultTableModel(columnNames, 0);

        for (Roba r : roba1) {
            addRowToTable(r);
        }

        return model;
    }

    public static DefaultTableModel createTableForRobaOgranicenogTrajanja(ArrayList<RobaOgranicenogTrajanja> robaot) {
        String[] columnNames = { "Naziv", "Cena", "Model", "JedinicaMere", "Proizvodjac", "RokTrajanja",
                "Uputstvo za skladistenje" };
        model = new DefaultTableModel(columnNames, 0);

        for (RobaOgranicenogTrajanja r : robaot) {
            addRowToTable(r);
        }

        return model;
    }

    public static DefaultTableModel createTableForTehnickaRoba(ArrayList<TehnickaRoba> tRoba) {
        String[] columnNames = { "Naziv", "Cena", "Model", "JedinicaMere", "Proizvodjac", "NominalnaSnaga",
                "RadniNapon", "Boja" };
        model = new DefaultTableModel(columnNames, 0);

        for (TehnickaRoba r : tRoba) {
            addRowToTable(r);
        }

        return model;
    }

    public static void addRowToTable(Radnik radnik) {
        Object[] rowData = { radnik.getIme(), radnik.getPrezime(), radnik.getBiografija(), radnik.getPlata() };
        model.addRow(rowData);
    }

    public static void addRowToTable(Menadzer menadzer) {
        Object[] rowData = { menadzer.getIme(), menadzer.getPrezime(), menadzer.getBiografija(), menadzer.getPlata(),
                menadzer.getDepartman() };
        model.addRow(rowData);

    }

    public static void addRowToTable(Prodavac prodavac) {
        Object[] rowData = { prodavac.getIme(), prodavac.getPrezime(), prodavac.getBiografija(), prodavac.getPlata(),
                prodavac.getOdsustva(), prodavac.getPrimedbe() };
        model.addRow(rowData);
    }

    public static void addRowToTable(Roba roba) {
        Object[] rowData = { roba.getNaziv(), roba.getCena(), roba.getModel(), roba.getJedinicaMere(),
                roba.getProizvodjac() };
        model.addRow(rowData);
    }

    public static void addRowToTable(RobaOgranicenogTrajanja roba) {
        Object[] rowData = { roba.getNaziv(), roba.getCena(), roba.getModel(), roba.getJedinicaMere(),
                roba.getProizvodjac(), roba.getRokTrajanja(), roba.getUputstvoZaSkladistenje() };
        model.addRow(rowData);
    }

    public static void addRowToTable(TehnickaRoba roba) {
        Object[] rowData = { roba.getNaziv(), roba.getCena(), roba.getModel(), roba.getJedinicaMere(),
                roba.getProizvodjac(), roba.getNominalnaSnaga(), roba.getRadniNapon(), roba.getBoja() };
        model.addRow(rowData);
    }

    public static void updateRowInTable(Radnik radnik, int rowIndex) {
        model.setValueAt(radnik.getIme(), rowIndex, 0);
        model.setValueAt(radnik.getPrezime(), rowIndex, 1);
        model.setValueAt(radnik.getBiografija(), rowIndex, 2);
        model.setValueAt(radnik.getPlata(), rowIndex, 3);
    }

    public static void updateRowInTable(Menadzer menadzer, int rowIndex) {
        model.setValueAt(menadzer.getIme(), rowIndex, 0);
        model.setValueAt(menadzer.getPrezime(), rowIndex, 1);
        model.setValueAt(menadzer.getBiografija(), rowIndex, 2);
        model.setValueAt(menadzer.getPlata(), rowIndex, 3);
    }

    public static void updateRowInTable(Prodavac prodavac, int rowIndex) {
        model.setValueAt(prodavac.getIme(), rowIndex, 0);
        model.setValueAt(prodavac.getPrezime(), rowIndex, 1);
        model.setValueAt(prodavac.getBiografija(), rowIndex, 2);
        model.setValueAt(prodavac.getPlata(), rowIndex, 3);
        model.setValueAt(prodavac.getOdsustva(), rowIndex, 4);
        model.setValueAt(prodavac.getPrimedbe(), rowIndex, 5);

    }

    public static void updateRowInTable(Roba roba, int rowIndex) {
        model.setValueAt(roba.getNaziv(), rowIndex, 0);
        model.setValueAt(roba.getCena(), rowIndex, 1);
        model.setValueAt(roba.getModel(), rowIndex, 2);
        model.setValueAt(roba.getJedinicaMere(), rowIndex, 3);
        model.setValueAt(roba.getProizvodjac(), rowIndex, 4);
    }

    public static void updateRowInTable(RobaOgranicenogTrajanja roba, int rowIndex) {
        model.setValueAt(roba.getNaziv(), rowIndex, 0);
        model.setValueAt(roba.getCena(), rowIndex, 1);
        model.setValueAt(roba.getModel(), rowIndex, 2);
        model.setValueAt(roba.getJedinicaMere(), rowIndex, 3);
        model.setValueAt(roba.getProizvodjac(), rowIndex, 4);
        model.setValueAt(roba.getRokTrajanja(), rowIndex, 5);
        model.setValueAt(roba.getUputstvoZaSkladistenje(), rowIndex, 6);
    }

    public static void updateRowInTable(TehnickaRoba roba, int rowIndex) {
        model.setValueAt(roba.getNaziv(), rowIndex, 0);
        model.setValueAt(roba.getCena(), rowIndex, 1);
        model.setValueAt(roba.getModel(), rowIndex, 2);
        model.setValueAt(roba.getJedinicaMere(), rowIndex, 3);
        model.setValueAt(roba.getProizvodjac(), rowIndex, 4);
        model.setValueAt(roba.getNominalnaSnaga(), rowIndex, 5);
        model.setValueAt(roba.getRadniNapon(), rowIndex, 6);
        model.setValueAt(roba.getBoja(), rowIndex, 7);
    }

    public static void deleteRowFromTable(int rowIndex) {
        model.removeRow(rowIndex);
    }

    public static Radnik showAddRadnikDialog() {
        JTextField imeField = new JTextField();
        JTextField prezimeField = new JTextField();
        JTextField biografijaField = new JTextField();
        JTextField plataField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Ime:"));
        panel.add(imeField);
        panel.add(new JLabel("Prezime:"));
        panel.add(prezimeField);
        panel.add(new JLabel("Biografija:"));
        panel.add(biografijaField);
        panel.add(new JLabel("Plata:"));
        panel.add(plataField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Radnik", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                String biografija = biografijaField.getText();
                double plata = Double.parseDouble(plataField.getText());

                Radnik newRadnik = new Radnik(ime, prezime, biografija, plata);
                return newRadnik;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Plata'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static Menadzer showAddMenadzerDialog() {
        JTextField imeField = new JTextField();
        JTextField prezimeField = new JTextField();
        JTextField biografijaField = new JTextField();
        JTextField plataField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Ime:"));
        panel.add(imeField);
        panel.add(new JLabel("Prezime:"));
        panel.add(prezimeField);
        panel.add(new JLabel("Biografija:"));
        panel.add(biografijaField);
        panel.add(new JLabel("Plata:"));
        panel.add(plataField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Menadzer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                String biografija = biografijaField.getText();
                double plata = Double.parseDouble(plataField.getText());

                Menadzer newRadnik = new Menadzer(ime, prezime, biografija, plata, new ArrayList<Radnik>());
                return newRadnik;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Plata'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static Prodavac showAddProdavacDialog() {
        JTextField imeField = new JTextField();
        JTextField prezimeField = new JTextField();
        JTextField biografijaField = new JTextField();
        JTextField plataField = new JTextField();
        JTextField odsustvaField = new JTextField();
        JTextField primedbeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Ime:"));
        panel.add(imeField);
        panel.add(new JLabel("Prezime:"));
        panel.add(prezimeField);
        panel.add(new JLabel("Biografija:"));
        panel.add(biografijaField);
        panel.add(new JLabel("Plata:"));
        panel.add(plataField);
        panel.add(new JLabel("Odsustva:"));
        panel.add(plataField);
        panel.add(new JLabel("Primedbe:"));
        panel.add(plataField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Prodavac", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                String biografija = biografijaField.getText();
                double plata = Double.parseDouble(plataField.getText());
                int odsustva = Integer.parseInt(odsustvaField.getText());
                String primedbe = primedbeField.getText();

                Prodavac newRadnik = new Prodavac(ime, prezime, biografija, plata, odsustva, primedbe);
                return newRadnik;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Plata'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static Roba showAddRobaDialog() {
        JTextField nazivField = new JTextField();
        JTextField cenaField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField jedinicaMereField = new JTextField();
        JTextField proizvodjacField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Naziv:"));
        panel.add(nazivField);
        panel.add(new JLabel("Cena:"));
        panel.add(cenaField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Jedinica Mere:"));
        panel.add(jedinicaMereField);
        panel.add(new JLabel("Proizvodjac:"));
        panel.add(proizvodjacField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Roba", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String naziv = nazivField.getText();
                double cena = Double.parseDouble(cenaField.getText());
                String model = modelField.getText();
                String jedinicaMere = jedinicaMereField.getText();
                String proizvodjac = proizvodjacField.getText();

                Roba newRoba = new Roba(naziv, cena, model, jedinicaMere, proizvodjac);
                return newRoba;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Cena'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static RobaOgranicenogTrajanja showAddRobaOgranicenogTrajanjaDialog() {
        JTextField nazivField = new JTextField();
        JTextField cenaField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField jedinicaMereField = new JTextField();
        JTextField proizvodjacField = new JTextField();
        JTextField rokTrajanjaField = new JTextField();
        JTextField uputstvoField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Naziv:"));
        panel.add(nazivField);
        panel.add(new JLabel("Cena:"));
        panel.add(cenaField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Jedinica Mere:"));
        panel.add(jedinicaMereField);
        panel.add(new JLabel("Proizvodjac:"));
        panel.add(proizvodjacField);
        panel.add(new JLabel("Rok Trajanja:"));
        panel.add(rokTrajanjaField);
        panel.add(new JLabel("Uputstvo za Skladistenje:"));
        panel.add(uputstvoField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add RobaOgranicenogTrajanja",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String naziv = nazivField.getText();
                double cena = Double.parseDouble(cenaField.getText());
                String model = modelField.getText();
                String jedinicaMere = jedinicaMereField.getText();
                String proizvodjac = proizvodjacField.getText();
                String rokTrajanja = rokTrajanjaField.getText();
                String uputstvo = uputstvoField.getText();

                RobaOgranicenogTrajanja newRobaOgranicenogTrajanja = new RobaOgranicenogTrajanja(naziv, cena, model,
                        jedinicaMere, proizvodjac, rokTrajanja, uputstvo);
                return newRobaOgranicenogTrajanja;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Cena'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static TehnickaRoba showAddTehnickaRobaDialog() {
        JTextField nazivField = new JTextField();
        JTextField cenaField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField jedinicaMereField = new JTextField();
        JTextField proizvodjacField = new JTextField();
        JTextField nominalnaSnagaField = new JTextField();
        JTextField radniNaponField = new JTextField();
        JTextField bojaField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(new JLabel("Naziv:"));
        panel.add(nazivField);
        panel.add(new JLabel("Cena:"));
        panel.add(cenaField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Jedinica Mere:"));
        panel.add(jedinicaMereField);
        panel.add(new JLabel("Proizvodjac:"));
        panel.add(proizvodjacField);
        panel.add(new JLabel("Nominalna Snaga:"));
        panel.add(nominalnaSnagaField);
        panel.add(new JLabel("Radni Napon:"));
        panel.add(radniNaponField);
        panel.add(new JLabel("Boja:"));
        panel.add(bojaField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add TehnickaRoba", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String naziv = nazivField.getText();
                double cena = Double.parseDouble(cenaField.getText());
                String model = modelField.getText();
                String jedinicaMere = jedinicaMereField.getText();
                String proizvodjac = proizvodjacField.getText();
                double nominalnaSnaga = Double.parseDouble(nominalnaSnagaField.getText());
                double radniNapon = Double.parseDouble(radniNaponField.getText());
                String boja = bojaField.getText();

                TehnickaRoba newTehnickaRoba = new TehnickaRoba(naziv, cena, model, jedinicaMere, proizvodjac,
                        nominalnaSnaga, radniNapon, boja);
                return newTehnickaRoba;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input for 'Cena', 'Nominalna Snaga', or 'Radni Napon'. Please enter valid numbers.");
            }
        }

        return null;
    }

    public static Radnik showEditRadnikDialog(Radnik radnik) {
        JTextField imeField = new JTextField(radnik.getIme());
        JTextField prezimeField = new JTextField(radnik.getPrezime());
        JTextField biografijaField = new JTextField(radnik.getBiografija());
        JTextField plataField = new JTextField(Double.toString(radnik.getPlata()));

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Ime:"));
        panel.add(imeField);
        panel.add(new JLabel("Prezime:"));
        panel.add(prezimeField);
        panel.add(new JLabel("Biografija:"));
        panel.add(biografijaField);
        panel.add(new JLabel("Plata:"));
        panel.add(plataField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Radnik", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                String biografija = biografijaField.getText();
                double plata = Double.parseDouble(plataField.getText());

                Radnik updatedRadnik = new Radnik(ime, prezime, biografija, plata);
                return updatedRadnik;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Plata'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static Menadzer showEditMenadzerDialog(Menadzer menadzer) {
        JTextField imeField = new JTextField(menadzer.getIme());
        JTextField prezimeField = new JTextField(menadzer.getPrezime());
        JTextField biografijaField = new JTextField(menadzer.getBiografija());
        JTextField plataField = new JTextField(Double.toString(menadzer.getPlata()));

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Ime:"));
        panel.add(imeField);
        panel.add(new JLabel("Prezime:"));
        panel.add(prezimeField);
        panel.add(new JLabel("Biografija:"));
        panel.add(biografijaField);
        panel.add(new JLabel("Plata:"));
        panel.add(plataField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Menadzer", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                String biografija = biografijaField.getText();
                double plata = Double.parseDouble(plataField.getText());

                Menadzer updatedRadnik = new Menadzer(ime, prezime, biografija, plata, new ArrayList<>());
                return updatedRadnik;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Plata'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static Prodavac showEditProdavacDialog(Prodavac prodavac) {
        JTextField imeField = new JTextField(prodavac.getIme());
        JTextField prezimeField = new JTextField(prodavac.getPrezime());
        JTextField biografijaField = new JTextField(prodavac.getBiografija());
        JTextField plataField = new JTextField(Double.toString(prodavac.getPlata()));
        JTextField odsustvoField = new JTextField(prodavac.getOdsustva());
        JTextField primedbeField = new JTextField(prodavac.getPrimedbe());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Ime:"));
        panel.add(imeField);
        panel.add(new JLabel("Prezime:"));
        panel.add(prezimeField);
        panel.add(new JLabel("Biografija:"));
        panel.add(biografijaField);
        panel.add(new JLabel("Plata:"));
        panel.add(plataField);
        panel.add(new JLabel("Odsustvo:"));
        panel.add(odsustvoField);
        panel.add(new JLabel("Primedbe:"));
        panel.add(primedbeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Prodavac", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String ime = imeField.getText();
                String prezime = prezimeField.getText();
                String biografija = biografijaField.getText();
                double plata = Double.parseDouble(plataField.getText());
                Integer odsustvo = Integer.parseInt(odsustvoField.getText());
                String primedbe = primedbeField.getText();

                Prodavac updatedProdavac = new Prodavac(ime, prezime, biografija, plata, odsustvo, primedbe);
                return updatedProdavac;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Plata'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static Roba showEditRobaDialog(Roba roba) {
        JTextField nazivField = new JTextField(roba.getNaziv());
        JTextField cenaField = new JTextField(Double.toString(roba.getCena()));
        JTextField modelField = new JTextField(roba.getModel());
        JTextField jedinicaMereField = new JTextField(roba.getJedinicaMere());
        JTextField proizvodjacField = new JTextField(roba.getProizvodjac());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Naziv:"));
        panel.add(nazivField);
        panel.add(new JLabel("Cena:"));
        panel.add(cenaField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Jedinica Mere:"));
        panel.add(jedinicaMereField);
        panel.add(new JLabel("Proizvodjac:"));
        panel.add(proizvodjacField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Roba", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String naziv = nazivField.getText();
                double cena = Double.parseDouble(cenaField.getText());
                String model = modelField.getText();
                String jedinicaMere = jedinicaMereField.getText();
                String proizvodjac = proizvodjacField.getText();

                Roba updatedRoba = new Roba(naziv, cena, model, jedinicaMere, proizvodjac);
                return updatedRoba;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Cena'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static RobaOgranicenogTrajanja showEditRobaOgranicenogTrajanjaDialog(
            RobaOgranicenogTrajanja robaOgranicenogTrajanja) {
        JTextField nazivField = new JTextField(robaOgranicenogTrajanja.getNaziv());
        JTextField cenaField = new JTextField(Double.toString(robaOgranicenogTrajanja.getCena()));
        JTextField modelField = new JTextField(robaOgranicenogTrajanja.getModel());
        JTextField jedinicaMereField = new JTextField(robaOgranicenogTrajanja.getJedinicaMere());
        JTextField proizvodjacField = new JTextField(robaOgranicenogTrajanja.getProizvodjac());
        JTextField rokTrajanjaField = new JTextField(robaOgranicenogTrajanja.getRokTrajanja());
        JTextField uputstvoField = new JTextField(robaOgranicenogTrajanja.getUputstvoZaSkladistenje());

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Naziv:"));
        panel.add(nazivField);
        panel.add(new JLabel("Cena:"));
        panel.add(cenaField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Jedinica Mere:"));
        panel.add(jedinicaMereField);
        panel.add(new JLabel("Proizvodjac:"));
        panel.add(proizvodjacField);
        panel.add(new JLabel("Rok Trajanja:"));
        panel.add(rokTrajanjaField);
        panel.add(new JLabel("Uputstvo za Skladistenje:"));
        panel.add(uputstvoField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit RobaOgranicenogTrajanja",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String naziv = nazivField.getText();
                double cena = Double.parseDouble(cenaField.getText());
                String model = modelField.getText();
                String jedinicaMere = jedinicaMereField.getText();
                String proizvodjac = proizvodjacField.getText();
                String rokTrajanja = rokTrajanjaField.getText();
                String uputstvo = uputstvoField.getText();

                RobaOgranicenogTrajanja updatedRobaOgranicenogTrajanja = new RobaOgranicenogTrajanja(naziv, cena, model,
                        jedinicaMere, proizvodjac, rokTrajanja, uputstvo);
                return updatedRobaOgranicenogTrajanja;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for 'Cena'. Please enter a valid number.");
            }
        }

        return null;
    }

    public static TehnickaRoba showEditTehnickaRobaDialog(TehnickaRoba tehnickaRoba) {
        JTextField nazivField = new JTextField(tehnickaRoba.getNaziv());
        JTextField cenaField = new JTextField(Double.toString(tehnickaRoba.getCena()));
        JTextField modelField = new JTextField(tehnickaRoba.getModel());
        JTextField jedinicaMereField = new JTextField(tehnickaRoba.getJedinicaMere());
        JTextField proizvodjacField = new JTextField(tehnickaRoba.getProizvodjac());
        JTextField nominalnaSnagaField = new JTextField(Double.toString(tehnickaRoba.getNominalnaSnaga()));
        JTextField radniNaponField = new JTextField(Double.toString(tehnickaRoba.getRadniNapon()));
        JTextField bojaField = new JTextField(tehnickaRoba.getBoja());

        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(new JLabel("Naziv:"));
        panel.add(nazivField);
        panel.add(new JLabel("Cena:"));
        panel.add(cenaField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Jedinica Mere:"));
        panel.add(jedinicaMereField);
        panel.add(new JLabel("Proizvodjac:"));
        panel.add(proizvodjacField);
        panel.add(new JLabel("Nominalna Snaga:"));
        panel.add(nominalnaSnagaField);
        panel.add(new JLabel("Radni Napon:"));
        panel.add(radniNaponField);
        panel.add(new JLabel("Boja:"));
        panel.add(bojaField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit TehnickaRoba", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String naziv = nazivField.getText();
                double cena = Double.parseDouble(cenaField.getText());
                String model = modelField.getText();
                String jedinicaMere = jedinicaMereField.getText();
                String proizvodjac = proizvodjacField.getText();
                double nominalnaSnaga = Double.parseDouble(nominalnaSnagaField.getText());
                double radniNapon = Double.parseDouble(radniNaponField.getText());
                String boja = bojaField.getText();

                TehnickaRoba updatedTehnickaRoba = new TehnickaRoba(naziv, cena, model, jedinicaMere, proizvodjac,
                        nominalnaSnaga, radniNapon, boja);
                return updatedTehnickaRoba;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input for 'Cena', 'Nominalna Snaga', or 'Radni Napon'. Please enter valid numbers.");
            }
        }

        return null;
    }

    
}
