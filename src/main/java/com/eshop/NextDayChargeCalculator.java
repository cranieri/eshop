package com.eshop;

/**
 * Created by cranieri on 31/07/2016.
 */
public class NextDayChargeCalculator extends ChargeCalculator {

	public double getCharge(int itemSize, int deliveryEstimate) {
		return 2;
	}
}
