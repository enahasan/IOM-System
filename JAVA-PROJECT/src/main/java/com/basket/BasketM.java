package com.basket;

import com.newcommon.*;
import java.io.File;
import java.util.Scanner;

public class BasketM extends DataManagement {
    // table related data
    private String headerColumn[] = new String[] { "SL", "Item Name ", "Unit Price", "Qty",
            "Price" };
    private Object data[][];
    File basketFile = new File("./basket.txt");

    

    public Object[][] getData() { // reads the line number first then get the data by the line
        try {
            Scanner sc = new Scanner(basketFile);

            int len = getLineNumber(basketFile);

            data = new Object[len][5];
            for (int i = 0; sc.hasNextLine(); i++) {
                data[i] = readData(basketFile, sc);
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

    public void addToBasketData(String name, String unitPrice, String qty) {
        int uPrice = Integer.parseInt(unitPrice);
        int quantity = Integer.parseInt(qty);
        int price = uPrice*quantity;


        addData(getLineNumber(basketFile)+1, name, unitPrice, qty, Integer.toString(price), basketFile);

    }
    public void modifyInventory(){

    }

}
