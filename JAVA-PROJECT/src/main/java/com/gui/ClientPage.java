package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.basket.BasketM;
import com.inventory.InventoryM;
import com.newcommon.DataManagement;
import com.order.OrderM;

public class ClientPage extends JFrame implements ActionListener{
    private JPanel panel2;
    private JFrame basket;
    private ImageIcon logo = new ImageIcon("./images/logo.png");
    private DefaultTableModel defTM;
    private JTable jt;
    private TableColumnModel clmModel;
    private JScrollPane js;
    private Font f1;
    private JLabel labelphone,labelname,label1,label2,label3,label4,label5,label6,label7,label8,label9,label10;
    private JTextField tf1;
    private JButton bt1,bt2,exitButton;
    private JComboBox cb;
    private boolean flag;
    private int totalPrice,totalQty;
    private String dataArray[];
    public ClientPage(String username){
        
        super("Welcome to Menev.Store");
        super.setSize( 900, 600); // (x, y, width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setIconImage(logo.getImage());
        DataManagement dtm = new DataManagement();
        dataArray = dtm.checkOldData(username,new File("./customerInfo.txt"), 0);

        basket = new JFrame("Basket");
        basket.setSize(400, 600);
        
        basket.setLocation(super.getX()+super.getWidth()+10, super.getY());
        basket.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        basket.setLayout(new BorderLayout());
        basket.setResizable(false);
        basket.setIconImage(logo.getImage());

        BasketM bm = new BasketM();
        defTM = new DefaultTableModel(bm.getData(),bm.getHeaderColumn());
        jt = new JTable(defTM){
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
        

        
        
        basket.add(js);
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.LIGHT_GRAY);

        f1 = new Font("Arial", Font.PLAIN, 20);

        label1 = new JLabel("Customer Name :");
        label1.setBounds(50,40,200,30);
        label1.setFont(f1);
        panel2.add(label1);

        labelname = new JLabel(dataArray[2]);
        labelname.setBounds(220,40,200,30);
        labelname.setFont(f1);
        panel2.add(labelname);

       

        label2 = new JLabel("Phone Number : ");
        label2.setBounds(50,100,200,30);
        label2.setFont(f1);
        panel2.add(label2);

        labelphone = new JLabel(dataArray[4]);
        labelphone.setBounds(220,100,200,30);
        labelphone.setFont(f1);
        panel2.add(labelphone);
		
		label3 = new JLabel("Quantity:");
        label3.setBounds(320,160,170,30);
        label3.setFont(f1);
        panel2.add(label3);
		
		

        tf1 = new JTextField();
        tf1.setBounds(470, 160, 50, 30);
        panel2.add(tf1);
		
		
		bt1 = new JButton("Add");
        bt1.setBounds(600,160,100,30);
        bt1.setFocusable(false);
        bt1.addActionListener(this);
        panel2.add(bt1);
		
		
		
		

        label4 = new JLabel("Items :");
        label4.setBounds(50,160,200,30);
        label4.setFont(f1); 
        panel2.add(label4);

       

        label5 = new JLabel("Price :");
        label5.setBounds(50,200,200,30);
        label5.setFont(f1);
        panel2.add(label5);

        

        label6 = new JLabel("Total Items :");
        label6.setBounds(50,240,200,30);
        label6.setFont(f1);
        panel2.add(label6);

        label10 = new JLabel();
        label10.setBounds(165,240,200,30);
        label10.setFont(f1);
        panel2.add(label10);
		
		label7 = new JLabel("Total price :");
        label7.setBounds(350,240,200,30);
        label7.setFont(f1);
        panel2.add(label7);

        label9 = new JLabel();
        label9.setBounds(475,240,200,30);
        label9.setFont(f1);
        panel2.add(label9);


        InventoryM im = new InventoryM();
        Object temp[][] = im.getData();
        Object arr[] = new Object[im.getLineNumber(new File("./inventoryFile.txt"))];
        for(int i = 0; i<im.getLineNumber(new File("./inventoryFile.txt")); i++){
            Object obj=temp[i][1];
            arr[i]=obj;
        }
        
		cb = new JComboBox(arr);
		cb.setBounds(130,160,150,30);
        
        cb.addActionListener(this);
		panel2.add(cb);
		cb.setForeground(Color.BLUE);
		cb.setBackground(Color.WHITE);

        label8 = new JLabel();
        label8.setBounds(125,200,200,30);
        label8.setFont(f1);
        panel2.add(label8);

		
		
	

        bt2 = new JButton("Confrim");
        bt2.setBounds(400,400,100,30);
        bt2.setFocusable(false);
        bt2.addActionListener(this);
        panel2.add(bt2);

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 500, 200, 35);
        exitButton.addActionListener(this);

