package com.gl.caseStudy2;

import java.util.Objects;

public class OrderedItem implements Comparable<OrderedItem>{
	private String itemName;
	private String rate;
	private String orderQty;
	private String discountAmount;
	private String payAmount;
	public OrderedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderedItem(String itemName, String rate, String orderQty, String discountAmount, String payAmount) {
		super();
		this.itemName = itemName;
		this.rate = rate;
		this.orderQty = orderQty;
		this.discountAmount = discountAmount;
		this.payAmount = payAmount;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
	public String getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	@Override
	public String toString() {
		return  itemName + " " + rate + " " + orderQty + " "
				+ discountAmount + " " + payAmount ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedItem other = (OrderedItem) obj;
		return Objects.equals(itemName, other.itemName);
	}
	@Override
	public int compareTo(OrderedItem o) {
		
		return this.itemName.compareTo(o.itemName);
	}
	
	
	
	

}
