import java.util.Scanner;

public class morgageCalculator {

	/* SELF ASSESSMENT

	 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
	        Mark out of 10: 10
	        Comment:   All variable names and CONSTANTS are formatted properly.
	 2. Did I indent the code appropriately? 
	        Mark out of 5: 5
	        Comment:   All the code is indented properly according to the coding standards.
	 3. Did I implement the main-line correctly with a loop which continues using the user says "no" ?
	       Mark out of 10: 7
	        Comment:  I implemented the main-line correct with a loop
	 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
	       Mark out of 10: 10
	        Comment:  I obtained the relevant inputs from the user and produced the relevant outputs correctly.
	 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
	       Mark out of 20: 20
	        Comment:  I implemented the readDoubleFromUser function correctly.
	 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
	       Mark out of 20: 20
	        Comment:  I implemented the calculateMonthlyRepayment function correctly.
	 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
	       Mark out of 20: 20  
	        Comment: I implemented the calculateMonthsToRepayMortgage function correctly.
	 8. How well did I complete this self-assessment?
	        Mark out of 5: 5
	        Comment: I completed this self-assessment with honestly.
	 Total Mark out of 100 (Add all the previous marks): 97/100
	*/ 

	public static void main(String[] args) {
		boolean userDecisionToContinue = true;

		while (userDecisionToContinue) {
			System.out.println("Welcome to the mortgage calculator.");
			Scanner inputScanner = new Scanner(System.in);
			double mortgage = readDoubleFromUser("Please enter the mortgage amount:");

			System.out.println("Please enter the annual interest rate (APR):");
			final double ANNUAL_INTEREST_RATE = inputScanner.nextDouble();

			System.out.println("Assuming a 20 year term, the monthly repayments would be " + calculateMonthlyRepayment(mortgage, 20, ANNUAL_INTEREST_RATE));

			System.out.println("How much can you afford to pay per month?");
			final double amountUserCanAfford = inputScanner.nextDouble();

			System.out.println("If you pay " + amountUserCanAfford + " per month your mortgage would be paid off in " + calculateMonthsToRepayMortgage(mortgage, ANNUAL_INTEREST_RATE, amountUserCanAfford));
			
			System.out.println("Would you like to use the mortgage calculator again (yes/no)?");
			String userInput = inputScanner.next();
			if (userInput.equals("no")) 
			{
				System.out.println("Thanks for using this mortgage calculator!");
				userDecisionToContinue = false;
				inputScanner.close();
			}

		}
	}

	public static double readDoubleFromUser(String question) {
		Scanner questionScanner = new Scanner(System.in);
		System.out.println(question);
		
		while (true) {
			if (questionScanner.hasNextDouble()) 
			{
				return questionScanner.nextDouble();
			} 
			else {
				System.out.println("INVALID INPUT, TRY AGAIN!");
				questionScanner.nextDouble();

			}
			
		}
	}

	public static double calculateMonthlyRepayment(double mortgage, int duration, double ANNUAL_INTEREST_RATE) {
		
		double monthlyRepayment = mortgage * (ANNUAL_INTEREST_RATE / 12 / 100) / (1 - (Math.pow((1 + ANNUAL_INTEREST_RATE / 12 / 100), (-1 * duration * 12))));
		return monthlyRepayment;
	}

	public static String calculateMonthsToRepayMortgage(double mortgage, double ANNUAL_INTEREST_RATE, double monthlyRepayment) {

		double monthlyAnnualInterestRate = ANNUAL_INTEREST_RATE / 12;
		int numberOfMonths = 0;

		while (mortgage >= 0) {
			mortgage = ((mortgage * (1 + (monthlyAnnualInterestRate / 100))) - monthlyRepayment);
			numberOfMonths++;
		}
		int yearsToRepay = numberOfMonths/12;
		int monthsToRepay = numberOfMonths % 12;
		
		String timeToRepay = yearsToRepay + " years " + monthsToRepay + " months.";
		
		return timeToRepay;

	}

}
