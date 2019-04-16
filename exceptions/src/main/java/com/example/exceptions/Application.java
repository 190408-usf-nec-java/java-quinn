package com.example.exceptions;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to handle banking
 * @author quinn
 *
 */
public class Application {
	
	final static Logger logger = LogManager.getLogger(Application.class);
	
	private static String getUserInput() {
		String token = "";
		
		try (Scanner sc = new Scanner(System.in)) {
			token = sc.next();			
		} catch(NoSuchElementException e) {
			logger.catching(e);
		}

		return token;
	}

	
	
	/**
	 * Takes a string of input and converts to a Double
	 * 
	 * Handles exceptions involved
	 * @param input	The number in string format
	 * @return	This will be the number with buisness rules applied
	 * @throws IllegalArgumentException The String should be a valid double with no formatting
	 */
	public
	static Double convertToMoney(String input) throws IllegalArgumentException {
		logger.traceEntry(input);
		
		Double balence = 0.0;
		try {			
			balence = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			logger.catching(e);
			logger.error("Failed to format the string " + input + " to a number");
			throw new IllegalArgumentException("String should be a valid double");
		}	
		
		return logger.traceExit(balence);
	}
	
	public static Double getUserAccountBalence() {		
		Boolean inputSuccessful = false;
		Double balence = 0.0;
		
		while (!inputSuccessful) {			
			String userInput = getUserInput();
			
			try {			
				balence = convertToMoney(userInput);
			} catch (IllegalArgumentException e) {
				System.out.println("The number entered was not valid");
				continue;
			}
			
			inputSuccessful = true;
		}
		
		return balence;
	}
	
	public static void main(String[] args) {	
		Double balence = getUserAccountBalence();
		System.out.println(balence);
	}
}
