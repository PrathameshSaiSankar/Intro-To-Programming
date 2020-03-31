package wordLinks;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment:  Yes, i have the correct method definition for the method readDictionary.
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: Yes, it does read words from the words.txt file (in the same project folder as wordLink java project).
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:]
- Comment: Yes, it returns the contents of 'words.txt' in a string ArrayList called 'dictionary'.

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition for the method readWordList.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:]
- Comment: Yes, my method reads the words from the user, separated by commas, saves them into an array first, and then into an arraylist.

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition for the method isUniqueList.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: Yes, my method does compare each word in the array with the rest of the words in the list.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Yes, it breaks out of the for-loops when a non unique word is found.
- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: Yes, the method returns true if all words are unique, and false if they are not all unique.

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, i have the correct method definition for the method isEnglishWord.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 0]
- Comment: Since I used an ArrayList, I was forced to use the Collections Library class instead of the Arrays library class, but it has the same function.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: Yes, if the method returns a value greater than or equal to zero, it returns true, otherwise it returns false.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I have the correct method definition for the method isDifferentByOne.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Yes, the method loops through the length of the words comparing a character at the same position in both words searching for one difference (at max).

6. isWordChain
- I have the correct method definition [Mark out of 5:5]
- Comment: Yes, I have the correct method definition for the method isWordChain.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10:]
- Comment: 

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of the Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Yes, the main calls the method readDictionary which uses the java.io.FileReader class to read the words from the file words.txt into an arrayList.
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: Yes, the main asks the user for their String of words, and calls the method isWordChain, passing the required parameters.

 Total Mark out of 100 (Add all the previous marks): 97.
*/


public class wordLinks {

	public static void main(String[] args) throws Exception {
		boolean exit = false;	
		
		while (!exit) {
		System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
		Scanner inputScanner = new Scanner(System.in);
		String userInput = inputScanner.nextLine();
		if ((userInput.isEmpty())) {  // if the user enters an empty list, then it quits the program.
			System.out.println("Thanks for using this program!\nGoodbye.");
			exit = true;
			inputScanner.close();
			break;
		}
		else if (userInput != null){ //otherwise, it runs the program.
			isWordChain(readWordList(userInput), readDictionary());
		  }
		}
	}

	public static ArrayList<String> readDictionary() throws Exception {
		
		ArrayList <String> dictionary = new ArrayList<String>(); 
		FileReader file = new FileReader("words.txt");
		BufferedReader reader = new BufferedReader(file);
		String word = reader.readLine();
		
		while(word != null) {
			dictionary.add(word);
			word = reader.readLine();
		}
		return dictionary;
	}
	
	public static ArrayList<String> readWordList(String userInput) {
		ArrayList<String>userWords = new ArrayList<String>(); // makes an Array list for user's string.
		String[] values = userInput.split("\\s*,\\s*");       // split the string into elements separated by a space and a comma.
		Collections.addAll(userWords, values);                // use the collections library to convert this array into an ArrayList.         
	     
			return userWords;  //return an array-list which contains the user's string of words which is converted to an array-list.
		
	}
	
	public static Boolean isUniqueList(ArrayList <String> userWords) {
		boolean isUnique = true;
		boolean breakLoop = false;
		for (int i = 0; i < userWords.size(); i++) {
			if (breakLoop == true) {
				break;
			}
			String temporaryString = userWords.get(i);
			for (int j = i+1; j < userWords.size(); j++) {
				if (temporaryString == userWords.get(j)) {
					isUnique = false;
					breakLoop = true;
					break;
				}
				
			}
		}
		return isUnique;
	}
	
	public static Boolean isEnglishWord(String inputString, ArrayList<String> dictionary) {
		boolean isEnglishWord = false;
		int result = Collections.binarySearch(dictionary,inputString);
		if (result >= 0) {
			isEnglishWord = true;
		}
		else if (result < 0) {
			isEnglishWord = false;
		}
		return isEnglishWord;
	}
	
	
	
	public static Boolean isDifferentByOne (String string1, String string2) {
		int maxCharactersToDifferBy = 1;
		boolean isDifferentByOne = false;
		if (string1.length() == string2.length()) {          // if the length of both strings are equal, 
			for(int i = 0; i < string1.length(); i++) {      // go from first to last character index the words
	            if(string1.charAt(i) != string2.charAt(i)) { // if this character from String1 does not equal the character from String2
	            	maxCharactersToDifferBy--;               // reduce the maximum characters to differ by
	                if(maxCharactersToDifferBy < 0) {        // and if you have more mistakes than allowed
	                    isDifferentByOne = false;            // return false since it's different by more than one character.
	                }
	                else {
	                	isDifferentByOne = true;
	                }
	            }
	        }
		}
		return isDifferentByOne;
	}
	
	public static Boolean isWordChain(ArrayList<String> userWords, ArrayList<String> dictionary) {
		boolean isWordChain = false;
		boolean isUniqueList = false;
		boolean isEnglishWord = false;
		boolean isDifferentByOne = false;
		
		//CHECK IF IT'S A UNIQUE LIST OR NOT
		if (isUniqueList(userWords)) {
			isUniqueList = true;
		}
		else {
			isUniqueList = false;
		}
		
		//CHECK IF IT'S AN ENGLISH WORD OR NOT
		for (int i = 0; i < userWords.size(); i++) {
			if (isEnglishWord(userWords.get(i), dictionary)) {
				isEnglishWord = true;
			}
			else {
				isEnglishWord = false;
			}
		}
		
		//CHECK IF ADJACENT WORDS ONLY DIFFER BY A MAXIMUM OF ONE LETTER AND ARE THE SAME SIZE.
		for (int i = 0; i < (userWords.size()-1); i++) { // do it for i <  (userWords.size()-1 so it doesn't check  userWord.get(userword.size) and userWord.get(userword.size +1) 
			boolean checkIfDifferentByOne = isDifferentByOne(userWords.get(i), userWords.get(i+1));
			if (checkIfDifferentByOne == true) {
				isDifferentByOne = true;
			}
			else if (checkIfDifferentByOne == false) {
				isDifferentByOne = false;
			}
		}
		
		//IF ALL THE TESTS ABOVE ARE TRUE, THEN THE LIST OF WORDS ARE A VALID CHAIN OF WORDS FOR LEWIS CARROLL'S WORD-LINKS GAME.
		if (isUniqueList == true && isEnglishWord == true && isDifferentByOne == true) {
			isWordChain = true;
		}
		
		
		//OUTPUT
		if(isWordChain == true) {
			System.out.println("Congratulations, the entered list of words is a valid chain of words for Lewis Carroll's Word-links game!");
		}
		else if (isWordChain == false) {
			System.out.println("Sorry, but the entered list of words is NOT a valid chain of words for Lewis Carroll's Word-links game!");
		}
		
		return isWordChain;
	}
}
