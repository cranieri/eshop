package com.eshop;

// To introduce the strategy patter I'll use 3 refactorings:
// Replace type code with strategy
// Move method to move getCharge to the PriceCalculator class
// Replace Conditional with polymorphism

public class ShippingService {
	private ShippingOption deliveryEstimate;

    private int cost;

	public ShippingOption getDeliveryEstimate() {
		return deliveryEstimate;
	}

	public void setDeliveryEstimate(ShippingOption deliveryEstimate) {
		this.deliveryEstimate = deliveryEstimate;
	}

    public int getCost() {
        return cost;
    }

	public ShippingService(int cost, ShippingOption deliveryEstimate) {
		this.cost = cost;
		this.deliveryEstimate = deliveryEstimate;

	}

    public void setCost(int cost) {
        this.cost = cost;
    }

	public double getCharge(int itemSize) {
		return deliveryEstimate.getCharge(itemSize);
	}

	public int getShippingPoints(int itemSize) {
		return deliveryEstimate.getShippingPoints(itemSize);
	}
}
