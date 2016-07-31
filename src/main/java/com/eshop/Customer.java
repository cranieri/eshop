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
            Purchase each = (Purchase) purchases.nextElement();
			double thisAmount = amountFor(each);

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

	private double amountFor(Purchase each) {
		double thisAmount = 0;
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
		return thisAmount;
	}
}
