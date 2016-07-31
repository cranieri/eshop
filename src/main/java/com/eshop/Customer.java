package com.eshop;

import java.util.Enumeration;
import java.util.Vector;

// We use EXTRACT METHOD to extract the customerPoints logic.
// We look at the locally scoped variables and we see we can pass the purchase variable
// And we can use an appending assignment to set the customer points
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
			customerPoints += purchase.getCustomerPoints();

			//Show figures for this purchase
			result += "\t" + purchase.getItem().getName() + "\t" + purchase.getItem().getPrice() + "\n";
			totalAmount += purchase.getItem().getPrice() + purchase.getCharge();
		}
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + customerPoints + " customer points";

		return result;
	}
}
