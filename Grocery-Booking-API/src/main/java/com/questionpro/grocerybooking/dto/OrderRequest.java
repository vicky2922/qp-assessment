package com.questionpro.grocerybooking.dto;

import java.util.List;

public class OrderRequest {
	private List<Integer> groceries;
	private int userId;
	public OrderRequest() {
	}
	public OrderRequest(List<Integer> groceries, int userId) {
		this.groceries = groceries;
		this.userId = userId;
	}
	public List<Integer> getGroceries() {
		return groceries;
	}
	public void setGroceries(List<Integer> groceries) {
		this.groceries = groceries;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
