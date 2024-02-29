package com.questionpro.grocerybooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionpro.grocerybooking.models.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer>{

}
