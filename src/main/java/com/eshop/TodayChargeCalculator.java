package com.eshop;

/**
 * Created by cranieri on 31/07/2016.
 */
public class TodayChargeCalculator extends ChargeCalculator {

	public double getCharge(int itemSize) {
		double result = 3;
		if (itemSize == Item.LARGE) {
			result += 2;
		}

		return result;
	}

	public int getCustomerPoints() {
		return 2;
	}
}
