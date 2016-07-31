package com.eshop;

/**
 * Created by cranieri on 31/07/2016.
 */
public class ChargeCalculator {

	public double getCharge(int itemSize, int deliveryEstimate) {
		double result = 0;
		//determine amounts for purchase line
		switch (deliveryEstimate) {
			case ShippingService.TODAY:
				result += 3;
				if (itemSize == Item.LARGE) {
					result += 2;
				}
				break;
			case ShippingService.NEXT_DAY:
				result += 2;
				break;
			case ShippingService.REGULAR:
				result += 1;
				break;
		}
		return result;
	}
}
