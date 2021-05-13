package com.olympic.cis143.m03.student.tacotruck.list;

import java.util.ArrayList;
import java.util.List;

import com.olympic.cis143.m03.student.tacotruck.Orders;
import com.olympic.cis143.m03.student.tacotruck.TacoImpl;

public class OrdersListImpl implements Orders {
	
	private List<TacoImpl> tacoOrders = new ArrayList<>();

	@Override
	public void addOrder(TacoImpl tacoOrder) {
		this.tacoOrders.add(tacoOrder);
		
	}

	@Override
	public boolean hasNext() {
		return !this.tacoOrders.isEmpty();
	}

	@Override
	public TacoImpl closeNextOrder() {
		return this.tacoOrders.remove(0);
	}

	@Override
	public int howManyOrders() {
		return this.tacoOrders.size();
	}
	
	

}
