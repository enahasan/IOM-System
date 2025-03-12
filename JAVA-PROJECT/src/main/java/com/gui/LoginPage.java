package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

import java.awt.Insets;


import javax.swing.plaf.basic.BasicButtonUI;

import com.auth.Authentication;

public class LoginPage extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label1, label2, label3, label4;
    private JTextField tf;
    private JPasswordField pf;
    private JButton bt, bt1, closeButton;

    private ImageIcon img;
    private ImageIcon logo = new ImageIcon("./images/logo.png");

    public LoginPage() {
        super("Welcome");
        super.setBounds(225, 87, 900, 600); // (x, y, width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setIconImage(logo.getImage());
        ;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(900, 600); // set panel size

        label1 = new JLabel("Inventory & Order Management");
        label1.setFont(new Font("Arial", Font.BOLD, 35));
        label1.setBounds(220, 30, 700, 40);
        panel.add(label1);

        label2 = new JLabel("Username");
        label2.setBounds(320, 110, 300, 20);
        label2.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(label2);

        tf = new JTextField();
        tf.setBounds(440, 110, 130, 20);
        panel.add(tf);

        label3 = new JLabel("Password");
        label3.setBounds(320, 150, 300, 20);
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(label3);

        pf = new JPasswordField();
        pf.setBounds(440, 150, 130, 20);
        panel.add(pf);

        img = new ImageIcon("OOP1M.jpg");
        label4 = new JLabel(img);
        label4.setBounds(300, 50, 359, 279);
        panel.add(label4);

        bt = new JButton("Sign In") {

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0));
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };
        bt.setUI(new BasicButtonUI());
        bt.setMargin(new Insets(2, 2, 2, 2));
        bt.setFont(new Font("Arial", Font.BOLD, 12));
        bt.setBounds(450, 230, 90, 20);
        bt.addActionListener(this);
        panel.add(bt);

        bt1 = new JButton("Sign Up") {

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0));
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };
        bt1.setUI(new BasicButtonUI());
        bt1.setMargin(new Insets(2, 2, 2, 2));
        bt1.setFont(new Font("Arial", Font.BOLD, 12));
        bt1.setBounds(450, 260, 90, 20);
        bt1.addActionListener(this);
        panel.add(bt1);

        closeButton = new JButton("Exit") {

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0));
                g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
        };
        closeButton.setUI(new BasicButtonUI());
        closeButton.setMargin(new Insets(2, 2, 2, 2));
        closeButton.setFont(new Font("Arial", Font.BOLD, 12));
        closeButton.setBounds(450, 300, 90, 20); // Set position and size of the close button

        panel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the JFrame
            }
        });

        super.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt) {
            String username = tf.getText();
            String password = pf.getText();
            Authentication auth = new Authentication(username, password);
            if (auth.verify()) {
                JOptionPane.showMessageDialog(this, "Login Succesful");
                this.setVisible(false);
                Welcome wlc = new Welcome();
                wlc.setVisible(true);
            } else if (auth.customerVerify()) {
                JOptionPane.showMessageDialog(this, "Login Succesful");
                this.setVisible(false);
                ClientPage clp = new ClientPage(username);
                clp.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "UserName or Password Incorrect");
            }
        }
        else if (ae.getSource() == bt1) {
            this.setVisible(false);
            SignUp sgp = new SignUp();
            sgp.setVisible(true);
        }
    }
}
