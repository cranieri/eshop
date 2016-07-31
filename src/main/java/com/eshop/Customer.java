package com.eshop;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by cosimoranieri on 30/07/2016.
 */
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
            double thisAmount = 0;
            Purchase each = (Purchase) purchases.nextElement();
            //determine amounts for each line
            switch (each.getShippingService().getDeliveryEstimate()) {
                case ShippingService.TODAY:
                    thisAmount += 3;
                    if (each.getItem().getSize() == Item.LARGE) {
                        thisAmount += 2;
                    }
                    break;
                case ShippingService.NEXT_DAY:
                    thisAmount += 2;
                    break;
                case ShippingService.REGULAR:
                    thisAmount += 1;
                    break;
            }
            //Add customer points
            customerPoints++;

            //Add bonus for Today delivery estimate
            if (each.getShippingService().getDeliveryEstimate() == ShippingService.TODAY) {
                customerPoints++;
            }

            //Show figures for this purchase
            result += "\t" + each.getItem().getName() + "\t" + each.getItem().getPrice() + "\n";
            totalAmount += each.getItem().getPrice() + thisAmount;
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + customerPoints + " customer points";

        return result;
    }
}
