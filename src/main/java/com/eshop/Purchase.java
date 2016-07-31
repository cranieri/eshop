package com.eshop;

// It's a bad idea to do a switch statement based on an attribute of another object
// In the case of the switch contained in this class we use the delivery estimate (from the ShippingService class)
// To calculate the customer charge

// getCharge() uses 2 types of information: the ShippingService delivery estimate (TODAY, NEXT_DAY etc..) and the _item size.
// Why the _item size to the shipping service rather than the ShippingService delivery estimate to the purchase?
// Cause we think the delivery estimates can change more frequently


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
		//Add bonus for Today delivery estimate
		if (getShippingService().getDeliveryEstimate() == ShippingService.TODAY) {
			return 2;
		} else {
			return 1;
		}
	}
}
