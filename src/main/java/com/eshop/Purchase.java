package com.eshop;

/**
 * Created by cosimoranieri on 30/07/2016.
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
}