        super.add(exitButton);
        super.add(panel2);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            dispose();
            basket.dispose();
            System.exit(0);

        }
        else if(ae.getSource()== bt1){
            
            BasketM bm = new BasketM();
            InventoryM im = new InventoryM();
            Object temp[][] = im.getData();
            Object string[] =temp[cb.getSelectedIndex()];
            
            if (tf1.getText()==null) {
                JOptionPane.showMessageDialog(this, "Enter Quantity");
            }
            else{
                bm.addToBasketData(string[1].toString(), string[3].toString(), tf1.getText() );
                tf1.setText("");
            }
            defTM.setDataVector(bm.getData(), bm.getHeaderColumn());
            defTM.fireTableDataChanged();
            
            if(flag == false){
            basket.setVisible(true);
            flag = true;

            }
            
           try {
                Scanner sc = new Scanner(new File("./basket.txt"));
                DataManagement dtm = new DataManagement();
                while(sc.hasNextLine()){
                    String line[] = dtm.readData( new File("./basket.txt"), sc);
                    int price = Integer.parseInt(line[4]);
                    int qty = Integer.parseInt(line[3]);
                    totalQty +=qty;
                    totalPrice +=price;
                }
                label9.setText(Integer.toString(totalPrice));
                totalPrice =0;
                totalQty =0;
                int itemNum = dtm.getLineNumber(new File("./basket.txt"));
                label10.setText(Integer.toString(itemNum));
                sc.close();
                
            } 
            catch (Exception e) {
            e.printStackTrace();
            }

        }
        if(ae.getSource()==cb){
            InventoryM im = new InventoryM();
            Object temp[][] = im.getData();
            Object string = temp[cb.getSelectedIndex()][3];
            label8.setText(string.toString()); //determinig price
            
        }
        
        
        if (ae.getSource()==bt2) {
            String name = dataArray[2];
            String phoneNumber = dataArray[4];
            File basketFile = new File("./basket.txt");
            if (name.isEmpty()||phoneNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill up name and Phone Number");
            }else{
                OrderM om = new OrderM();
                
                try {
                    Scanner sc = new Scanner(new File("./basket.txt"));
                    DataManagement dtm = new DataManagement();
                    while(sc.hasNextLine()){
                        String line[] = dtm.readData( new File("./basket.txt"), sc);
                        int price = Integer.parseInt(line[4]);
                        int qty = Integer.parseInt(line[3]);
                        totalQty +=qty;
                        totalPrice +=price;
                    }
                    
                    
                    sc.close();
                    
                } 
                catch (Exception e) {
                e.printStackTrace();
                }
                om.addToOrderData(name, totalPrice, totalQty,phoneNumber);
                
                totalPrice =0;
                totalQty =0;
                label9.setText("");
                label10.setText("");
                String path ="./CustomerDataBase/"+name+"/" ;
                basket.dispose();
                flag= false;
                //<<-----data modify of inventory after order confirm------->>>

                File database = new File(path);
                database.mkdirs();
                
                
                try {
                    File check = new File(path+"basket.txt");
                    if (check.exists()==false) {
                        basketFile.renameTo(new File(path+"basket.txt"));
                    }
                    else{
                        File dir = new File(path);
                        File files[] = dir.listFiles();
                        int len = files.length;
                        basketFile.renameTo(new File(path+"basket"+len+".txt"));

                    }
                    basketFile.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    } 
}
