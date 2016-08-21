package com.manga42.ambiguous.service.discounter;

import java.util.concurrent.atomic.AtomicInteger;

public class FibonocciCounter {
	private AtomicInteger prev = new AtomicInteger(1);
	private AtomicInteger curr = new AtomicInteger(1);
	
	
	public void next(){
		int newValue = prev.get() + curr.get();
		prev.set(curr.get());
		curr.set(newValue);
	}
	
	public int get(){
		return curr.get();
	}
}
