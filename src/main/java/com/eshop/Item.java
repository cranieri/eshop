package com.eshop;

/**
 * Created by cosimoranieri on 30/07/2016.
 */
public class Item {
    public static final int SMALL = 1;
    public static final int MEDIUM = 2;
    public static final int LARGE = 3;

    public Item(String name, int price, int size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    private String name;
    private int price;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
