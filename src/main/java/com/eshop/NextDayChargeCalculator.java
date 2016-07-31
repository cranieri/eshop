package com.eshop;

/**
 * Created by cranieri on 31/07/2016.
 */
public class NextDayChargeCalculator extends ChargeCalculator {

	public double getCharge(int itemSize) {
		return 2;
	}

	public int getCustomerPoints() {
		return 1;
	}
}
