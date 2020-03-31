import javax.swing.JOptionPane;
import java.util.Scanner;

public class bmi {

	public static void main(String[] args) {

		// This Program calculates the user's BMI. There are three stages.
		// 1. Input of height
		// 2. Input of weight
		// 3. Calculation of BMI with input values from steps 2 and 3.
		// 4. Display users BMI along with information whether they are a normal weight,
		// under-weight, or over-weight.
		// BMI from 18.5 to 25 is a normal weight. A BMI under 18.5 is under-weight. A
		// BMI over 25 is over-weight.

		// 1. Input box for height in meters
		String heightInput = JOptionPane.showInputDialog("What is your height in metres?");
		Scanner h_inputScanner = new Scanner(heightInput);
		double height = h_inputScanner.nextDouble();

		// 2. Input box for height in meters
		String weightInput = JOptionPane.showInputDialog("What is your weight in kilograms?");
		Scanner w_inputScanner = new Scanner(weightInput);
		double weight = w_inputScanner.nextDouble();

		// 3. Calculation of BMI
		double bmi = computeBmi(weight, height);
	
		// 4. User's BMI displayed, showing if they're a normal weight, under-weight, or
		// over-weight

		// When the user is overweight
		if (bmi > 25) {
			JOptionPane.showMessageDialog(null, "Your BMI is " + bmi
					+ ". Unfortunately you're over-weight. %n Click the link below to Learn more about it /r");

			// When the user is overweight
		} else if (bmi < 18.5) {
			JOptionPane.showMessageDialog(null, "Your BMI is " + bmi + ". Unfortunately you're under-weight");

			// When the user is a normal weight
		} else {
			JOptionPane.showMessageDialog(null, "Your BMI is " + bmi + ". You are a perfect weight. Good work!");

			h_inputScanner.close();
			w_inputScanner.close();
		}
	}

	public static double computeBmi(double weight, double height) {
		double bmi = weight / (height * height);
		return bmi;
	}
}
