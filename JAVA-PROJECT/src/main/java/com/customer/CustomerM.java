package com.customer;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

import com.newcommon.DataManagement;

public class CustomerM extends DataManagement{
    private String headerColumn[] = new String[] {"SL. No","UserName ","Name", "Gender","Phone No","DOB"};
    private  Object data[][];
    File customerInfoFile = new File("./customerInfo.txt");
    
    
    public Object[][] getData(){ //reads the line number first then get the data by the line
        try{
            Scanner sc = new Scanner(customerInfoFile);
            
            int len = -1;
            LineNumberReader lineNumberReader = new LineNumberReader( new FileReader(customerInfoFile));
            lineNumberReader.skip(Long.MAX_VALUE);
            len = lineNumberReader.getLineNumber();
            lineNumberReader.close();
            

            
            data = new Object[len][5];
            for(int i = 0; sc.hasNextLine(); i++){
                data[i]=readData(customerInfoFile, sc);
            }

            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public String[] getHeaderColumn(){return this.headerColumn;}
}
