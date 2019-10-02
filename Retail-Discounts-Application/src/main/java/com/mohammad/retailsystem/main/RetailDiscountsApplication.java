package com.mohammad.retailsystem.main;

import org.springframework.boot.SpringApplication;
import com.mohammad.retailsystem.shopping.core.Cart;
import com.mohammad.retailsystem.shopping.core.Item;
import com.mohammad.retailsystem.shopping.core.ItemType;
import com.mohammad.retailsystem.shopping.core.Product;
import com.mohammad.retailsystem.shopping.core.User;
import com.mohammad.retailsystem.shopping.core.UserType;
import com.mohammad.retailsystem.shopping.discount.DiscountPolicy;
import com.mohammad.retailsystem.shopping.discount.ThresholdDiscount;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RetailDiscountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailDiscountsApplication.class, args);
		
	}
	
	@Bean 
	public void showCartDetail() {
		
		
		User employee = new User(UserType.EMPLOYEE, "John");
        Item groceryItem = new Product("Rice", 20, ItemType.GROCERY);
        Item otherItem = new Product("TV", 222, ItemType.OTHER);
        DiscountPolicy discountPolicy = new ThresholdDiscount();
        
        Cart cart = new Cart(employee, discountPolicy);
        cart.add(groceryItem, 4);
        cart.add(otherItem, 4);
        
        /* *  Total (20 * 4) + (222 * 4) = 968
         *  No discount on grocery items = 968 still
         *  After 30% discount on 4 other items totalling 888 = 701.6
         *  After 35 dollars off due to price over $700 = 666.59999 or 666.6 
         */
        System.out.println("Total Amount of cart -: "  + cart.total());  
	}

}
