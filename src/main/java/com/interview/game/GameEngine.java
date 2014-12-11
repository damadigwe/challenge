package com.interview.game;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Description: Guessing game engine class
 * @Author: Desmond E. Amadigwe
 * @Date: Dec, 07 2014
 */
public class GameEngine {

	final static String MESSAGE_NO_NOT_FOUND = "No is not found in the list";
	final static String MESSAGE_YES = "Yes";
	final static String MESSAGE_HIGHER = "Higher";
	final static String MESSAGE_LOWER = "Lower";
	final static String MESSAGE_END = "End";
    String MESSAGE_OPERATION_MANUAL = "";// exposed for testing

	public GameEngine() {
		StringBuilder manualMsgBuilder = new StringBuilder();
		manualMsgBuilder.append("Please enter a number between 1 and 10, and I will attempt guessing it.\n");
		manualMsgBuilder.append("Type 'Yes' if the answer is equal to my guess.\n");
		manualMsgBuilder.append("Type 'Lower' if the answer is lower than my guess.\n");
		manualMsgBuilder.append("Type 'Higher' if the answer is higher than my guess.\n");
		manualMsgBuilder.append("Type 'End' to end the program.\n");
		MESSAGE_OPERATION_MANUAL = manualMsgBuilder.toString();
		System.out.println(manualMsgBuilder.toString());
	}
	
	/*
	 * Performs binary search( guess) of a number using iterative algorithm. This is the backbone of
	 * the guessing-game of our application. Since logic here is based on binary search algorith, it is expected
	 * that the running time of this falls with Log2N - ie Log base 2 N
	 * 
	 * Assumption : 
     * (1)Array of numbers being used for the program is sorted (since they are sequentially counted) - So working
	 * with binary search algorithm  is valid and possible
	 * (2)Only integer numbers are to be guessed
	 * 
	 * How the game this method drives works:
	 *	The user chooses a number in his mind and types "ready" to indicate to the computer that he is ready to begin playing.
	 *	The computer asks a series of questions to arrive at the number the user has in mind. 
	 *	The user can only respond with "higher", "lower" or "yes".
	 *	The game ends when the user responds with "yes" or "end".
	 *	Example: User chooses number 40 in his mind.
	 *	Computer: Is the number 30?
	 *	User: higher
	 *	Computer: Is the number 50?
	 *	User: lower
	 *	Computer: Is the number 35?
	 *	User: higher
	 *	Computer: Is the number 40?
	 *	User: yes
	 *
	 *@param arrayOfNumbers array of sorted integers being used for the guessing game ( cannot be empty)
	 *application throws IllegalArgumentException is the array has no elements
	 *@param targetNumber - number believed to be held in mind by the user - number computer will try to guess with least effort(cannot be less than or equal to zero)
	 *@param lowestPoint - lowest number in the sorted array the program is working with(cannot be less than or equal to zero)
	 *@param highestPoint - highest number in the sorted array the program is working with(cannot be less than or equal to zero)
	 */
	public int performBinarySearchNumberGuess(int arrayOfNumbers[], int targetNumber, int lowestPoint,  int highestPoint)
	{
	 
     if(arrayOfNumbers.length == 0)
     {
    	 throw new IllegalArgumentException("Input array is cannot be empty");
     }
     if(targetNumber <= 0)
     {
    	 throw new IllegalArgumentException("targetNumber cannot be less than or equal to zero");
     }
     if(lowestPoint <= 0)
     {
    	 throw new IllegalArgumentException("Input array lowestPoint element cannot be less than or equal to zero");
     }
     if(highestPoint <= 0)
     {
    	 throw new IllegalArgumentException("Input array lowestPoint element cannot be less than or equal to zero");
     }
     
	 final Scanner scanner = new Scanner(new InputStreamReader(System.in));
	  while (lowestPoint <= highestPoint)
	    {
		  // calculate the midpoint for roughly equal partition
		  int middlePoint = getMidPointOfNumbers(lowestPoint, highestPoint);
		
		  System.out.println("Is the number: "+middlePoint);
		  System.out.println("Answer Lower, Higher, or Yes");
		  String response = scanner.nextLine();
		  
		  
	      //if(arrayOfNumbers[middleNumber] == targetNumber)
		  //assuming the user will always say 'yes' when the number in his/her mind is equal to guessed number
	      if(response.equalsIgnoreCase(MESSAGE_YES))
	      {
				  System.out.println("Congratulation! You won");
				  System.out.println("Please type end to exit");
				  response = scanner.nextLine();
				  if(response.equalsIgnoreCase(MESSAGE_END)) {
					  System.out.println("End of game");
					  System.exit(0);
				  }
				  scanner.close();
	             return middlePoint; 
	      }
	      else if(response.equalsIgnoreCase(MESSAGE_LOWER))
	      {
	    	// change lowestPoint Number index to search lower sub array
	    	  highestPoint = middlePoint - 1; 
	      }
	      else if(response.equalsIgnoreCase(MESSAGE_HIGHER))
	      {
	    	    // change lowestPoint Number index to search upper sub array
	    	  lowestPoint = middlePoint + 1; 
	      }
	      else if(response.equalsIgnoreCase(MESSAGE_END)) {
	    	     System.out.println("End of game");
	    	     System.exit(0);
		  }
	      else 
	      {
	    	  System.out.println("Invalid response - Please answer Lower, Higher, Yes or End");
	      }

	    }
	  
	  scanner.close();
	  // key was not found
	  return Integer.MIN_VALUE; 

	}
	
	/*
	 *  Calculates the midpoint for roughly equal partition
	 */
	private int getMidPointOfNumbers(final int lowestPointNumber, final int highestPointNumer) 
	{
		 if(lowestPointNumber <= 0)
	     {
	    	 throw new IllegalArgumentException("Input array lowestPoint element cannot be less than or equal to zero");
	     }
	     if(highestPointNumer <= 0)
	     {
	    	 throw new IllegalArgumentException("Input array lowestPoint element cannot be less than or equal to zero");
	     }
		return lowestPointNumber + ((highestPointNumer - lowestPointNumber) / 2);
	}
	
	
	
}



