package com.questionpro.grocerybooking.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.grocerybooking.dto.GroceryRequest;
import com.questionpro.grocerybooking.models.Grocery;
import com.questionpro.grocerybooking.services.GroceryServicesImpl;

@RestController
@RequestMapping("v1/api/admin")
public class AdminResources {
	
	@Autowired
	GroceryServicesImpl groceryServicesImpl;
	
	@GetMapping("/view")
	public List<Grocery> viewAllGrocery() {
		List<Grocery> groceryList = groceryServicesImpl.findAll();
		return groceryList;
	}
	
	@PostMapping("/addGrocery")
	public ResponseEntity<String> addGrocery(@RequestBody GroceryRequest groceryReq) {
		int id = groceryServicesImpl.addGrocery(groceryReq);
		return ResponseEntity.ok("Post request successful with id "+id);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeGrocery(@PathVariable String id) {
		groceryServicesImpl.deleteGrocery(id);
		return ResponseEntity.ok("delete request successful");
	}
	
	@PutMapping("/editGrocery/{id}")
	public ResponseEntity<String> editGrocery(@PathVariable String id, @RequestBody GroceryRequest groceryReq) {
		groceryServicesImpl.editGrocery(groceryReq, id);
		return ResponseEntity.ok("Update request successful");
	}

}
