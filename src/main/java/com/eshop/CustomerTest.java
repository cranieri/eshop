package com.eshop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import com.eshop.Customer;


/**
 * Created by cosimoranieri on 30/07/2016.
 */

public class CustomerTest {
    public static void main (String[] args) {
        Item item = new Item("pen", 10, Item.LARGE);
        ShippingService shippingServiceToday = new ShippingService(10, ShippingService.TODAY);
        Purchase purchase = new Purchase(shippingServiceToday, item);

        Customer customer = new Customer("cosimo");
        customer.addPurchases(purchase);

        System.out.println(customer.statement());
    }
}
