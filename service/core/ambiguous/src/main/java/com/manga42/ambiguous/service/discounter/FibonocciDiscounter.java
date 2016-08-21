package com.manga42.ambiguous.service.discounter;

import java.util.concurrent.atomic.AtomicInteger;

public class FibonocciDiscounter {
	
	private AtomicInteger count = new AtomicInteger(0);
	private FibonocciCounter counter = new FibonocciCounter();
	
	private double currentDiscount = 1;
	public double discount(){
		int userAccessCount = count.incrementAndGet();
		if(userAccessCount == counter.get()){
			currentDiscount *= 0.836;
			counter.next();
		};
		return currentDiscount;
	}
	
	public static void main(String []args){
		FibonocciDiscounter dis = new FibonocciDiscounter();
		
		int total = 10_000;
		double sum = 0.0;
		for(int i =0 ;i < total; i ++){
			double discount = dis.discount();
			System.out.println("" + i + " " + discount);
			
			sum += discount;
		}
		
		System.out.println("Average: " + (sum/total));
	}

}
