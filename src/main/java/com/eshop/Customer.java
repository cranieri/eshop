package com.eshop;

import java.util.Enumeration;
import java.util.Vector;

//Remove thisAmount by using Remove temp with query
public class Customer {
    private String name;
    private Vector _purchases = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addPurchases(Purchase purchase) {
        _purchases.add(purchase);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String statement() {
        double totalAmount = 0;
        int customerPoints = 0;
        Enumeration purchases = _purchases.elements();
        String result = "Purchase Record for " + getName() + "\n";
        while (purchases.hasMoreElements()) {
            Purchase purchase = (Purchase) purchases.nextElement();

            //Add customer points
            customerPoints++;

            //Add bonus for Today delivery estimate
            if (purchase.getShippingService().getDeliveryEstimate() == ShippingService.TODAY) {
                customerPoints++;
            }

            //Show figures for this purchase
            result += "\t" + purchase.getItem().getName() + "\t" + purchase.getItem().getPrice() + "\n";
            totalAmount += purchase.getItem().getPrice() + purchase.getCharge();
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + customerPoints + " customer points";

        return result;
    }
}
