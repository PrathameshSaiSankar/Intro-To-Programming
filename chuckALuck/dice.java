package chuckALuck;

import java.util.Random;

public class dice {
	
private int dice = 0;

dice (int dice) {
		
		
		}

public int getDice() {
	return dice;

}

public void rollDice() {
	Random rand = new Random();
	dice = rand.nextInt(5) + 1; //makes a random number from 1 to 6.
}

}
