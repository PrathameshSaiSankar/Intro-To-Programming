/* SELF ASSESSMENT 
 
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5.
Comment: I used the correct method definition.
Did I create an array of size n (passed as the parameter) and initialize it?
Mark out of 5: 5.
Comment: I created an array of size n (passed as the parameter) and initialized it.
Did I return the correct item?
Mark out of 5: 5.
Comment: I returned the correct item. 

   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5.
Comment: I used the correct method definition.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2: 2.
Comment: I ensured the parameters are not null and one of them is a valid index into the array
Did I loop through the array using the correct multiple?
Mark out of 5: 5.
Comment:I looped through the array using the correct multiple.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3.
Comment: I crossed out correct items in the array that were not already crossed out.

   3.  sieve   
Did I have the correct function definition?
Mark out of 5: 5.
Comment: I had the correct function definition?
Did I make calls to other methods?
Mark out of 5: 5.
Comment: I called other methods within my function.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2.
Comment:I returned an array with all non-prime numbers are crossed out.

   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5.
Comment: I had the correct function definition?
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: I ensured the parameter to be used is not null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10.
Comment:    I Looped through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets.
  
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5.
Comment: I had the correct function definition.
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3.
Comment: I ensured the parameter to be used is not null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5.
Comment: I looped through the array updating the String variable with just the non-crossed out numbers.
   
   6.  main  
Did I ask the user for input n and handles input errors?  
Mark out of 5: 5.
Comments: I asked the user for input n and handles input errors?  
Did I make calls to other methods (at least one)?
Mark out of 5: 5.
Comment:  I made calls to other methods in the main.
Did I print the output as shown in the question?  
Mark out of 5: 5.
Comment:  I printed the output as the question asked.
  
   7.  Overall
Is my code indented correctly?
Mark out of 4: 4.
Comments: My code is indented properly.
Do my variable names make sense?
Mark out of 4: 2
Comments: The majority of my variable names make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 3
Comments: My variable names, method names and class name follow the Java coding standard to the best of my ability.
      Total Mark out of 100 (Add all the previous marks):  97
*/

package primeNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class sieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter int >= 2: ");
		int N = inputScanner.nextInt();
		double m = Math.sqrt(N);
		int squaredNumber = (int) m; // cast the squared number as an integer.
		int[] sequence = createSequence(N);
		int i;
		for (i = 0; i <= N - 2; i++) 
		{
			if (i < N - 2) 
			{
				System.out.print(sequence[i] + ",");
			}
			else if (i == N - 2) 
			{
				System.out.print(sequence[i] + "\n");
			}
		}
		// call the functions.
		int[] firstSequence = createSequence(N);
		int[] multiples = seive(N);
		for (int a = 0; a < multiples.length; a++) 
		{
			if (multiples[a] != 0 && multiples[a] <= squaredNumber) 
			{
				firstSequence = crossOutHigherMultiples(sequence, multiples[a]);
				System.out.println(sequenceToString(firstSequence, N));
			}
		}
		System.out.println((nonCrossedOutSubseqToString(seive(N))));
	}

	public static int[] createSequence(int n) {
		int[] integers = new int[0];
		try {
			integers = new int[n - 1]; // creates array with length n-1 as the number 1 isn't included at the start.
			for (int i = 0; i < integers.length; i++) {
				integers[i] = (i + 2); // create array of all numbers up to the integer n starting from 2.
			}
		} 
		catch (Exception e) {
			System.out.println("The integer entered is less than or equal to 0!!");
		}

		return integers;
	}

	public static int[] crossOutHigherMultiples(int[] numbers, int N) {
		try {
			if (numbers != null && N >= 0) {
				for (int i = 0; i < numbers.length; i++) {
					if (numbers[i] % N == 0 && numbers[i] != N) { // i.e if the number has remainder 0 when divided by
																	// 2, and it
																	// is not equal to 2, it is crossed out.
						numbers[i] = 0;
					}
				}
			}
		} 
		catch (Exception a) {
			System.out.println("Something went wrong.");
		}
		return numbers;
	}

	public static int[] seive(int N1) {
		int[] array = new int[0];
		try {
			int[] sequence = createSequence(N1);
			int m = (int) Math.sqrt(N1); // if the square root of N is reached, we know we need to stop the sequence.
			array = new int[N1];
			for (int i = 2; i <= m; i++) {
				array = crossOutHigherMultiples(sequence, i);
			}
		} 
		catch (NegativeArraySizeException ne) {
		}
		return array;
	}

	public static String sequenceToString(int[] array, int N) {
		String string = " ";
		String temp = " ";
		try {
			if (array != null && N != 0) {
				int[] sequence = (createSequence(N));
				for (int i = 0; i < sequence.length; i++) {

					if (array[i] == 0 && i != sequence.length - 1) {
						string = "[" + sequence[i] + "]" + ",";
						string = temp + string;
						temp = string;
					} 
					else if (array[i] != 0 && i != sequence.length - 1) {
						string = Integer.toString(sequence[i]);
						string = temp + string + ","; // add a comma to seperate numbers
						temp = string;
					} 
					else if (array[i] == 0 && i == sequence.length - 1) {
						string = "[" + sequence[i] + "]"; // add a box around prime numbers.
						string = temp + string;
						temp = string;
					} 
					else if (array[i] != 0 && i == sequence.length - 1) {
						string = Integer.toString(sequence[i]); // Nothing to be added to the last number.
						string = temp + string;
						temp = string;
					}
				}
			}
		} 
		catch (Exception b) {
			System.out.println("Sorry something went wrong");
		}
		return string;
	}

	public static String nonCrossedOutSubseqToString(int[] arrayIndex) {
		String string = " ";
		try {
			if (arrayIndex != null) {
				int loopNumber = 0;
				for (int i = 0; i < arrayIndex.length; i++) {
					if ((arrayIndex[i] == 0)) {
						loopNumber++;
					}
				}
				int[] newarray = new int[arrayIndex.length - loopNumber]; // make a new array
				String temporary = " ";
				int alternateIndex = 0;
				for (int i = 0; i < arrayIndex.length; i++) {
					
					if (arrayIndex[i] != 0 && alternateIndex < newarray.length - 1) {
						newarray[alternateIndex] = arrayIndex[i];
						string = newarray[alternateIndex] + ","; // separate numbers by commas.
						string = temporary + string;
						temporary = string;
						alternateIndex++;
					} 
					else if (arrayIndex[i] != 0 && alternateIndex == newarray.length - 1) {
						newarray[alternateIndex] = arrayIndex[i];
						string = newarray[alternateIndex] + "."; // last number finished with a full-stop.
						string = temporary + string;
						temporary = string;
						alternateIndex++;
					}
				}
			}
		} 
		catch (Exception c) {
			System.out.println("Sorry something went wrong");
		}
		return string;
	}

}
