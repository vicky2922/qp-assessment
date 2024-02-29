package com.questionpro.grocerybooking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.grocerybooking.dto.OrderRequest;
import com.questionpro.grocerybooking.dto.OrderResponse;
import com.questionpro.grocerybooking.models.Grocery;
import com.questionpro.grocerybooking.models.Order;
import com.questionpro.grocerybooking.models.User;
import com.questionpro.grocerybooking.repos.GroceryRepository;
import com.questionpro.grocerybooking.repos.OrderRepository;
import com.questionpro.grocerybooking.repos.UserRepository;

@Service
public class OrderServiceImpl {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	GroceryRepository groceryRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	public OrderResponse placeOrder(OrderRequest orderReq) {
		Order order = new Order();
		OrderResponse response = new OrderResponse();
		Optional<User> user = userRepo.findById(orderReq.getUserId());
		if(user.isPresent()) {
			order.setUser(user.get());
		} else {
			System.out.println("Throw - User not found");
			return response;
		}
		List<Grocery> groceryList = new ArrayList<>();
		int finalAmount = 0;
		for (Integer g : orderReq.getGroceries()) {
			Optional<Grocery> groceryOp = groceryRepository.findById(g);
			if(groceryOp.isPresent()) {
				Grocery grocery = groceryOp.get();
				if(grocery.getQuantity()>0) {
					groceryList.add(grocery);
					finalAmount+=grocery.getPrice();
				} else {
					System.out.println("Throw - Quatity not available");
					return response;
				}
			} else {
				System.out.println("Throw - Grocery not found");
				return response;
			}
		}
		order.setGroceries(groceryList);
		order.setTotalAmount(finalAmount);
		
		Order savedOrder = orderRepository.save(order);
		
		
		response.setOrderId(savedOrder.getId());
		response.setFinalAmount(finalAmount);
		return response;
		
		
	}

}
