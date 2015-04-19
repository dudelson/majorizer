package com.dudelson.brickhack15.know2.dict;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.dudelson.brickhack15.know2.main.MajorEncoder;

/** Encapsulates a dictionary used to generate word suggestions. The dictionary
 * is a single plaintext file (but it may be generated from one or more pre-existing
 * dictionaries) in the following format:
 *               ...
 *       <word> <part of speech> <phoneme> [<phoneme> ...]
 *               ...
 *               
 * That is, a dictionary entry consists of the word (in lowercase letters), a
 * single uppercase character specifying the part of speech, and one or more
 * space separated phonemes. Valid parts of speech:
 *         
 *         N - Noun
 *         V - verb
 *         A - Adjective/adverb
 *         P - pronoun
 *         I - Interjection
 *         C - Contraction
 *         
 * Phonemes are defined in MajorEncoder.java
 * 
 * The dictionary provides a number of convenient data structures to facilitate
 * the retrieval of information:
 *  	
 *         <encodingDict> is a mapping from a PhonemeList to an ArrayList of 
 *             Word objects that match that PhonemeList. This is the primary
 *             lookup table.
 *         <posDict> is a mapping from a char representing a part of speech to a
 *             list of Word objects that match that part of speech.
 *         <wordDict> is a mapping from a string representing a word in the dictionary
 *             to its Word object (this mapping is one-to-one)
 *         
 * @author David Udelson
 *
 */
public class Dictionary {

	/** The default dictionary file to use if one is not specified in the constructor */
	private static final String DEFAULT_DICT_FILE = "c:/users/david/dropbox/final_dict.txt";
	
	/** mapping from a PhonemeList to an ArrayList<Word> of Word objects that match the PhonemeList */
	private Map<PhonemeList, List<Word>> encodingDict; 
	/** mapping from a char representing a part of speech to a list of Word objects that match that part of speech */
	private Map<Character, List<Word>> posDict; 
	/** mapping from a string representing a word in the dictionary to its Word object */
	private Map<String, Word> wordDict; 

	public Dictionary() {
		this(DEFAULT_DICT_FILE);
	}
	
	public Dictionary(String dict_file) {
		encodingDict = new HashMap<PhonemeList, ArrayList<Word>>();
		posDict = new HashMap<Character, ArrayList<Word>>();
		wordDict = new HashMap<String, Word>();

        load(new File(dict_file));
	}
	
	private void load(File infile) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(infile));
			String line;
			while((line = br.readLine()) != null) {
				String[] rawSplit = line.split(" ");
				Word w = new Word(rawSplit);
				
				// if a word has no relavant phonemes, don't add it to the dictionary
				if(w.encoding.length == 0) continue;

				System.out.print("Got: " + w.word + " " + w.partOfSpeech + " ");
				for(String phoneme : w.encoding) System.out.print(phoneme + " ");
				System.out.println("\n");
				
				dictionary.add(w);
			}
		} catch(IOException ex) {
			System.out.println("File read failed for " + infile.getName() + "!");
		} catch(Exception ex) {
			System.out.println("Unknown error!");
			System.out.println(ex.getMessage());
		}
	}
	
	public ArrayList<Word> getDictionary() {
		return dictionary;
	}
	
}
