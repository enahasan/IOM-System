package com.gui.tabbedPanels;

import java.awt.BorderLayout;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import com.gui.Welcome;
import com.inventory.*;

public class TabbedInventory extends JFrame implements ActionListener {
    private JPanel panel1, panel2, panel3, panel4;
    private JTextField tf, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9,tf10;
    private JLabel label, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11,label12,label13,label14,label15;
    private JTabbedPane tp;
    private JTable jt;
    private JScrollPane js;
    private JButton bt1, bt2,bt3,bt4, exitButton, saveButton;
    private TableColumnModel clmModel;
    private Font f1;
    private DefaultTableModel DefTM;
    private ImageIcon logo = new ImageIcon("./images/logo.png");

    public TabbedInventory() {
        super("Inventory");
        super.setSize(900, 600);
        super.setLocationRelativeTo(null);// appear the Jframe in center of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setIconImage(logo.getImage());
        

        // <<<<<<<<<<<<-----------Inventory Show by table part----------------->>>>>>
        tp = new JTabbedPane();

        InventoryM im = new InventoryM();

        DefTM = new DefaultTableModel(im.getData(), im.getHeaderColumn());
        jt = new JTable(DefTM) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jt.setRowSelectionAllowed(true);
        clmModel = jt.getColumnModel();
        clmModel.getColumn(0).setPreferredWidth(20);
        clmModel.getColumn(1).setPreferredWidth(180);
        clmModel.getColumn(2).setPreferredWidth(70);
        clmModel.getColumn(3).setPreferredWidth(70);
        clmModel.getColumn(4).setPreferredWidth(90);
        jt.getTableHeader().setResizingAllowed(false);
        jt.getTableHeader().setReorderingAllowed(false);

        js = new JScrollPane(jt);

        panel1 = new JPanel(new BorderLayout());
        panel1.setSize(900, 600);

        panel1.add(js);

        // <<<<---------------Add Inventory
        // Part--------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setSize(900, 600);

        label2 = new JLabel("Product Name");
        label2.setBounds(40, 40, 300, 30);
        label2.setFont(new Font("Arial", Font.PLAIN, 25));
        panel2.add(label2);

        tf = new JTextField();
        tf.setBounds(250, 40, 350, 30);
        panel2.add(tf);

        label = new JLabel("Buying Price");
        label.setBounds(40, 100, 300, 30);
        label.setFont(new Font("Arial", Font.PLAIN, 25));
        panel2.add(label);

        tf2 = new JTextField();
        tf2.setBounds(250, 100, 350, 30);
        panel2.add(tf2);

        label1 = new JLabel("Selling Price");
        label1.setBounds(40, 160, 300, 30);
        label1.setFont(new Font("Arial", Font.PLAIN, 25));
        panel2.add(label1);

        tf3 = new JTextField();
        tf3.setBounds(250, 160, 350, 30);
        panel2.add(tf3);

        label3 = new JLabel("Quantity");
        label3.setBounds(40, 220, 300, 30);
        label3.setFont(new Font("Arial", Font.PLAIN, 25));
        panel2.add(label3);

        tf4 = new JTextField();
        tf4.setBounds(250, 220, 350, 30);
        panel2.add(tf4);

        saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setBounds(400, 430, 100, 30);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        panel2.add(saveButton);

        // <<<<<<<-------------------Modify Inventory
        // part------------------->>>>>>>>>>>>>>>>>>>
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setSize(900, 600);

        f1 = new Font("Arial", Font.PLAIN, 25);

        label4 = new JLabel();
        label4.setText("Search Product");
        label4.setBounds(50, 40, 200, 30);
        label4.setFont(f1);
        panel3.add(label4);

        tf5 = new JTextField();
        tf5.setBounds(250, 40, 350, 30);
        panel3.add(tf5);

        label5 = new JLabel();
        label5.setText("Status : ");
        label5.setBounds(50, 100, 150, 30);
        label5.setFont(f1);
        panel3.add(label5);

        label6 = new JLabel();
        label6.setText("Found");
        label6.setBounds(150, 100, 130, 30);
        label6.setFont(f1);
        // panel3.add(label6);

        label7 = new JLabel();
        label7.setText("Not Found");
        label7.setBounds(150, 100, 130, 30);
        label7.setFont(f1);
        // panel3.add(label7);

        label8 = new JLabel();
        label8.setText("Alter Name");
        label8.setBounds(70, 160, 150, 30);
        label8.setFont(f1);
        panel3.add(label8);

        tf6 = new JTextField();
        tf6.setBounds(220, 160, 300, 30);
        panel3.add(tf6);

        label9 = new JLabel();
        label9.setText("Alter Selling Price");
        label9.setBounds(70, 220, 250, 30);
        label9.setFont(f1);
        panel3.add(label9);

        tf7 = new JTextField();
        tf7.setBounds(290, 220, 300, 30);
        panel3.add(tf7);

        label10 = new JLabel();
        label10.setText("Alter Buying Price");
        label10.setBounds(70, 280, 250, 30);
        label10.setFont(f1);
        panel3.add(label10);

        tf8 = new JTextField();
        tf8.setBounds(290, 280, 300, 30);
        panel3.add(tf8);

        label11 = new JLabel();
        label11.setText("Change Quantity");
        label11.setBounds(70, 340, 250, 30);
        label11.setFont(f1);
        panel3.add(label11);

        tf9 = new JTextField();
        tf9.setBounds(290, 340, 300, 30);
        panel3.add(tf9);

        bt1 = new JButton();
        bt1.setText("Search");
        bt1.setBounds(680, 40, 100, 30);
        bt1.setFocusable(false);
        bt1.addActionListener(this);
        panel3.add(bt1);

        bt2 = new JButton();
        bt2.setText("Save");
        bt2.setBounds(400, 430, 100, 30);
        bt2.setFocusable(false);
        bt2.setEnabled(false);
        bt2.addActionListener(this);
        panel3.add(bt2);
        //<<<<<-----------------------DELETE inventory-------------------->>>>>>
        panel4 = new JPanel();
        panel4.setLayout(null);
        panel4.setSize(900,600);

        label12 = new JLabel();
        label12.setText("Search Product");
        label12.setBounds(50,40,200,30);
        label12.setFont(f1);
        panel4.add(label12);

        tf10 = new JTextField();
        tf10.setBounds(250, 40, 350, 30);
        panel4.add(tf10);

        label13 = new JLabel();
        label13.setText("Status : ");
        label13.setBounds(50,100,150,30);
        label13.setFont(f1);
        panel4.add(label13);

        label14 = new JLabel();
        label14.setText("Found");
        label14.setBounds(150,100,130,30);
        label14.setFont(f1);
        //panel4.add(label14);

        label15 = new JLabel();
        label15.setText("Not Found");
        label15.setBounds(150,100,130,30);
        label15.setFont(f1);
        //panel4.add(label15);

        bt3 = new JButton();
        bt3.setText("Search");
        bt3.setBounds(680,40,100,30);
        bt3.setFocusable(false);
        bt3.addActionListener(this);
        panel4.add(bt3);

        bt4 = new JButton();
        bt4.setText("Delete Product");
        bt4.setBounds(380,200,140,30);
        bt4.setFocusable(false);
        bt4.setEnabled(false);
        bt4.addActionListener(this);
        panel4.add(bt4);

        tp.addTab("Show Inventory", panel1);
        tp.addTab("Add Inventory", panel2);
        tp.addTab("Modify Inventory", panel3);
        tp.addTab("Delete Inventory", panel4);

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 490, 200, 35);
        exitButton.addActionListener(this);

