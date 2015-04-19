package com.dudelson.brickhack15.know2.dict;

import java.util.Arrays;

import com.dudelson.brickhack15.know2.main.MajorEncoder;

/** Encapsulates an entry in the dictionary and its associated information */
public class Word {
	/** The word */
	public String word;
	/** The part of speech */
	public char partOfSpeech;
	/** The list of phonemes that the word reduces to under the Major System */
	public PhonemeList encoding; 
		
	public Word(String[] dictionaryEntry) {
		word = dictionaryEntry[0];
		partOfSpeech = dictionaryEntry[1].toCharArray()[0];
		encoding = MajorEncoder.removeUnusedPhonemes(Arrays.copyOfRange(
				dictionaryEntry, 2, dictionaryEntry.length));
	}
		
}

