package com.order;


import com.newcommon.DataManagement;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.time.LocalDate;

import java.util.Scanner;

public class OrderM extends DataManagement {
    private String headerColumn[] = new String[] {"SL. No","Customer Name ","Total QTY", "Total price","Date", "Phone Number" };
    private  Object data[][];
    File orderListFile = new File("./orderlist.txt");
    
    
    public Object[][] getData(){ //reads the line number first then get the data by the line for table only
        try{
            Scanner sc = new Scanner(orderListFile);
            
            int len = -1;
            LineNumberReader lineNumberReader = new LineNumberReader( new FileReader(orderListFile));
            lineNumberReader.skip(Long.MAX_VALUE);
            len = lineNumberReader.getLineNumber();
            lineNumberReader.close();
            

            
            data = new Object[len][6];
            for(int i = 0; sc.hasNextLine(); i++){
                data[i]=readData(orderListFile, sc);
            }

            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public String[] getHeaderColumn(){return this.headerColumn;}
    
    public void addToOrderData(String customerName ,int totalP, int totalQ, String phoneNumber){
        LocalDate currDate = LocalDate.now();
        String totalPrice = Integer.toString(totalP);
        String totalQty = Integer.toString(totalQ);
        addData(getLineNumber(orderListFile)+1, customerName, totalQty, totalPrice,currDate.toString(), phoneNumber , orderListFile);
    }
}


