package com.dudelson.brickhack15.know2.dict;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.dudelson.brickhack15.know2.main.MajorEncoder;

public class DictionaryQuery {
	
	private Dictionary dictionary;


	public DictionaryQuery(Dictionary d) {
		this.dictionary = d;
		
		System.out.print("Initializing data structures...");
		encodingDict = new HashMap<Integer, ArrayList<Word>>();
		posDict = new HashMap<Character, ArrayList<Word>>();
		wordDict = new HashMap<String, Word>();
		
        // insert word object into data structure
		//TODO: refactor Word so that it is usable outside of Dictionary
		for(Word w : dictionary.getDictionary()) {
			if(encodingDict.get(MajorEncoder.getEncodingHash(w.encoding)) == null) {
				encodingDict.put(MajorEncoder.getEncodingHash(w.encoding), new ArrayList<Word>());
			}
            encodingDict.get(MajorEncoder.getEncodingHash(w.encoding)).add(w);
               
            if(posDict.get(w.partOfSpeech) == null) {
            	posDict.put(w.partOfSpeech, new ArrayList<Word>());
            }
            posDict.get(w.partOfSpeech).add(w);
            
            wordDict.put(w.word, w);
		}
		System.out.println("Done!");
	}

	/** Given a array of arrays of phonemes, returns a list of words that conform
	 * to those patterns.
	 * @param searchStrings
	 * @return
	 */
	public ArrayList<String> doQuery(ArrayList<String[]> searchStrings) {
		ArrayList<String> ret = new ArrayList<String>();
		
		for(String[] ss : searchStrings) {
			// Arrays.hashcode is just the current implementation of hash keys
			// subject to change in the future
			ArrayList<Word> results = encodingDict.get(MajorEncoder.getEncodingHash(ss));

			if(results == null) continue;
			for(Word w : results) ret.add(w.word + " " + MajorEncoder.getEncodingHash(w.encoding));
		}
		
		return ret;
	}
	
	public Word findWord(String input) {
		return wordDict.get(input);
	}
}
