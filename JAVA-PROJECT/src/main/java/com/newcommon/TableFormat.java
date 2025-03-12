package com.newcommon;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class TableFormat extends DataManagement {
    private String headerColumn[] = new String[] {"SL. No","Item Name ","Price", "Available Quantity"};
    private  Object data[][];
    File inventoryFile;
    
    
    public Object[][] getData(){ //reads the line number first then get the data by the line
        try{
            Scanner sc = new Scanner(inventoryFile);
            
            int len = -1;
            LineNumberReader lineNumberReader = new LineNumberReader( new FileReader(inventoryFile));
            lineNumberReader.skip(Long.MAX_VALUE);
            len = lineNumberReader.getLineNumber();
            lineNumberReader.close();
            

            
            data = new Object[len][4];
            for(int i = 0; sc.hasNextLine(); i++){
                data[i]=readData(inventoryFile, sc);
            }

            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public String[] getHeaderColumn(){return this.headerColumn;}
}
