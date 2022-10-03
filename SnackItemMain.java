package com.gl.caseStudy2;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnackItemMain {
	private static String floatToString(double value) {
		 String price=String.format(" %.2f",value );
		return price;
	
}
	public static String salesTaxCalculation(double billAmount) {
		Double salesTax;
		if(billAmount<=1000) {
			salesTax=billAmount*12.5;
		}
		else if (billAmount<=2500) {
			salesTax=billAmount*10;
		}
		else {
			salesTax=billAmount*7.5;
		}
		return salesTax.toString();
			
	}

	
	public static void main(String[] args) throws IOException {

		Scanner sc=new Scanner(System.in);
		

		System.out.println("Enter the Customer Name:");
		String name=sc.nextLine();
		
		System.out.println("Enter the number of item the customer purchases:");
		int num=Integer.parseInt(sc.nextLine());
		List <OrderedItem> myList=new ArrayList<OrderedItem>();
		for(int i=0;i<num;i++) {
			System.out.println("Enter name and quantity (comma separate format) of purchased item no:"
					+ (i+1));
			String input=sc.nextLine();
			String[] in=input.split(",");
			String iname=in[0];
			String quantity=in[1];
			
			ItemData id=new ItemData();
			SnackItem snackItem1=new SnackItem();
			if(id.isAvailable(iname)) {
				snackItem1=id.getItem(iname);
				String rate=snackItem1.getRate();
				String discountR=snackItem1.getDiscountRate();
				String disQty=snackItem1.getDiscountQty();
				Double payAmt=Double.parseDouble(rate)*Double.parseDouble(quantity);
				if(Double.parseDouble(quantity)>=Double.parseDouble(disQty)) {
				
				
				double disAmt=0.0;
				disAmt=payAmt*(Double.parseDouble(discountR)/100);
				payAmt=payAmt-disAmt;
			
				String discountAmt=floatToString(disAmt);
				String payableAmt=floatToString(payAmt);
				
				OrderedItem ord=new OrderedItem(iname,rate,quantity,discountAmt,payableAmt);
				myList.add(ord);
				}
				
			}
		}
			LocalDate billDate=LocalDate.now();
			System.out.println(name+"       "+billDate);
			
			
			String output=String.format("%-10s %-15s %-10s %-15s %-10s %-15s", "ITEM" ,"RATE","QUANTITY","PRICE","DISCOUNT","AMOUNT");
			System.out.println(output);
			
			
			Double billAmount=0.0;
			for (OrderedItem list:myList) {
				String name1=list.getItemName();
				String rate1=list.getRate();
				String quantity1=list.getOrderQty();
				
				SnackItem snack=ItemData.getItem(name1);
				Double price=Double.parseDouble(snack.getRate())*Double.parseDouble(quantity1);
				String discountA=list.getDiscountAmount();
				String payable=list.getPayAmount();
				billAmount+= Double.parseDouble(payable);
				String output1=String.format("%-10s %-15s %-10s %-15s %-10s %-15s", name1,rate1,quantity1,price,discountA,payable);
				System.out.println(output1);
			}
			String salesTax=salesTaxCalculation(billAmount);
			double total=billAmount+Double.parseDouble(salesTax);
			
			System.out.println("Bill Amount:"+billAmount);
			System.out.println("Add: Sales Tax:"+salesTax);
			System.out.println("Final Amount:"+total);
		
			
		
		    
	}

}
