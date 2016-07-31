package com.eshop;

public class ShippingService {
    public static final int TODAY = 1;
    public static final int NEXT_DAY = 2;
    public static final int REGULAR = 3;

    public ShippingService(int cost, int deliveryEstimate) {
        this.cost = cost;
        this._deliveryEstimate = deliveryEstimate;
    }

    private int cost;

    public int getDeliveryEstimate() {
        return _deliveryEstimate;
    }

    public void setDeliveryEstimate(int deliveryEstimate) {
        this._deliveryEstimate = deliveryEstimate;
    }

    private int _deliveryEstimate;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

	public double getCharge(int itemSize) {
		double result = 0;
		//determine amounts for purchase line
		switch (getDeliveryEstimate()) {
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

	public int getCustomerPoints() {
		//Add bonus for Today delivery estimate
		if (_deliveryEstimate == ShippingService.TODAY) {
			return 2;
		} else {
			return 1;
		}
	}
}
