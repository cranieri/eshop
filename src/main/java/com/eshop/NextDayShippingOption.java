package com.eshop;

/**
 * Created by cranieri on 31/07/2016.
 */
public class NextDayShippingOption extends ShippingOption {

	public double getCharge(int itemSize) {
		double result = 0;
		if (itemSize == Item.LARGE || (itemSize == Item.MEDIUM)) {
			result += 1;
		}
		return result;
	}

	public int getShippingPoints(int itemSize) {
		int result = 10;
		if (itemSize == Item.LARGE || (itemSize == Item.MEDIUM)) {
			result += 2;
		}

		return result;
	}
}
