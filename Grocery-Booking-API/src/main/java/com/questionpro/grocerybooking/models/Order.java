package com.questionpro.grocerybooking.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "ORDER_GROCERY_MAPPING", 
				joinColumns = @JoinColumn(name = "order_id"), 
        	inverseJoinColumns = @JoinColumn(name = "grocery_id"))
	private List<Grocery> groceries = new ArrayList<>();
	
	private int totalAmount;
	
	public Order() {
	}

	public Order(int id, User user, List<Grocery> groceries, int totalAmount) {
		super();
		this.id = id;
		this.user = user;
		this.groceries = groceries;
		this.totalAmount = totalAmount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Grocery> getGroceries() {
		return groceries;
	}

	public void setGroceries(List<Grocery> groceries) {
		this.groceries = groceries;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	

}
