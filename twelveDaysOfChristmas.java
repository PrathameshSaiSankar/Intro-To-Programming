
public class twelveDaysOfChristmas {
	/* SELF ASSESSMENT
	 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
	        Mark out of 10: 10
	        Comment: All variable names and constants are formatted properly.
	 2. Did I implement the getVerse function correctly and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
	       Mark out of 25: 25
	        Comment: I implemented the getVerse function in an easy to understand manner.
	 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
	       Mark out of 25: 25
	        Comment: The switch statement is included in the getChristmasGift function in an easy to understand manner.
	 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood (5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
	       Mark out of 25: 25
	        Comment: I used if statements to implement getOrdinalString in an easy to understand manner.
	 5. Does the program produce the output correctly?
	       Mark out of 10: 10
	        Comment:  The program outputs the output in the correct format.
	 6. How well did I complete this self-assessment?
	        Mark out of 5: 5
	        Comment: 5
	 Total Mark out of 100 (Add all the previous marks): 100
	*/ 
	public static final int MAX_DAYS = 12;

	public static void main(String args[]) {

		int day = 1;
		for (day = 1; day <= MAX_DAYS; day++) {
			System.out.println(getVerse(day));
		}
	}

	public static String getVerse(int day) {
		String verse = "\nOn the " + getOrdinalString(day) + " day of Christmas, \nMy true love sent to me:\n"
				+ getChristmasGift(day);
		return verse;
	}

	public static String getChristmasGift(int day) {

		String gift = "";
		switch (day) {

		case 1: // Used only for day 1
			gift = gift + "\nA Partridge in a Pear tree.";
			break;
		case 12:
			gift = gift + "\nTwelve drummers drumming,";
		case 11:
			gift = gift + "\nEleven pipers piping,";
		case 10:
			gift = gift + "\nTen lords a-leaping,";
		case 9:
			gift = gift + "\nNine ladies dancing,";
		case 8:
			gift = gift + "\nEight maids a-milking,";
		case 7:
			gift = gift + "\nSeven swans a-swimming,";
		case 6:
			gift = gift + "\nSix geese a-laying,";
		case 5:
			gift = gift + "\nFive Gold Rings,";
		case 4:
			gift = gift + "\nFour Calling Birds,";
		case 3:
			gift = gift + "\nThree French Hens,";
		case 2:
			gift = gift + "\nTwo Turtle Doves,";

		default: // Used for days 2-12
			gift = gift + "\nand a Partridge in a Pear tree. ";
		}
		return gift;
	}

	public static String getOrdinalString(int day) {

		String numbers = "";
		if (day == 1) {
			numbers = "first";
		} else if (day == 2) {
			numbers = "second";
		} else if (day == 3) {
			numbers = "third";
		} else if (day == 4) {
			numbers = "fourth";
		} else if (day == 5) {
			numbers = "fifth";
		} else if (day == 6) {
			numbers = "sixth";
		} else if (day == 7) {
			numbers = "seventh";
		} else if (day == 8) {
			numbers = "eighth";
		} else if (day == 9) {
			numbers = "ninth";
		} else if (day == 10) {
			numbers = "tenth";
		} else if (day == 11) {
			numbers = "eleventh";
		} else if (day == 12) {
			numbers = "twelfth";
		}

		return numbers;

	}
}
