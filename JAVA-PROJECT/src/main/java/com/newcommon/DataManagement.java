package com.newcommon;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

import java.lang.Exception;

public class DataManagement {
    private String data[];

    // to get the line number
    public int getLineNumber(File inventoryFile) {
        int len = -1;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(inventoryFile));
            lineNumberReader.skip(Long.MAX_VALUE);
            len = lineNumberReader.getLineNumber();
            lineNumberReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return len;
    }

    public void addData(int SlNo, String name, String b_price, String s_price, String qty, String data6, File newFile) { // add data to file by tab and new line ----6 data variant
                                                                                                           
                                                                                                           
        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile, true);
            writer.write(SlNo + "\t" + name + "\t" + b_price + "\t" + s_price + "\t" + qty +"\t"+data6+ "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(int SlNo, String name, String b_price, String s_price, String qty, File newFile) { // add data to file by tab and new line ----5 data variant
                                                                                                           
                                                                                                           
        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile, true);
            writer.write(SlNo + "\t" + name + "\t" + b_price + "\t" + s_price + "\t" + qty + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(String data1, String data2, String data3, String data4, File newFile) { // add data to file by tab and new line ----- 4 data variant 
                                                                                                

        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile, true);
            writer.write(data1 + "\t" + data2 + "\t" + data3 + "\t" + data4 + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addData(String data1, String data2, File newFile) { // add data to file by tab and new line) ------ 2 data variant
                                                                 

        try {
            newFile.createNewFile();
            FileWriter writer = new FileWriter(newFile, true);
            writer.write(data1 + "\t" + data2 + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] readData(File newFile, Scanner sc) { // reads data by line, has to use in a loop

        try {

            String tempData = sc.nextLine();
            data = tempData.split("\t");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void modifyData(String newName, String newBuyingPrice, String newSellingPrice, String newQty,
            String oldData[], File Datafile, Scanner sc)
            throws IOException {
        File tmpfile = new File("./tempfile.txt");
        FileWriter writer = new FileWriter(tmpfile);

        while (sc.hasNextLine()) {
            data = readData(Datafile, sc);
            if (!newName.isEmpty()) {
                if (data[1].equals(oldData[1])) {
                    data[1] = newName;
                }
            }
            if (!newBuyingPrice.isEmpty()) {
                if (data[2].equals(oldData[2])) {
                    data[2] = newBuyingPrice;
                }
            }
            if (!newSellingPrice.isEmpty()) {
                if (data[3].equals(oldData[3])) {
                    data[3] = newSellingPrice;
                }
            }

            if (!newQty.isEmpty()) {
                if (data[4].equals(oldData[4])) {
                    data[4] = newQty;
                }
            }

            addData(getLineNumber(tmpfile) + 1, data[1], data[2], data[3], data[4], tmpfile);
        }
        sc.close();
        writer.close();
        System.out.println(Datafile.exists());
        System.out.println(Datafile.delete());

        System.out.println(tmpfile.renameTo(Datafile));

    }

    public String[] checkOldData(String name, File dataFile) {

        try {
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                data = readData(dataFile, sc);
                if (data[1].equals(name)) {
                    break;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public String[] checkOldData(String name, File dataFile, int dataPosition) {

        try {
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                data = readData(dataFile, sc);
                if (data[dataPosition].equals(name)) {
                    break;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean boolCheckOldData(String name, File dataFile) {
        boolean flag = false;
        try {
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNextLine()) {
                data = readData(dataFile, sc);
                if (data[1].equals(name)) {
                    flag = true;
                    break;
                }
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void deleteData(String toBeDeleteData[],File dataFile){
        try {
            Scanner sc = new Scanner(dataFile);
            File tmpFile = new File("./tempFile.txt");
            tmpFile.createNewFile();
            while (sc.hasNextLine()) {
                data=readData(dataFile, sc);
                if (data[1].equals(toBeDeleteData[1])) {
                    continue;
                }
                else{
                    addData(getLineNumber(tmpFile)+1, data[1], data[2], data[3], data[4], tmpFile);
                }
            }
          
            
            sc.close();
            dataFile.delete();
            tmpFile.renameTo(dataFile);
            //tmp1.renameTo(dataFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
