package chuckALuck;
/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: ].
Comment: I defined resolveBet which takes the string typeOfBet and the wallet object, and returns nothing.
Mark: 7 
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: ].
Comment: My program presents the amount of cash in the wallet and asks how much the user would like to bet.
Mark: 8
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: ].
Comment: My program ensures that the bet amount is not greater than the cash in your wallet.
Mark: 5
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: ]..
Comment: My program creates 3 dice objects, rolls them, and creates a variable called summation for the sum of the roll values.
Mark: 15
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: ].
Comment:My program determines the winnings by comparing the bet type with the total and compares the bet type with the dice faces for the triple bet.
Mark: 20
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].
Comment: My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses.
Mark: 10.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: ]
Comment: The user is asked for the amount of cash they have, and creates a wallet object to put this cash into.
Mark: 15.

My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: ]
Comment: My program loops until the user enters quit or the cash in the wallet is zero.
Mark: 5
I ask the user to enter any of the four bet types or quit [Mark out of 5: ].
Comment: I asked the user to enter any of the 4 bet types or quit.
Mark: 5
My program calls resolveBet for each bet type entered [Mark out of 5: ].
Comment: My program calls resolveBet for each type of bet entered.
Mark: 5
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: ]
Comment: 5
Mark: At the end of the game my program presents a summary message regarding winnings and losses.

 Total Mark out of 100 (Add all the previous marks): 100.
*/



import java.util.Scanner;

public class chuckALuck {

	static float amountToBet = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean exit = false;
		boolean exit2 = false;
		boolean winTriple = false;
		boolean winField = false;
		boolean winHigh = false;
		boolean winLow = false;
		boolean didABet = false;
		boolean validBetEntered = false;
		float wallet = 0;
		int dice = 0;
		int summation = 0;
		Wallet playerWallet = new Wallet(); // wallet object made.
		String typeOfBet = "";
		System.out.println("How much do you want in your wallet? (cannot be less than or equal to zero)");
		Scanner walletScanner = new Scanner(System.in);
		if (walletScanner.hasNextFloat()) {
			wallet = walletScanner.nextFloat();
			
		}
		playerWallet.addToWallet(wallet); // puts Cash into Wallet

