package com.manga42.ambiguous.core.guessors;

public class GuessedData<I, O>{

	public final double confidence;
	public final I input;
	public final O output;
	
	public GuessedData(double confidence, I input, O output){
		this.confidence = confidence;
		this.input = input;
		this.output = output;
	}
}
