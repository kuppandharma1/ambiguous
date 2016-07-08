package com.manga42.ambiguous.core;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.manga42.ambiguous.core.guessors.GuessedData;
import com.manga42.ambiguous.core.guessors.GuessorFactory;

public class MainGuessor {

	private List<Guessor<String, ?>> guessors = new ArrayList<>();

	public String guess(String input) {
		guessors.addAll(GuessorFactory.getStringInputGuessors());
		StringTokenizer tokenizer = new StringTokenizer(input, " ");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			guessors.stream().forEach((guessor) -> guessor.guess(token));
		}

		guessors.stream().forEach((guessor) -> guessor.sort());

		List<GuessedData<?, ?>> result = guessors.stream().map((x) -> x.nextGuess()).collect(Collectors.toList());

		StringBuffer buff = new StringBuffer();
		result.stream().forEach((d) -> buff.append(d.output.toString()));
		return buff.toString();
	}

}
