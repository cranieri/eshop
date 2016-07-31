package com.eshop;

abstract class ShippingOption {
	abstract double getCharge(int itemSize);
	abstract int getShippingPoints(int itemSize);
}
