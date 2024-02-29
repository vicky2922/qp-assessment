package com.questionpro.grocerybooking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.grocerybooking.dto.OrderRequest;
import com.questionpro.grocerybooking.dto.OrderResponse;
import com.questionpro.grocerybooking.models.Grocery;
import com.questionpro.grocerybooking.services.GroceryServicesImpl;
import com.questionpro.grocerybooking.services.OrderServiceImpl;

@RestController
@RequestMapping("v1/api/user")
public class UserResources {

	@Autowired
	GroceryServicesImpl groceryServicesImpl;
	
	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@GetMapping("/view")
	public List<Grocery> viewAllGrocery() {
		List<Grocery> groceryList = groceryServicesImpl.findAll();
		return groceryList;
	}
	
	@PostMapping("/order")
	public ResponseEntity<OrderResponse> orderGrocery(@RequestBody OrderRequest orderReq) {
		OrderResponse orderResponse = orderServiceImpl.placeOrder(orderReq);
		return ResponseEntity.ok(orderResponse);
	}
}
