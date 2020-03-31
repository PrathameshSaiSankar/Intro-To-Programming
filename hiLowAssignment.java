import java.util.Random;
import java.util.Scanner;

public class hiLowAssignment {
	/* SELF ASSESSMENT
	   1. Did I use appropriate CONSTANTS instead of numbers within the code?
	       Mark out of 5: 5.0
	       Comment: Yes, I used constants for Jack, Queen, King, Ace, and the maximum number generated.
	   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
	       Mark out of 5: 5.0
	       Comment: Yes, I used meaningful constant names formatted correctly in upper-case (e.g MAXIMUM_NUMBER_GENERATED)
	   3. Did I use easy-to-understand meaningful variable names?
	       Mark out of 10: 10.0
	       Comment: All the variables I used were easy to understand.
	   4. Did I format the variable names properly (in lowerCamelCase)?
	       Mark out of 5: 5.0
	       Comment: All variables were in lowerCamelCase.
	   5. Did I indent the code appropriately?
	       Mark out of 10: 10.
	       Comment: All the code is indented properly.
	   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
	       Mark out of 20: 20.0
	       Comment: Yes I used a while loop to allow the user to enter their guesses until they win or lose.
	   7. Did I check the input to ensure that invalid input was handled appropriately?
	       Mark out of 10: 5.0
	       Comment: Yes, if the user inputs anything other than quit, lower, higher, or equal, they were told to retry the program.
	   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
	       Mark out of 10: 10.0
	       Comment: A number between 2-14 was generated fairly each time.
	   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
	       Mark out of 10: 10.0
	       Comment: Yes, 2-10, Jack, Queen, King and Ace were shown correctly.
	   10. Did I report whether the user won or lost the game before the program finished?
	       Mark out of 10: 10.0
	       Comment: After 4 tries, the user is told whether they won or lost.
	   11. How well did I complete this self-assessment?
	       Mark out of 5: 5.0
	       Comment: I believe I completed this self-assessment fairly.
	   Total Mark out of 100 (Add all the previous marks): 95.0/100
	*/
	public static final int MAX_NUMBER_GENERATED = 13; // This is explained in line 59-62.
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;

	public static void main(String[] args) {

		double computersInput = 0;
		double computersInput2 = 0;
		double usersScore = 0;
		boolean exit = false;
		String input = "";
		int count = 0;

		Scanner firstInput = new Scanner(System.in);

		Random generator = new Random();
		computersInput = generator.nextInt(MAX_NUMBER_GENERATED) + 2; // Since the MAX_NUMBER_GENERATED = 13, we add 2
																		// to it.
																		// Hence, this makes the number generated from
																		// 2-14 rather than 0-13.

		if (computersInput < JACK) // i.e a card from 2-10 (there is no card equal to 1).
		{
			System.out.println("The card is " + computersInput);
		} else if (computersInput >= JACK) {
			if (computersInput == JACK) {
				System.out.println("The card is a Jack");
			}

			if (computersInput == QUEEN) {
				System.out.println("The card is a Queen");
			}

			if (computersInput == KING) {
				System.out.println("The card is a King");
			}

			if (computersInput == ACE) {
				System.out.println("The card is an Ace");
			}
		}
		while (!exit) {

			Random generator2 = new Random();
			computersInput2 = generator2.nextInt(MAX_NUMBER_GENERATED) + 2; // Number generated is from 2-14
																			// rather than 0-14.

			System.out.println("Do you think the next card will be higher, lower or equal?");
			input = firstInput.next();

			if (input.equalsIgnoreCase("quit")) {
				System.out.println("Thanks for playing!");
				exit = true;
			
			} else if (computersInput2 < JACK) {// i.e a card from 0-10
				System.out.println("The card is " + computersInput2);
			}

			else if (computersInput2 >= JACK) {
				if (computersInput2 == JACK) {
					System.out.println("The card is a Jack");
				}

				if (computersInput2 == QUEEN) {
					System.out.println("The card is a Queen");
				}

				if (computersInput2 == KING) {
					System.out.println("The card is a King");
				}

				if (computersInput2 == ACE) {
					System.out.println("The card is an Ace");
				}
			}

			if (input.equalsIgnoreCase("higher")) { // regardless of upper or lower case, if "higher" is entered, the
													// code below runs.
				if (computersInput2 > computersInput) {
					System.out.println("Hence, you were right!");
					usersScore++;
					count++;
				} else if (computersInput2 <= computersInput) {
					System.out.println("Hence, you were wrong!");
					usersScore = 0; // The user has to restart
					count++;
				}
			} else if (input.equalsIgnoreCase("lower")) { // regardless of upper or lower case, if "lower" is entered,
															// the
															// code below runs.
				if (computersInput2 < computersInput) {
					System.out.println("Hence, you were right!");
					usersScore++;
					count++;

				} else if (computersInput2 >= computersInput) {
					System.out.println("Hence, you were wrong!");
					usersScore = 0; // The user has to restart
					count++;
				}
			} else if (input.equalsIgnoreCase("equal")) { // regardless of upper or lower case, if "equal" is entered,
															// the
															// code below runs.
				if (computersInput2 == computersInput) {
					System.out.println("Hence, you were right!");
					usersScore++;
					count++;
				} else if (computersInput2 != computersInput) {
					System.out.println("Hence, you were wrong!");
					usersScore = 0; // The user has to restart
					count++;
				}

			}
		
			if (usersScore == 4) { // i.e the user wins 4 times in a row.
				System.out.println("Congratulations.  You got them all correct.");
				exit = true;
			} else if (count == 4) {
				System.out.println("Sorry, You didn't win. You can try again.");
				exit = true;
			}
			computersInput = computersInput2;
		}
		firstInput.close();
	}
}