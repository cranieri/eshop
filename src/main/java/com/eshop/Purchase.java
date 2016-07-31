package com.eshop;

// Move getShippingPoints to ShippingService class since it calculates the points
// based on the delivery estimate

public class Purchase {
	private ShippingService shippingService;
	private Item item;

	public Purchase(ShippingService shippingService, Item item) {
		this.shippingService = shippingService;
		this.item = item;
	}

	public ShippingService getShippingService() {
		return shippingService;
	}

	public void setShippingService(ShippingService shippingService) {
		this.shippingService = shippingService;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getCharge() {
		return shippingService.getCharge(item.getSize());
	}

	public int getCustomerPoints() {
		return shippingService.getShippingPoints(item.getSize());
	}
}
