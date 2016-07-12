package com.manga42.ambiguous.core.guessors;

import java.util.ArrayList;
import java.util.List;

import com.manga42.ambiguous.core.Guessor;

public class GuessorFactory {
	
	public static List<Guessor<String,?>> getStringInputGuessors(){
		List<Guessor<String, ?>> guessors = new ArrayList<>();
		guessors.add(new UnitsGuessor());
		return guessors;
	}

}
