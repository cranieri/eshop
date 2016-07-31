package com.eshop;

/**
 * The amountFor method in the Customer class doesn't use anything of the Customer class.
 * We then us the MOVE METHOD technique to move the amountFor method to the Purchase class, since it uses data from this class.
 */
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

	public double amountFor(Purchase purchase) {
		double result = 0;
		//determine amounts for purchase line
		switch (purchase.getShippingService().getDeliveryEstimate()) {
			case ShippingService.TODAY:
				result += 3;
				if (purchase.getItem().getSize() == Item.LARGE) {
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
}
