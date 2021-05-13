package com.olympic.cis143.m02.student.tacotruck;

public interface Orders {
	
	void addOrder(TacoImpl tacoOrder);
	
	boolean hasNext();
	
	TacoImpl closeNextOrder();
	
	int howManyOrders();

}
