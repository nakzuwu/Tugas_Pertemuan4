/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class DataKomputer implements AppInterface {
    private final Komputer[] komputer;
    private DefaultTableModel tableModel;
    private JTable table;

    public DataKomputer() {
        komputer = new Komputer[1000];
        initTable();
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        tableModel.addColumn("Nama");
        tableModel.addColumn("Model");
        tableModel.addColumn("Disk Type");
        tableModel.addColumn("Disk Size");
        tableModel.addColumn("RAM Size");
    }

    public void displayTable() {
        JScrollPane scrollPane = new JScrollPane(table);
        JOptionPane.showMessageDialog(null, scrollPane, "Data Komputer", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public int pilihanMenu() {
        String p = JOptionPane.showInputDialog(null,""
            + "<html>"
            + "=======Pilihan=================<br>"
            + "1 &rarr; Tambah Data Komputer<br>"
            + "2 &rarr; Cari berdasarkan Brand Komputer<br>"
            + "3 &rarr; Cari berdasarkan Model Komputer<br>"
            + "4 &rarr; Keluar Aplikasi<br>"
            + "================================<br>"
            + "<b>Ketik Pilihan Anda:</b>"
            + "</html>",
            "Menu Pilihan",
            JOptionPane.QUESTION_MESSAGE);
        int pilihan = Integer.parseInt(p);
        return pilihan;
    }

    @Override
    public void add() {
        Komputer kom = new Komputer ();
        String brand = JOptionPane.showInputDialog(null, "Ketik Brand: ", ""
            +"Brand", JOptionPane. QUESTION_MESSAGE);
        kom.setBrand (brand);
        String model = JOptionPane.showInputDialog(null, "Ketik Model:", "" 
            + "Model", JOptionPane. QUESTION_MESSAGE);
        kom.setModel (model);
        String disk = JOptionPane.showInputDialog(null, "Tipe Disk (SSD/Harddisk):",""
            + "Tipe Disk", JOptionPane.QUESTION_MESSAGE);
        kom.setDisk(disk);
        String size = JOptionPane.showInputDialog(null, "Kapasitas Disk (Angka):",""
            + "Kapasitas Disk (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int diskSize = Integer.parseInt(size);
        kom.setDiskSize(diskSize);
        String ram = JOptionPane.showInputDialog(null, "Kapasitas RAM (Angka):",""
            + "Ukuran RAM (dalam GB)", JOptionPane. QUESTION_MESSAGE);
        int ramSize = Integer.parseInt(ram); 
        kom.setRam (ramSize);
    
        for (int i = 0; i < komputer.length; i++) {
            if (komputer [i] == null) {
                komputer[i] = kom;
                break;
            }
        }
        
        viewData(kom);
        tableModel.addRow(new Object[]{kom.getBrand(), kom.getModel(), kom.getDisk(), kom.getDiskSize(), kom.getRam()});
        displayTable();
    }

    @Override
    public String keyboard(String type) {
        String key = JOptionPane.showInputDialog(null,
                "Ketik "+type+" komputer",
                type, JOptionPane.QUESTION_MESSAGE);
        return key;
    }


    @Override
    public Komputer searchByBrand(String brand) {
        Komputer komp = null;
        for (Komputer k : komputer) {
            if (k != null && k.getBrand().toLowerCase().contains(brand.toLowerCase())) {
                komp = k;
                break;
            }
        }
        return komp;
    }

    @Override
    public Komputer searchByModel(String model) {
        Komputer komp = null;
        for (Komputer k : komputer) {
            if (k != null && k.getModel().toLowerCase().contains(model.toLowerCase())) {
                komp = k;
                break;
            }
        }
        return komp;
    }
    @Override
    public void viewData(Komputer k) {
    if (k == null) {
        JOptionPane.showMessageDialog(null, "Data tidak Ditemukan");
    } else {
        JOptionPane.showMessageDialog(null,
                "brand\t\t: " + k.getBrand() +
                "\nModel\t\t: " + k.getModel() +
                "\nDisk Type\t: " + k.getDisk() +
                "\nDisk Size\t: " + k.getDiskSize() +
                "\nRAM Size\t: " + k.getRam(),
                "Data Komputer",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

    @Override
    public void exit() {
        System.exit(0);
    }
    
}
