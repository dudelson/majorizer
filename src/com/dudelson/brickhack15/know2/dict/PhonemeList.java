package com.dudelson.brickhack15.know2.dict;

import java.util.ArrayList;
import java.util.Iterator;

/** Represents a list of phonemes */
public class PhonemeList<E> extends ArrayList<E> {
	/** The list of phonemes */
	private String[] phonemeList;
	/** An iterator over the list of phonemes */
	
	
	public PhonemeList() {
		phonemeList = null;
	}
	
	public PhonemeList(String[] phonemes) {
		phonemeList = phonemes;
	}
	
	public String[] getList() {
		return phonemeList;
	}


	/** Converts a PhonemeList to an integer hashcode */
	public static int getEncodingHash(PhonemeList encoding) {
		String temp = "";
		for(String phoneme : encoding) temp += phoneme;
		
		return temp.hashCode();
	}
	
}
