package com.eshop;

public class RegularChargeCalculator extends ChargeCalculator {

	public double getCharge(int itemSize) {
		return 1;
	}

	public int getCustomerPoints() {
		return 1;
	}
}
