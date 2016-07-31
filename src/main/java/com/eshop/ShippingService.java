package com.eshop;

// To introduce the strategy patter I'll use 3 refactorings:
// Replace type code with strategy
// Move method to move getCharge to the PriceCalculator class
// Replace Conditional with polymorphism

public class ShippingService {
    public ShippingService(int cost, DeliveryEstimate chargeCalculator) {
        _cost = cost;
		_chargeCalculator = chargeCalculator;

    }

    private int _cost;

    private int _deliveryEstimate;

	public DeliveryEstimate getChargeCalculator() {
		return _chargeCalculator;
	}

	public void setChargeCalculator(DeliveryEstimate chargeCalculator) {
		_chargeCalculator = chargeCalculator;
	}

	private DeliveryEstimate _chargeCalculator;

    public int getCost() {
        return _cost;
    }

    public void setCost(int cost) {
        this._cost = cost;
    }

	public double getCharge(int itemSize) {
		return _chargeCalculator.getCharge(itemSize);
	}

	public int getShippingPoints(int itemSize) {
		return _chargeCalculator.getShippingPoints(itemSize);
	}
}
