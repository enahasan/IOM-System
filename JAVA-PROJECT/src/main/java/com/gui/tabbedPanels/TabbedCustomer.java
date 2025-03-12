package com.gui.tabbedPanels;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumnModel;

import com.customer.CustomerM;
import com.gui.Welcome;


public class TabbedCustomer extends JFrame implements ActionListener{
    private JPanel panel1;
    private JTable jt;
    private DefaultTableModel DefTM;
    private TableColumnModel clmModel;
    private JScrollPane js;
    private JButton exitButton;
    private ImageIcon logo = new ImageIcon("./images/logo.png");    

    public TabbedCustomer(){
        super("Customer");
        super.setSize(900,600);
        super.setLocationRelativeTo(null);//appear the Jframe in center of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setIconImage(logo.getImage());

        

        CustomerM cm = new CustomerM();

        DefTM = new DefaultTableModel(cm.getData(), cm.getHeaderColumn());
        jt = new JTable(DefTM) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jt.setRowSelectionAllowed(true);
        clmModel = jt.getColumnModel();
        clmModel.getColumn(0).setPreferredWidth(30);
        clmModel.getColumn(1).setPreferredWidth(90);
        clmModel.getColumn(2).setPreferredWidth(50);
        clmModel.getColumn(3).setPreferredWidth(50);
        clmModel.getColumn(4).setPreferredWidth(90);
        jt.getTableHeader().setResizingAllowed(false);
        jt.getTableHeader().setReorderingAllowed(false);

        js = new JScrollPane(jt);

        panel1 = new JPanel(new BorderLayout());
        panel1.setSize(900, 500);

        panel1.add(js);
       

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 490, 200, 35);
        exitButton.addActionListener(this);

        super.add(exitButton);

        super.add(panel1);

        



    }
    public void actionPerformed(ActionEvent ae){
       if (ae.getSource() == exitButton) {
            dispose();
            Welcome wlc = new Welcome();
            wlc.setVisible(true);

        }
    }
}