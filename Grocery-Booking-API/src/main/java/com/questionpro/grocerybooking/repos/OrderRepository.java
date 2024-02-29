package com.questionpro.grocerybooking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionpro.grocerybooking.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
