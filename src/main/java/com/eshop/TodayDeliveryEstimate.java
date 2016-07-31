package com.eshop;

/**
 * Created by cranieri on 31/07/2016.
 */
public class TodayDeliveryEstimate extends DeliveryEstimate {

	public double getCharge(int itemSize) {
		double result = 3;
		if (itemSize == Item.LARGE) {
			result += 2;
		}else if (itemSize == Item.MEDIUM) {
			result += 1;
		}

		return result;
	}

	public int getShippingPoints(int itemSize) {
		int result = 10;
		if (itemSize == Item.LARGE) {
			result += 5;
		}else if (itemSize == Item.MEDIUM) {
			result += 2;
		}

		return result;
	}
}