		while (!exit) {
			
			
		while(!validBetEntered) {
			System.out.println("We offer four bets, triple, field, high, and low.");
			System.out.println("What type of bet do you want to do? (or press quit)");
			Scanner betScanner = new Scanner(System.in);
			typeOfBet = betScanner.next();

			if (typeOfBet.equalsIgnoreCase("quit")) {
				validBetEntered = true;
				exit = true;
				exit2 = true;
				System.out.println("Thank you for playing!");
				System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");
				System.out.println("Your wallet had €" + wallet + " in it at the start.");
				if (wallet > playerWallet.getWallet()) {
					System.out.println("You have lost €" + (wallet - playerWallet.getWallet()) + " euros during your time playing.");
				}
				else 
				{
					System.out.println("You have gained €" + (wallet - playerWallet.getWallet()) + " euros.");
				}
				betScanner.close();
			}
			else if (playerWallet.getWallet() <= 0) {
				validBetEntered = true;
				exit = true;
				exit2 = true;
				System.out.println("You have €0 or less in your wallet. The game has ended.");
				System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");
				System.out.println("Your wallet had €" + wallet + " in it at the start.");
				if (wallet > playerWallet.getWallet()) {
					System.out.println("You have lost €" + (wallet - playerWallet.getWallet()) + " euros.");
				}
				else
				{
					System.out.println("You have gained €" + (wallet - playerWallet.getWallet()) + " euros.");
				}
				betScanner.close();
			}
			
			else if  (!exit2) {
					resolveBet(typeOfBet, wallet, playerWallet, dice, summation, winTriple, winField, winHigh, winLow, didABet);
				}

				if (winTriple == true && typeOfBet.equalsIgnoreCase("Triple")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet * 30);
					didABet = false;
				}
				else if (winField == true && typeOfBet.equalsIgnoreCase("Field")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				} 
				else if (winHigh == true && typeOfBet.equalsIgnoreCase("High")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winLow == true && typeOfBet.equalsIgnoreCase("Low")) {
					System.out.println("You won the bet!");
					playerWallet.addToWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				} 
				else if (winTriple == false && typeOfBet.equalsIgnoreCase("Triple")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				} 
				else if (winField == false && typeOfBet.equalsIgnoreCase("Field")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winLow == false && typeOfBet.equalsIgnoreCase("Low")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet);
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				else if (winHigh == false && typeOfBet.equalsIgnoreCase("High")) {
					System.out.println("You lost the bet!");
					playerWallet.removeFromWallet(amountToBet); 
					System.out.println("Your wallet now has €" + playerWallet.getWallet() + " in it.");
					didABet = false;
				}
				
				if (playerWallet.getWallet() <= 0) {
					validBetEntered = true;
					exit = true;
					exit2 = true;
					System.out.println("You have €0 or less in your wallet. The game has ended.");
					System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");
					System.out.println("Your wallet had €" + wallet + " in it at the start.");
					if (wallet > playerWallet.getWallet()) {
						System.out.println("You have lost €" + (wallet - playerWallet.getWallet()) + " euros.");
					} 
					else 
					{
						System.out.println("You have gained €" + (wallet - playerWallet.getWallet()) + " euros.");
					}
					betScanner.close();
				}
			}
		}
	}
	
	public static void resolveBet(String typeOfBet, float wallet, Wallet playerWallet, int dice, int summation, boolean winTriple, boolean winField, boolean winHigh, boolean winLow, boolean didABet) {
		winTriple = false;
		winField = false;
		winHigh = false;
		winLow = false;
		boolean isFloat = false;
		amountToBet = 0;

		System.out.println("Your wallet has €" + playerWallet.getWallet() + " in it.");

		while (!isFloat) {
			System.out.println("How much would you like to bet?");
			Scanner amountOfBetScanner = new Scanner(System.in);

			if (amountOfBetScanner.hasNextFloat()) {
				amountToBet = amountOfBetScanner.nextFloat();
				isFloat = true;
			} 
			else {
				isFloat = false;
			}
		}

		if (amountToBet <= playerWallet.getWallet()) {
			dice dice1 = new dice(dice);
			dice dice2 = new dice(dice);
			dice dice3 = new dice(dice);
			dice1.rollDice();
			dice2.rollDice();
			dice3.rollDice();
			summation = dice1.getDice() + dice2.getDice() + dice3.getDice();
			System.out.println("Dice 1 is : " + dice1.getDice());
			System.out.println("Dice 2 is : " + dice2.getDice());
			System.out.println("Dice 3 is : " + dice3.getDice());
			if (typeOfBet.equalsIgnoreCase("Triple")) {
				winTriple = Triple(dice1, dice2, dice3, winTriple, didABet);
			}

			else if (typeOfBet.equalsIgnoreCase("Field")) {
				winField = Field(dice1, dice2, dice3, winField, didABet, summation);
			}
			else if (typeOfBet.equalsIgnoreCase("High")) {
				winHigh = High(dice1, dice2, dice3, winHigh, didABet, summation);
			}
			if (typeOfBet.equalsIgnoreCase("Low")) {
				winLow = Low(dice1, dice2, dice3, winLow, didABet, summation);
			}
		} 
		else 
		{
			System.out.println("Sorry,  you don't have enough money.");
		}

	}

	public static boolean Triple(dice dice1, dice dice2, dice dice3, boolean winTriple, boolean didABet) {
		if (dice1.getDice() == dice2.getDice() && dice2.getDice() == dice3.getDice()) {
			if (dice1.getDice() != 1 && dice2.getDice() != 1 && dice3.getDice() != 1) {
				if (dice1.getDice() != 6 && dice2.getDice() != 6 && dice3.getDice() != 6) {
					winTriple = true;
				}
			}
		} 
		else 
		{
			winTriple = false;
		}
		didABet = true;
		return winTriple;
	}

	public static boolean Field(dice dice1, dice dice2, dice dice3, boolean winField, boolean didABet, int summation) {
		dice1.getDice();
		dice2.getDice();
		dice3.getDice();
		if ((summation) < 8) {
			winField = true;

		} 
		else if ((summation) > 12) {
			winField = true;

		} 
		else 
		{
			winField = false;
		}
		didABet = true;
		return winField;
	}   

	public static boolean High(dice dice1, dice dice2, dice dice3, boolean winHigh, boolean didABet, int summation) {
		dice1.getDice();
		dice2.getDice();
		dice3.getDice();
		if ((summation) > 10) {
			if (dice1.getDice() != dice2.getDice() && dice2.getDice() != dice3.getDice()) {
				winHigh = true;

			}
		}

		else 
		{
			winHigh = false;
		}
		didABet = true;
		return winHigh;
	}

	public static boolean Low(dice dice1, dice dice2, dice dice3, boolean winLow, boolean didABet, int summation) {

		if ((summation) < 11) {
			if ((dice1.getDice() != dice2.getDice()) && (dice2.getDice() != dice3.getDice())) {
				winLow = true;
			}
		}
		else
		{
			winLow = false;
		}
		didABet = true;
		return winLow;

	}
}
