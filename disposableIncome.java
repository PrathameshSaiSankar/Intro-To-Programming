import java.util.Scanner;
import javax.swing.JOptionPane;
public class DisposableIncome {              
	public static final double TAX_PERCENTAGE = (0.35);
	public static final double AVERAGE_DISPOSABLE_INCOME = (500);
	public static final double MUCH_MORE_THAN_AVERAGE_DISPOSABLE_INCOME = (750); // 50% more than the average of 500.
	public static final double MUCH_LESS_THAN_AVERAGE_DISPOSABLE_INCOME = (250); // 50% less than the average of 500.
	public static void main(String[] args) {
		  
		  //Inputs
		  String grossIncome = JOptionPane.showInputDialog("How much are you paid a month before tax?");
		  Scanner grossScanner = new Scanner( grossIncome );
		  double grossInput = grossScanner.nextDouble();
		  grossScanner.close();
		  
		  String accomodationCost = JOptionPane.showInputDialog("How much do you pay in rent/mortgage a month?");
		  Scanner accomodationScanner = new Scanner( accomodationCost );
		  double accomodationInput = accomodationScanner.nextDouble();
		  accomodationScanner.close(); 
		  
		  String travelCost = JOptionPane.showInputDialog("How much does your commute cost a month?");
		  Scanner travelScanner = new Scanner( travelCost );
		  double travelInput = travelScanner.nextDouble();
		  travelScanner.close();
		  
		  String foodCost = JOptionPane.showInputDialog("How much do you spend on food per month?");
		  Scanner foodScanner = new Scanner( foodCost );
		  double foodInput = foodScanner.nextDouble();
		  foodScanner.close();
		  
		  
		 //Calculations
		  double taxPaid = (grossInput * TAX_PERCENTAGE);
		  double netIncome = (grossInput - taxPaid);
		  double disposableIncome = (netIncome) - (accomodationInput + travelInput + foodInput);
		  double percentageOfDisposableIncome = (disposableIncome / grossInput * 100);
		  
		  
		  //Outputs
		  if (disposableIncome >= MUCH_MORE_THAN_AVERAGE_DISPOSABLE_INCOME)
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. You have 50% more than the average disposable income per month.");
		  }
		  else if (disposableIncome > AVERAGE_DISPOSABLE_INCOME)
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. You have more than the average disposable income per month.");
		  }
		  else if (disposableIncome == AVERAGE_DISPOSABLE_INCOME)
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. You have the exact average disposable income per month.");
		  }
		  else if (disposableIncome < AVERAGE_DISPOSABLE_INCOME && disposableIncome == 0)
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. You have no disposable income.");
		  }
		  else if (disposableIncome < AVERAGE_DISPOSABLE_INCOME && disposableIncome > MUCH_LESS_THAN_AVERAGE_DISPOSABLE_INCOME) 
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. You have less than the average disposable income per month.");
		  }
		  else if (disposableIncome <= MUCH_LESS_THAN_AVERAGE_DISPOSABLE_INCOME && disposableIncome > 0)
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. You have 50% less than the average disposable income per month.");
		  }
		  else if (disposableIncome < 0.0)
		  {
			  JOptionPane.showMessageDialog(null, "Your disposable income is €" + disposableIncome + ", which is " + percentageOfDisposableIncome + "% of your salary. Your expenses are higher than your net income");
		  }
	  }
 }                            
