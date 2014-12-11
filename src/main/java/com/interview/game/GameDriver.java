package com.interview.game;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Driver class to test the working of GameEngine class
 * 
 * @author : Desmond E. Amadigwe
 * @Date : December 08 2014
 */
public class GameDriver {

	public static void main(String arg[]) throws IOException {
		// populate our assumed list of numbers
		int arrayOfNumbers[] = new int[10];
		int val = 1;
		for (int i = 0; i <= 9; i++) {
			arrayOfNumbers[i] = val++;
		}

		Scanner scanner = null;
		final GameEngine gameEngine = new GameEngine();
		scanner = new Scanner(new InputStreamReader(System.in));
		int targetNumber = Integer.MIN_VALUE;
		final int lowerPoint = 1;
		final int highestPoint = 10;
		System.out.println("Please type 'ready' when ready to play");

		try {
			String readyCommand = scanner.nextLine();
			if (readyCommand.equalsIgnoreCase("ready")) {
				System.out.println("Please enter your number.");
				targetNumber = scanner.nextInt();
				System.out.println("Entered number input: " + targetNumber);
				int searchResult = gameEngine.performBinarySearchNumberGuess(
						arrayOfNumbers, targetNumber, lowerPoint, highestPoint);
			} else {
				throw new RuntimeException(
						"Please start by typing 'ready' when ready to play");
			}
			scanner.close();
		} catch (NumberFormatException e) {
			scanner.close();
			System.exit(1);
		}

	}

}
