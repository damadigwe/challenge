package com.interview.game;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test class for GameEngine class.
 */
public class GameEngineTest {

	GameEngine gameEngine;

	@Before
	public void setUp() {
		gameEngine = new GameEngine();
	}

	/**
	 * Tears down the test fixture. (Called after every test case method.)
	 */
	@After
	public void tearDown() {
		gameEngine = null;
	}

	/*
	 * Test to verify that operation instructional message is as expected.
	 */
	@Test
	public void test_operational_manual_message() {
		StringBuilder manualMsgBuilder = new StringBuilder();
		manualMsgBuilder
				.append("Please enter a number between 1 and 10, and I will attempt guessing it.\n");
		manualMsgBuilder
				.append("Type 'Yes' if the answer is equal to my guess.\n");
		manualMsgBuilder
				.append("Type 'Lower' if the answer is lower than my guess.\n");
		manualMsgBuilder
				.append("Type 'Higher' if the answer is higher than my guess.\n");
		manualMsgBuilder.append("Type 'End' to end the program.\n");
		assertEquals(manualMsgBuilder.toString(),
				gameEngine.MESSAGE_OPERATION_MANUAL);

	}

	/*
	 * Test to verify that IllegalArgumentException is throw when array of
	 * numbers being used in program has no element in it.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_illegal_arrayOfNumbers() {
		// populate our assumed list of numbers
		int arrayOfNumbers[] = {};
		int targetNumber = 8;
		final int lowerPoint = 1;
		final int highestPoint = 10;

		try {
			gameEngine.performBinarySearchNumberGuess(arrayOfNumbers,
					targetNumber, lowerPoint, highestPoint);
		} catch (NumberFormatException e) {

			System.exit(1);
		}

	}

	/*
	 * Test to verify that IllegalArgumentException is throw when targetNumber (
	 * number held in mind by the user) is less than or equal to zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_illegal_targetNumber() {
		// populate our assumed list of numbers
		int arrayOfNumbers[] = new int[10];
		for (int i = 1; i <= 9; i++) {
			arrayOfNumbers[i] = i;
		}
		final int lowerPoint = 1;
		final int highestPoint = 10;
		final int targetNumber = 0;

		try {
			gameEngine.performBinarySearchNumberGuess(arrayOfNumbers,
					targetNumber, lowerPoint, highestPoint);
		} catch (NumberFormatException e) {
			System.exit(1);
		}

	}

	/*
	 * Test to verify that IllegalArgumentException is throw when lowerPoint (
	 * least element in the sorted array used in program) is less than or equal
	 * to zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_illegal_lowerPoint() {
		// populate our assumed list of numbers
		int arrayOfNumbers[] = new int[10];
		int val = 1;
		for (int i = 0; i <= 9; i++) {
			arrayOfNumbers[i] = val++;
		}

		final int lowerPoint = 0;
		final int highestPoint = 10;
		final int targetNumber = 8;
		try {
			gameEngine.performBinarySearchNumberGuess(arrayOfNumbers,
					targetNumber, lowerPoint, highestPoint);
		} catch (NumberFormatException e) {
			System.exit(1);
		}
	}

	/*
	 * Test to verify that IllegalArgumentException is throw when highestPoint (
	 * highest element in the sorted array used in program) is less than or
	 * equal to zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_illegal_highestPoint() {
		// populate our assumed list of numbers
		int arrayOfNumbers[] = new int[10];
		int val = 1;
		for (int i = 0; i <= 8; i++) {
			arrayOfNumbers[i] = val++;
		}
		arrayOfNumbers[9] = 0;
		final int lowerPoint = 1;
		final int highestPoint = 0;
		final int targetNumber = 8;
		try {
			gameEngine.performBinarySearchNumberGuess(arrayOfNumbers,
					targetNumber, lowerPoint, highestPoint);
		} catch (NumberFormatException e) {

			System.exit(1);
		}
	}

	// TODO - probably wrap a ByteArrayOutputStream in a PrintStream and look
	// for way to interactive test working of
	// the program - since we rely on System.out in this program. However, this
	// does not make it sound like unit test any more

}
