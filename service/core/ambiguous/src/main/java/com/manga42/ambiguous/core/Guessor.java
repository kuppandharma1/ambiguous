package com.manga42.ambiguous.core;

import com.manga42.ambiguous.core.guessors.GuessedData;

public interface Guessor<I, O> {
	
	public void guess(I input);

	public void sort();
	
	public GuessedData<I, O> nextGuess();
}
