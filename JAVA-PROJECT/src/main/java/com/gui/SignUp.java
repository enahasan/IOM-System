	package com.gui;
	import javax.swing.*;

import com.customer.CustomerM;

import java.awt.event.*;
import java.io.File;
import java.awt.*;


	public class SignUp extends JFrame implements ActionListener,MouseListener{
		JLabel firstnamelbl,surnamelbl,username,phoneormaillbl,passlbl,repasslbl,dbirthlbl,genderlbl,text1,text2,label;
		JTextField firstnameTF,surnameTF,phoneormaillTF,dbirthTF,genderTF, unTF;
		JPasswordField passPF,repassTF;
		JCheckBox male,female;
		ButtonGroup bGroup;
		JButton signButton,clearButton;
		JPanel panel;
		Color myColor;
		Font myFont,font2;
		Cursor c1;
		private ImageIcon logo = new ImageIcon("./images/logo.png");
		
		public SignUp()
		{
			super("Create New Account");
			super.setLayout(null);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			super.setLocationRelativeTo(null);
			super.setResizable(false);
			super.setSize(550, 500);
			super.setIconImage(logo.getImage());
			

			
			myColor =new Color(192,192,192);
			myFont = new Font("Arial", Font.PLAIN, 20);
			font2 = new Font("Arial", Font.PLAIN, 30);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setSize(650,600);
			panel.setBackground(myColor);


			text1 = new JLabel("Sign Up ");
			text1.setBounds(200, 20, 160, 40);
			text1.setBackground(myColor);
			text1.setOpaque(true);
			text1.setForeground(Color.BLACK);
			text1.setFont(font2);
			panel.add(text1);
				
			firstnamelbl = new JLabel("Name :");
			firstnamelbl.setBounds(50, 100, 190, 30);
			firstnamelbl.setBackground(Color.GRAY);
			firstnamelbl.setOpaque(false);
			firstnamelbl.setFont(myFont);
			panel.add(firstnamelbl);
		
			firstnameTF = new JTextField();
			firstnameTF.setBounds(170, 100, 190, 30);
			firstnameTF.setBackground(Color.WHITE);
			panel.add(firstnameTF);
		
			
			
			username = new JLabel("Username :");
			username.setBounds(50, 140, 190, 30);
			username.setBackground(Color.GRAY);
			username.setOpaque(false);
			username.setFont(myFont);
			panel.add(username);
		
			unTF = new JTextField();
			unTF.setBounds(170, 140, 190, 30);
			unTF.setBackground(Color.WHITE);
			panel.add(unTF);

			genderlbl =new JLabel("Gender");
			genderlbl.setBounds(50, 190, 300, 40);
			
			genderlbl.setOpaque(false);
			genderlbl.setFont(myFont);
			panel.add(genderlbl);


			male=new JCheckBox("Male");
			male.setBounds(145, 195, 70, 30);
			male.setOpaque(false);
			male.setFont(new Font("Arial", Font.PLAIN, 16));
			panel.add(male);

			female=new JCheckBox("Female");
			female.setOpaque(false);
			female.setBounds(225, 195, 80, 30);
			female.setFont(new Font("Arial", Font.PLAIN, 16));
			panel.add(female);

			bGroup =new ButtonGroup();
			bGroup.add(male);
			bGroup.add(female);
			

			dbirthlbl = new JLabel("Date of Birth");
			dbirthlbl.setBounds(50, 235, 350, 35);
			dbirthlbl.setBackground(Color.GRAY);
			dbirthlbl.setOpaque(false);
			dbirthlbl.setFont(myFont);
			panel.add(dbirthlbl);

			dbirthTF = new JTextField();
			dbirthTF.setBounds(170, 235, 190, 30);
			dbirthTF.setBackground(Color.WHITE);
			panel.add(dbirthTF);

			label = new JLabel("dd/mm/yy");
			label.setBounds(370,235,120,35);
			label.setFont(new Font("Arial", Font.PLAIN, 16));
			panel.add(label);

			phoneormaillbl =new JLabel("Phone :");
			phoneormaillbl.setBounds(50, 275, 300, 40);
			phoneormaillbl.setBackground(Color.GRAY);
			phoneormaillbl.setOpaque(false);
			phoneormaillbl.setFont(myFont);
			panel.add(phoneormaillbl);

			phoneormaillTF = new JTextField();
			phoneormaillTF.setBounds(170, 275, 190, 30);
			phoneormaillTF.setBackground(Color.WHITE);
			panel.add(phoneormaillTF); 

			passlbl =new JLabel("New Password");
			passlbl.setBounds(50, 310, 160, 40);
			passlbl.setBackground(Color.GRAY);
			passlbl.setOpaque(false);
			passlbl.setFont(myFont);
			panel.add(passlbl);

			passPF = new JPasswordField();
			passPF.setBounds(195, 310, 190, 30);
			passPF.setEchoChar('*');
			panel.add(passPF); 

			repasslbl =new JLabel("Confirm Password");
			repasslbl.setBounds(50, 345, 300, 40);
			repasslbl.setBackground(Color.GRAY);
			repasslbl.setOpaque(false);
			repasslbl.setFont(myFont);
			panel.add(repasslbl);

			repassTF = new JPasswordField();
			repassTF.setBounds(230, 345, 190, 30);
			repassTF.setEchoChar('*');
			panel.add(repassTF); 
			

			c1 =new Cursor(Cursor.HAND_CURSOR);
			
			signButton = new JButton("Create Account");
			signButton.setCursor(c1);
			signButton.setBounds(150, 400, 200, 30);
			signButton.setBackground(Color.GREEN);
			signButton.setForeground(Color.BLACK);
			signButton.setOpaque(true);
			signButton.setEnabled(false);
			signButton.addMouseListener(this);
			signButton.addActionListener(this);
			panel.add(signButton);
			
		
			super.add(panel);
		}
		public void mouseClicked(MouseEvent me){}
		public void mousePressed(MouseEvent me){}
		public void mouseReleased(MouseEvent me){}
		
		
		public void mouseEntered(MouseEvent me){
			if(me.getSource()==signButton){
				signButton.setBackground(Color.BLUE);
				signButton.setForeground(Color.gray);
				signButton.setOpaque(true);
				String pass = passPF.getText();
				String passVerify = repassTF.getText();
				if (pass.equals(passVerify)) {
					signButton.setEnabled(true);
				}
				else{
					signButton.setEnabled(false);
					JOptionPane.showMessageDialog(this,"Passwords do no match please check again!");
				}
			}

		}
		public void mouseExited(MouseEvent me){
			if(me.getSource()==signButton){
				signButton.setBackground(Color.GREEN);
				signButton.setForeground(Color.BLACK);
				signButton.setOpaque(true);
			}

		}
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==signButton){
				String name = firstnameTF.getText();
				String userName = unTF.getText();
				String gender = null;
				if (male.isSelected()) {
					gender = male.getText();
				}
				else if(female.isSelected()){
					gender= female.getText();
				}
				String dob = dbirthTF.getText();
				String phone = phoneormaillTF.getText();
				String pass = passPF.getText();
				String passVerify = repassTF.getText();
				
				if(name.isEmpty()||userName.isEmpty()||gender.isEmpty()||dob.isEmpty()||phone.isEmpty()||pass.isEmpty()||passVerify.isEmpty()){
					JOptionPane.showMessageDialog(this, "Fillup the whole Form");
				}
				else{
					CustomerM cm = new CustomerM();
					cm.addData(userName,pass,new File("./user.txt"));
					cm.addData(cm.getLineNumber(new File("./customerInfo.txt"))+1,userName,name,gender,phone,dob,new File("./customerInfo.txt"));
				}
				JOptionPane.showMessageDialog(this, "Sign up Successful !");
				dispose();
				LoginPage lp = new LoginPage();
				lp.setVisible(true);

			}
		}
		
		
		
	}
