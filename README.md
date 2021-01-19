# Intro-To-Programming
Intro to Programming is a year long module taken by first year computer science students at Trinity College Dublin. During the duration of this module, I learned the basics of Java.

## bmi.java
A Program which computes the Body Mass Index (BMI) of a person.  The BMI is computed by dividing the weight of a person (in kgs) by the square of the height of the person in meters.


## disposableIncome.java
A Java program which computes the monthly disposable income of the user and also computes what percentage of their gross income is disposable.  For simplicity we assume that all income is taxed at 35%.

Disposable income = After tax income - Accommodation costs - Travel costs - Food costs

The program asks the user for their monthly gross income (i.e. before tax is taken), and their monthly costs of accommodation, travel and food, do some computations and then tell the user the required results.

The program then provides some analysis for the user regarding their disposable income.  Assuming that the average monthly disposable income is 500.00 per month the program tells the user if their disposable income is much more than the average (i.e. greater than 50% more than the average), more than the average, exactly the average, less than the average or much less than the average (i.e. less than 50% of the average).  If the user has no disposable income (i.e. less than or equal to 0.00) the program tells them that rather than doing the comparison.

***Sample input and output (User input is highlighted in bold): <br>***
How much are you paid a month before tax? **4000.00** <br>
How much do you pay in rent/mortgage a month? **1000.00** <br>
How much does your commute cost a month? **500.00** <br>
How much do you spend on food per month? **800.00** <br>
Your monthly disposable income is €300.00 which is 8% of your salary. <br>
You have less than the average disposable per month. <br>

## rockPaperScissors.java

A program to allow a user to play a game of Rock-Paper-Scissors.  The user can  play a fixed number of times (say 5) and each time are told if they win, lose or draw.  At the end a final score is be given.

In the game the user and the computer both have to choose one of Rock, Paper or Scissors.  If they choose the same object then it is a draw.  If not then one of them has won:  Rock beats Scissors, Scissors beats Paper and Paper beats Rock.

***Sample input and output (User input is highlighted in bold): <br>***

Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): **1** <br>
You won this round as I chose Scissors <br>
Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): **2** <br>
You won this round as I chose Rock <br>
Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): **1** <br>
This round was a draw as I chose Rock too <br>
Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): **3** <br>
You lost this round as I chose Rock <br>
Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): **3** <br>
You lost this round as I chose Rock <br>
The final score was Computer: 2 User: **2**

## highLow.java
The Hi-Lo card game is one where the user is presented with an initial card (2 – 10, Jack, Queen, King, or Ace) and has to guess that the next card with be Higher (Hi), Lower (Lo) or Equal to the current card.
They must guess successfully 4 times in a row in order to win.

***Sample input/output (input is highlighted in bold).***  <br> 
The card is a 3 <br>
Do you think the next card will be higher, lower or equal? **higher** <br>
The card is a Ace <br>
Do you think the next card will be higher, lower or equal? **lower** <br>
The card is a 9 <br>
Do you think the next card will be higher, lower or equal? **lower** <br>
The card is a 7 <br>
Do you think the next card will be higher, lower or equal? **higher** <br>
The card is a King <br>
Congratulations.  You got them all correct.


## twelveDaysOfChristmas
A program to produce the lyrics (all 12 verses) of the Twelve Days of Christmas. This is a cumulative song as each verse is build on top of the previous verses.

***Sample output*** <br>
**On the first day of Christmas
my true love sent to me:
a Partridge in a Pear Tree. 
On the second day of Christmas
my true love sent to me:
2 Turtle Doves
and a Partridge in a Pear Tree. 
On the third day of Christmas
my true love sent to me:
3 French Hens,
2 Turtle Doves
and a Partridge in a Pear Tree
 ...**
 
 
 
## morgageCalculator.java
A Java program which repeatedly takes the details of a mortgage from the user (as shown below) and calculates the required monthly repayment.  In addition it asks the user how much they can afford to pay per month and calculate how long it would take to repay the mortgage (again as shown below).  After this it asks them if they want to try again.  It assumes that the mortgage is 20 years in duration.

***Sample input/output (with user input highlighted in bold):*** <br>

Welcome to the mortgage calculator. <br>
Please enter the mortgage amount:  **200000.00** <br>
Please enter the annual interest rate (APR):  **4.1** <br>
Assuming a 20 year term, the monthly repayments would be 1222.53 <br>
How much can you afford to pay per month?  **2000.00** <br>
If you pay 2000.00 per month your mortgage would be paid off in 10 years and 3 months.
Would you like to use the mortgage calculator again (yes/no)?  **no**

## sieveOfEratosthenes.java

A Java program which uses the Sieve of Eratosthenes to compute the prime numbers from 2 up to a given number N which is entered by the user. As part of your solution you must use an array to represent the sequence of numbers (which may contain both crossed out and non-crossed out numbers).

## chuckALuck (file)

This file has programs which allows the user to play the game **chuck a luck** which is a famous gambling game.

## Connect4Game (file)

This file has programs which allows the user to play the game **Connect-Four** which is a famous game where a user needs to place their symbols in 4 spots in a row (either horizontally or vertically).

## Lewis Carroll's Word-Links Puzzle Game (file)

This file has programs which allow a user to enter a list of words separated by commas (,) and which will determine whether the entered list of words is a valid chain of words for Lewis Carroll's Word-links game. The program terminates only when the user enters an empty list.
