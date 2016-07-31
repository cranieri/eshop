package com.eshop;

public class ShippingService {
    public static final int TODAY = 1;
    public static final int NEXT_DAY = 2;
    public static final int REGULAR = 3;

    public ShippingService(int cost, int deliveryEstimate) {
        this.cost = cost;
        this.deliveryEstimate = deliveryEstimate;
    }

    private int cost;

    public int getDeliveryEstimate() {
        return deliveryEstimate;
    }

    public void setDeliveryEstimate(int deliveryEstimate) {
        this.deliveryEstimate = deliveryEstimate;
    }

    private int deliveryEstimate;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
