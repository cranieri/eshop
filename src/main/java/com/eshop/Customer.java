package com.eshop;

import java.util.Enumeration;
import java.util.Vector;

// Extract customerPoints calculation into a separate method: getShippingPoints

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
		Enumeration purchases = _purchases.elements();
		String result = "Purchase Record for " + getName() + "\n";
		while (purchases.hasMoreElements()) {
			Purchase purchase = (Purchase) purchases.nextElement();
			//Show figures for this purchase
			result += "\t" + purchase.getItem().getName() + "\t" + purchase.getItem().getPrice() + "\n";
		}
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getCustomerPoints() + " customer points";

		return result;
	}

	private double getTotalCharge() {
		double totalAmount = 0;
		Enumeration purchases = _purchases.elements();
		while (purchases.hasMoreElements()) {
			Purchase purchase = (Purchase) purchases.nextElement();
			totalAmount += purchase.getItem().getPrice() + purchase.getCharge();
		}
		return totalAmount;
	}

	private int getCustomerPoints() {
		int customerPoints = 0;
		Enumeration purchases = _purchases.elements();
		while (purchases.hasMoreElements()) {
			Purchase purchase = (Purchase) purchases.nextElement();
			customerPoints += purchase.getCustomerPoints();
		}
		return customerPoints;
	}
}