        super.add(exitButton);
        super.add(tp);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            dispose();
            Welcome wlc = new Welcome();
            wlc.setVisible(true);

        } else if (ae.getSource() == saveButton) {
            String name = tf.getText();
            String b_price = tf2.getText();
            String s_price = tf3.getText();
            String qty = tf4.getText();
            InventoryM im = new InventoryM();
            if (name.isEmpty() || b_price.isEmpty() || s_price.isEmpty() || qty.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Empty Field \nplease Fill out all the Fields");
            } else {
                im.addToInventoryData(name, b_price, s_price, qty);
                tf.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                DefTM.setDataVector(im.getData(), im.getHeaderColumn());
                DefTM.fireTableDataChanged();
            }

        } else if (ae.getSource() == bt1) {
            File inventoryFile = new File("./inventoryFile.txt");
            InventoryM im = new InventoryM();
            String name = tf5.getText();
            if (im.boolCheckOldData(name, inventoryFile)) {
                panel3.add(label6);
                bt2.setEnabled(true);
                panel3.remove(label7);

                super.repaint();
            } else {
                panel3.remove(label6);
                panel3.add(label7);
                bt2.setEnabled(false);
                super.repaint();
            }
        } else if (ae.getSource() == bt2) {
            String oldName = tf5.getText();
            String newName = tf6.getText();
            String newBuyingPrice = tf8.getText();
            String newSellingPrice = tf7.getText();
            String newQty = tf9.getText();
            File inventoryFile = new File("./inventoryFile.txt");
            InventoryM im = new InventoryM();
            String data[] = im.checkOldData(oldName, inventoryFile);

            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
            tf9.setText("");

            try {
                Scanner sc = new Scanner(inventoryFile);
                im.modifyData(newName, newBuyingPrice, newSellingPrice, newQty, data, inventoryFile, sc);
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DefTM.setDataVector(im.getData(), im.getHeaderColumn());
            DefTM.fireTableDataChanged();

        }
        else if (ae.getSource() == bt3) {
            File inventoryFile = new File("./inventoryFile.txt");
            InventoryM im = new InventoryM();
            String name = tf10.getText();

            if (im.boolCheckOldData(name, inventoryFile)) {
                panel4.add(label14);
                bt4.setEnabled(true);
                panel4.remove(label15);

                super.repaint();
            } else {
                panel4.remove(label14);
                panel4.add(label15);
                bt4.setEnabled(false);
                super.repaint();
            }
            
        }
        else if (ae.getSource()==bt4) {
            String name = tf10.getText();
            InventoryM im = new InventoryM();
            File dataFile = new File("./inventoryFile.txt");
            String dataa[]= im.checkOldData(name,dataFile);
            if (im.getLineNumber(dataFile)>1) {
                im.deleteData(dataa, dataFile);
                panel4.remove(label14);
                bt4.setEnabled(false);
                tf10.setText("");
            }else{
                JOptionPane.showMessageDialog(this, "Can not delete any more rows");
            }
            
            
            
            DefTM.setDataVector(im.getData(), im.getHeaderColumn());
            DefTM.fireTableDataChanged();
        }
    }
}
