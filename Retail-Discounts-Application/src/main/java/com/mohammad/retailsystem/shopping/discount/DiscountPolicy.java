package com.mohammad.retailsystem.shopping.discount;

/*
 * Interface for Overall Discount Policy for all items of cart
 */
public interface DiscountPolicy {
	double applyDiscount(double totalAmount);
}
