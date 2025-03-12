package com.gui;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.basket.BasketM;
import com.gui.tabbedPanels.TabbedOrder;


public class Basket extends JFrame{
    private JPanel jp;
    private JTable jt;
    private JScrollPane js;
    private DefaultTableModel defTM;
    private TableColumnModel clmModel;

    private ImageIcon logo = new ImageIcon("./images/logo.png");
    public Basket(){
        super("Basket");
        super.setSize(400, 600);
        TabbedOrder to = new TabbedOrder();
        setLocation(to.getX()+to.getWidth()+10, to.getY());
        super.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        super.setLayout(new FlowLayout());
        super.setResizable(false);
        super.setIconImage(logo.getImage());

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
        

        jp = new JPanel();
        jp.add(js);
        super.add(js);

    }
   
}
