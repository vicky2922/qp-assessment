package com.questionpro.grocerybooking.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionpro.grocerybooking.dto.GroceryRequest;
import com.questionpro.grocerybooking.models.Grocery;
import com.questionpro.grocerybooking.repos.GroceryRepository;

@Service
public class GroceryServicesImpl {
	
	@Autowired
	GroceryRepository groceryRepository;

	public int addGrocery(GroceryRequest req) {
		Grocery grocery = new Grocery();
		grocery.setName(req.getName());
		grocery.setPrice(req.getPrice());
		grocery.setQuantity(req.getQuantity());
		grocery = groceryRepository.save(grocery);
		return grocery.getId();
	}

	public List<Grocery> findAll() {
		List<Grocery> groceryList = groceryRepository.findAll();
		return groceryList;
	}

	public void deleteGrocery(String id) {
		try {
			int gId = Integer.parseInt(id);
	 		groceryRepository.deleteById(gId);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Enterd id is not correct");
		}
	}

	public void editGrocery(GroceryRequest req, String id) {
		try {
			int gId = Integer.parseInt(id);
			Optional<Grocery> groceryOp = groceryRepository.findById(gId);
			if(groceryOp.isPresent()) {
				Grocery grocery = groceryOp.get();
				grocery.setName(req.getName());
				grocery.setPrice(req.getPrice());
				grocery.setQuantity(req.getQuantity());
				grocery = groceryRepository.save(grocery);
			} else {
				System.out.println("Throw exception, Grocery not found");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Enterd id is not correct");
		}
		
	}

}
