package com.eshop;

import java.util.Enumeration;
import java.util.Vector;

// We extract the switch/case snippet into a separate method following the EXTRACT METHOD technique.
// We first see what are the local variables in scope of the snippet we are extracting.
// And then we pass as parameter the variable the doesn't change and we initialize and change thisAmount in the new method
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
			double thisAmount = purchase.amountFor(purchase);

            //Add customer points
            customerPoints++;

            //Add bonus for Today delivery estimate
            if (purchase.getShippingService().getDeliveryEstimate() == ShippingService.TODAY) {
                customerPoints++;
            }

            //Show figures for this purchase
            result += "\t" + purchase.getItem().getName() + "\t" + purchase.getItem().getPrice() + "\n";
            totalAmount += purchase.getItem().getPrice() + thisAmount;
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + customerPoints + " customer points";

        return result;
    }
}
