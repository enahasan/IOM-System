package com.inventory;

import com.newcommon.*;
import java.io.File;
import java.util.Scanner;

public class InventoryM extends DataManagement {
    // table related data
    private String headerColumn[] = new String[] { "SL", "Item Name ", "Buying Price", "Selling Price",
            "Available Quantity" };
    private Object data[][];
    File inventoryFile = new File("./inventoryFile.txt");

    

    public Object[][] getData() { // reads the line number first then get the data by the line
        try {
            Scanner sc = new Scanner(inventoryFile);

            int len = getLineNumber(inventoryFile);

            data = new Object[len][5];
            for (int i = 0; sc.hasNextLine(); i++) {
                data[i] = readData(inventoryFile, sc);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public void addToInventoryData(String name, String b_price, String s_price, String qty ) {

        addData(getLineNumber(inventoryFile)+1, name, b_price, s_price, qty, inventoryFile);

    }
    public void modifyInventory(){

    }

}
