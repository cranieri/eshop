package com.eshop;

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
		double result = 0;
		//determine amounts for purchase line
		switch (getShippingService().getDeliveryEstimate()) {
			case ShippingService.TODAY:
				result += 3;
				if (getItem().getSize() == Item.LARGE) {
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
		if (getShippingService().getDeliveryEstimate() == ShippingService.TODAY) {
			return 2;
		} else {
			return 1;
		}
	}
}
