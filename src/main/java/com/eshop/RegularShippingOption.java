package com.eshop;

public class RegularShippingOption extends ShippingOption {

	public double getCharge(int itemSize) {
		double result = 0;
		if (itemSize == Item.LARGE) {
			result += 1;
		}
		return result;
	}

	public int getShippingPoints(int itemSize) {
		int result = 5;
		if (itemSize == Item.LARGE) {
			result += 2;
		}else if (itemSize == Item.MEDIUM) {
			result += 1;
		}

		return result;
	}
}
