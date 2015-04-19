package com.dudelson.brickhack15.know2.handler;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.dudelson.brickhack15.know2.dict.DictionaryQuery;
import com.dudelson.brickhack15.know2.dict.Word;
import com.dudelson.brickhack15.know2.main.Main;
import com.dudelson.brickhack15.know2.main.MajorEncoder;

/** This class is responsible for parsing input from the text field into
 * output for the text area. It sanitizes input, runs queries on the input,
 * and formats the results to the screen. May be broken into several smaller
 * classes in the future.
 * 
 * @author David Udelson
 *
 */
public class InputHandler implements ActionListener {
	
	/** Used to run queries against the dictionary */
	private DictionaryQuery dictQuery;
	
	public InputHandler(DictionaryQuery dq) {
		this.dictQuery = dq;
	}
	
	/** validates program input, returning true if the input string is a valid
	 * representation of a number (base 10).
	 * 
	 * @param input The input string to validate
	 * @return Whether the input string is a valid number
	 */
	private boolean isValidNumber(String input) {
		return Pattern.matches("^\\d+", input);
	}
	
	/** validates program input, returning true if the input string contains only
	 * lowercase letters.
	 * 
	 * @param input The input string to validate
	 * @return Whether the input is a string of all lowercase letters
	 */
	private boolean isValidString(String input) {
		return Pattern.matches("^[a-z]+", input);
	}

	/** Fetches input, validates it, runs a query against the dictionary, and
	 * formats the query response to the output panel. Strings can also be input,
	 * in which case debugging information about that string will be displayed if
	 * the string is a valid dictionary entry.
	 * @param e The ActionEvent to process
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String text = ((JTextField) e.getSource()).getText();
		String output = "";
		
		/* test code
		if(Pattern.matches("\\d+", text)) {
			String out = "";
			for(String s : MajorEncoder.encode(text)) out += s + "\n";
			Main.wordDisplay.setText(out);
		} else if(Pattern.matches("\\p{Lower}+", text)) {
			String out = MajorEncoder.toMajorEquiv(text);
			Main.wordDisplay.setText(out);
		}
		 */
		
		if(isValidNumber(text)) {
			ArrayList<String[]> searchStrings = MajorEncoder.encode(text);
			ArrayList<String> results = dictQuery.doQuery(searchStrings);
			
			// format output
			output = "Queried:\n";
			for(String[] s : searchStrings) {
				output += Arrays.toString(s) + " " + MajorEncoder.getEncodingHash(s) + "\n";
			}
			output += "Got:\n";
			for(String s : results) {
				output += s + "\n";
			}
		} else if(isValidString(text)) {
			Word w = dictQuery.findWord(text);
			if(w != null) {
				String number = MajorEncoder.decode(w.encoding);
				
				// format output
				output = w.word + "\n" + number + "\n" + Arrays.toString(w.encoding) +
						"\n" + MajorEncoder.getEncodingHash(w.encoding);
			}
		} else {
			output = "\"" + text + "\"" + " is not a valid number or phrase";
		}

        Main.wordDisplay.setText(output);
	}
}
