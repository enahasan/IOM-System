package com.auth;

import java.io.File;
import java.util.Scanner;

import com.newcommon.*;

public class Authentication {

    private String Username, password;

    public Authentication(String Username, String Password) {
        this.Username = Username;
        this.password = Password;
    }

    public boolean verify() {
        boolean flag = false;
        try {
            File datafile = new File("./admin.txt");
            datafile.createNewFile();

            Scanner sc = new Scanner(datafile);
            DataManagement dtm = new DataManagement();
            while (sc.hasNextLine()) {
                String data[] = dtm.readData(datafile, sc);
                if (data[0].equals(Username) && data[1].equals(password)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return flag;
    }

    public boolean customerVerify() {
        boolean flag = false;
        File datafile = new File("./user.txt");

        try {
            datafile.createNewFile();
            Scanner sc = new Scanner(datafile);
            DataManagement dtm = new DataManagement();
            while (sc.hasNextLine()) {
                String data[] = dtm.readData(datafile, sc);
                if (data[0].equals(Username) && data[1].equals(password)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean addAccount() {
        boolean flag = false;
        try {
            File datafile = new File("./customer.txt");
            datafile.createNewFile();
            DataManagement dtm = new DataManagement();
            if (customerVerify() == !true) {

                 dtm.addData(Username, password, datafile);
                 flag = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return flag;
    }

    
    }

