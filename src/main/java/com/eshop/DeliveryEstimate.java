package com.eshop;

abstract class DeliveryEstimate {
	abstract double getCharge(int itemSize);
	abstract int getShippingPoints(int itemSize);
}
