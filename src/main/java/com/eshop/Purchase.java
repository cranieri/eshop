package com.eshop;

// Move getCustomerPoints to ShippingService class since it calculates the points
// based on the delivery estimate

public class Purchase {
	private ShippingService _shippingService;
	private Item _item;

	public Purchase(ShippingService shippingService, Item item) {
		this._shippingService = shippingService;
		this._item = item;
	}

	public ShippingService getShippingService() {
		return _shippingService;
	}

	public void setShippingService(ShippingService shippingService) {
		_shippingService = shippingService;
	}

	public Item getItem() {
		return _item;
	}

	public void setItem(Item item) {
		_item = item;
	}

	public double getCharge() {
		return _shippingService.getCharge(_item.getSize());
	}

	public int getCustomerPoints() {
		return _shippingService.getCustomerPoints();
	}
}
