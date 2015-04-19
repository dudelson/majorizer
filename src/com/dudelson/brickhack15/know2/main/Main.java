package com.dudelson.brickhack15.know2.main;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import com.dudelson.brickhack15.know2.dict.Dictionary;
import com.dudelson.brickhack15.know2.dict.DictionaryQuery;
import com.dudelson.brickhack15.know2.handler.InputHandler;

import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JScrollPane;

/** Main method and initialization
 * 
 * @author David Udelson
 *
 */
public class Main {
	private static final int WIDTH = 800;
	private static final int HEIGHT = WIDTH * 9 / 16;
	private static final String TITLE = "2Know2";

	private JFrame frame;

	public static JTextField txtEnterNumber;
	public static JTextArea wordDisplay;
	
	private Dictionary dict;
	private DictionaryQuery dictQuery;
	private InputHandler inputHandler;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(TITLE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Enter number: ");
		lblNewLabel.setBounds(38, 11, 88, 20);
		frame.getContentPane().add(lblNewLabel);

		txtEnterNumber = new JTextField();
		txtEnterNumber.setBounds(136, 11, 648, 20);
		frame.getContentPane().add(txtEnterNumber);
		txtEnterNumber.setColumns(7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 774, 369);
		frame.getContentPane().add(scrollPane);
		
		wordDisplay = new JTextArea();
		wordDisplay.setEditable(false);
		scrollPane.setViewportView(wordDisplay);
		wordDisplay.setRows(20);
		
		frame.pack();
		frame.setLocationRelativeTo(null); // has to go after pack() to actually center the window
		frame.setResizable(false);
		
		// non-gui init
		dict = new Dictionary();
		dictQuery = new DictionaryQuery(dict);
		
		txtEnterNumber.addActionListener(new InputHandler(dictQuery));
	}
}
