package com.manga42.ambiguous.core;

public interface Convertor<O, I, IC extends Convertor<I,?,?>> {

	public O convert();
}
