package com.eshop;

// To introduce the strategy patter I'll use 3 refactorings:
// Replace type code with strategy
// Move method to move getCharge to the PriceCalculator class
// Replace Conditional with polymorphism

public class ShippingService {
    public ShippingService(int cost, ShippingOption deliveryEstimate) {
        _cost = cost;
		_deliveryEstimate = deliveryEstimate;

    }

    private int _cost;

	public ShippingOption getDeliveryEstimate() {
		return _deliveryEstimate;
	}

	public void setDeliveryEstimate(ShippingOption deliveryEstimate) {
		_deliveryEstimate = deliveryEstimate;
	}

	private ShippingOption _deliveryEstimate;

    public int getCost() {
        return _cost;
    }

    public void setCost(int cost) {
        this._cost = cost;
    }

	public double getCharge(int itemSize) {
		return _deliveryEstimate.getCharge(itemSize);
	}

	public int getShippingPoints(int itemSize) {
		return _deliveryEstimate.getShippingPoints(itemSize);
	}
}
