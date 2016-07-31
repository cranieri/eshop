package com.eshop;

// To introduce the strategy patter I'll use 3 refactorings:
// Replace type code with strategy
// Move method to move getCharge to the PriceCalculator class
// Replace Conditional with polymorphism

public class ShippingService {
    public static final int TODAY = 1;
    public static final int NEXT_DAY = 2;
    public static final int REGULAR = 3;

    public ShippingService(int cost, int deliveryEstimate, ChargeCalculator chargeCalculator) {
        _cost = cost;
        _deliveryEstimate = deliveryEstimate;
		_chargeCalculator = chargeCalculator;

    }

    private int _cost;

    public int getDeliveryEstimate() {
        return _deliveryEstimate;
    }

    public void setDeliveryEstimate(int deliveryEstimate) {
        this._deliveryEstimate = deliveryEstimate;
    }

    private int _deliveryEstimate;

	public ChargeCalculator getChargeCalculator() {
		return _chargeCalculator;
	}

	public void setChargeCalculator(ChargeCalculator chargeCalculator) {
		_chargeCalculator = chargeCalculator;
	}

	private ChargeCalculator _chargeCalculator;

    public int getCost() {
        return _cost;
    }

    public void setCost(int cost) {
        this._cost = cost;
    }

	public double getCharge(int itemSize) {
		return _chargeCalculator.getCharge(itemSize, getDeliveryEstimate());
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
