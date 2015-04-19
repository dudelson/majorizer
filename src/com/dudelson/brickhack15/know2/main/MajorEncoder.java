package com.dudelson.brickhack15.know2.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.dudelson.brickhack15.know2.dict.Phoneme;
import com.dudelson.brickhack15.know2.dict.PhonemeList;

/** Utility class to convert String representations of numbers into PhonemeLists
 * and PhonemeLists into String representations of numbers. All methods in this
 * class are static.
 * 
 * @author David Udelson
 */
public class MajorEncoder {
	/** The major system mapping from numbers to phonemes */
	private static Map<Integer, String[]> msNumberToLetter = new HashMap<Integer, String[]>();
	/** The major system mapping from phonemes to numbers */
	private static Map<String, Integer> msLetterToNumber = new HashMap<String, Integer>();
	
	// default value is most popular variant of major system
	static {
		msNumberToLetter.put(0, new String[]{Phoneme.PHONEME_S, Phoneme.PHONEME_Z});
		msNumberToLetter.put(1, new String[]{Phoneme.PHONEME_T, Phoneme.PHONEME_D, Phoneme.PHONEME_TH});
		msNumberToLetter.put(2, new String[]{Phoneme.PHONEME_N});
		msNumberToLetter.put(3, new String[]{Phoneme.PHONEME_M});
		msNumberToLetter.put(4, new String[]{Phoneme.PHONEME_R, Phoneme.PHONEME_ER, Phoneme.PHONEME_ER0, Phoneme.PHONEME_ER1, Phoneme.PHONEME_ER2});
		msNumberToLetter.put(5, new String[]{Phoneme.PHONEME_L});
		msNumberToLetter.put(6, new String[]{Phoneme.PHONEME_JH, Phoneme.PHONEME_SH, Phoneme.PHONEME_CH});
		msNumberToLetter.put(7, new String[]{Phoneme.PHONEME_K, Phoneme.PHONEME_G});
		msNumberToLetter.put(8, new String[]{Phoneme.PHONEME_F, Phoneme.PHONEME_V});
		msNumberToLetter.put(9, new String[]{Phoneme.PHONEME_B, Phoneme.PHONEME_P});
		
		msLetterToNumber.put(Phoneme.PHONEME_S, 0);
		msLetterToNumber.put(Phoneme.PHONEME_Z, 0);
		msLetterToNumber.put(Phoneme.PHONEME_T, 1);
		msLetterToNumber.put(Phoneme.PHONEME_D, 1);
		msLetterToNumber.put(Phoneme.PHONEME_N, 2);
		msLetterToNumber.put(Phoneme.PHONEME_M, 3);
		msLetterToNumber.put(Phoneme.PHONEME_R, 4);
		msLetterToNumber.put(Phoneme.PHONEME_ER, 4);
		msLetterToNumber.put(Phoneme.PHONEME_ER0, 4);
		msLetterToNumber.put(Phoneme.PHONEME_ER1, 4);
		msLetterToNumber.put(Phoneme.PHONEME_ER2, 4);
		msLetterToNumber.put(Phoneme.PHONEME_L, 5);
		msLetterToNumber.put(Phoneme.PHONEME_JH, 6);
		msLetterToNumber.put(Phoneme.PHONEME_SH, 6);
		msLetterToNumber.put(Phoneme.PHONEME_CH, 6);
		msLetterToNumber.put(Phoneme.PHONEME_K, 7);
		msLetterToNumber.put(Phoneme.PHONEME_G, 7);
		msLetterToNumber.put(Phoneme.PHONEME_F, 8);
		msLetterToNumber.put(Phoneme.PHONEME_V, 8);
		msLetterToNumber.put(Phoneme.PHONEME_P, 9);
		msLetterToNumber.put(Phoneme.PHONEME_B, 9);
	}
	
	/** Given the string representation of a number, return an array of arrays of phonemes.
	 * Each sublist contains a sequence of phoneme that represents the number, and
	 * the sublists together cover every possible encoding. 
	 * For example, if the input string is "17", this method will return
	 * {{P_T, P_K}, {P_T, P_G}, {P_D, P_K}, {P_D, P_G}, {P_TH, P_K}, {P_TH, P_G}}
	 * @param input A string representation of a number
	 * @return The major system representation of the number
	 */
	public static ArrayList<String[]> encode(String input) {
		System.out.println("Encode: working");
		ArrayList<String[]> output = new ArrayList<String[]>();

		for (char c : input.toCharArray()) {
			//System.out.println(output);
			String[] phonemes = msNumberToLetter.get(c - '0');

			if(output.size() == 0) {
				for(String phoneme : phonemes) {
					output.add(new String[]{phoneme});
				}
			} else {
				ArrayList<String[]> temp = new ArrayList<String[]>();
				for(String[] ss : output) {
					for(String p : phonemes) {
						String[] st = Arrays.copyOf(ss, ss.length+1);
						st[st.length-1] = p;
						temp.add(st);
					}
				}
				output = temp;
			}
		}
		
		return output;
	}
	
	/** Given a sequence of phonemes, return the string representation of the number
	 * equivalent under the major system
	 * @param input The array of phonemes
	 * @return A string representation of the major-system decoded number
	 */
	public static String decode(String[] input) {
		System.out.println("Decode: working...");
		String output = "";
		for(String phoneme : input) {
			System.out.println("processing " + phoneme);
			Integer i = msLetterToNumber.get(phoneme);
			if(i == null) continue;
			output += i;
		}
		System.out.println("Done!");
		return output;
	}
	
	/** Given a PhonemeList parsed out of the dictionary, return the PhonemeList
	 * with all phonemes not used under the current Major System removed
	 * 
	 * @param input The PhonemeList to process
	 * @return A PhonemeList identical to @input with all unused phonemes removed
	 */
	public static PhonemeList removeUnusedPhonemes(String[] input) {
		String[] ret = new String[100];
		Set<String> keys = msLetterToNumber.keySet();
		int i=0;
		for(String phoneme : input) {
			if(keys.contains(phoneme)) {
				ret[i++] = phoneme;
			}
		}
		
		return new PhonemeList(Arrays.copyOfRange(ret, 0, i));
	}

	/** Re-map the Major System to new values.
	 * 
	 * @param newVals The values to rebind
	 */
	public static void changeBinding(String[][] newVals) {
		assert newVals.length == 10;
		
		for(int i=0; i<10; ++i) {
			msNumberToLetter.put(i, newVals[i]);
			for(String s: newVals[i]) {
				msLetterToNumber.put(s, i);
			}
		}
	}
}
