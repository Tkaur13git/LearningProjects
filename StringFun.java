import java.util.Scanner;

/*
 * StringFun.java
 * Author:  Tisha Kaur 
 * Submission Date:  10/17/2025
 *
 * Purpose: This program prompts the user to enter a string and then keeps manipulating it via the option for five commands which are reverse, replace first, replace last, remove, and remove all. Each of these commands modifies the current string, and then each change change carries over to the following commands. The program keeps running in this way until the user types "quit" to end the program.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither 
 * received nor given inappropriate assistance. I have not copied 
 * or modified code from any source other than the course webpage 
 * or the course textbook. I recognize that any unauthorized 
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the 
 * policies of this course. I recognize that my work is based 
 * on an assignment created by the School of Computing 
 * at the University of Georgia. Any publishing or
 * posting of source code for this assignment is strictly 
 * prohibited unless you have written consent from the 
 * School of Computing at the University of Georgia.  
 */

public class StringFun {

	public static void main(String[] args) {

		System.out.println("Enter the string to be manipulated");
		Scanner scan = new Scanner(System.in);
		String statement = scan.nextLine();

		boolean running = true;
		while (running) {
			System.out.println("Enter your command (reverse, replace first, replace last, remove all, remove, quit)");
			String command = scan.nextLine();

			//define command keywords
			String commandOne = "reverse";
			String commandTwo = "replace first";
			String commandThree = "replace last";
			String commandFour = "remove";
			String commandFive = "remove all";
			String commandSix = "quit";

			if (command.equalsIgnoreCase(commandSix)) {
				running = false; //end program
			}

			else if (command.equalsIgnoreCase(commandOne)) {
				//reverse the string 
				int howLongIsString = statement.length();
				String reversed = "";
				for (int index = howLongIsString - 1; index >= 0; index--) {
					reversed = reversed + statement.charAt(index);
				}
				statement = reversed;
				System.out.println("The new sentence is: " + statement);
			}

			else if (command.equalsIgnoreCase(commandTwo)) {
				System.out.println("Enter the character to replace");
				char oldChar = scan.nextLine().charAt(0);
				System.out.println("Enter the new character");
				char newChar = scan.nextLine().charAt(0);

				//find first occurrence of oldChar
				int index = -1;
				int i = 0;
				while (i < statement.length() && index == -1) {
					if (statement.charAt(i) == oldChar) {
						index = i;
					}
					i++;
				}

				if (index == -1) {
					System.out.println("The letter was not found in the word");
				} else {
					//rebuild string with replacement at index
					statement = statement.substring(0, index) + newChar + statement.substring(index + 1);
					System.out.println("The new sentence is: " + statement);
				}
			}

			else if (command.equalsIgnoreCase(commandThree)) {
				System.out.println("Enter the character to replace");
				char oldChar = scan.nextLine().charAt(0);
				System.out.println("Enter the new character");
				char newChar = scan.nextLine().charAt(0);

				//find last occurrence of oldChar
				int index = -1;
				int i = statement.length() - 1;
				while (i >= 0 && index == -1) {
					if (statement.charAt(i) == oldChar) {
						index = i;
					}
					i--;
				}

				if (index == -1) {
					System.out.println("The letter was not found in the word");
				} else {
					//rebuild string with replacement at index
					statement = statement.substring(0, index) + newChar + statement.substring(index + 1);
					System.out.println("The new sentence is: " + statement);
				}
			}

			else if (command.equalsIgnoreCase(commandFour)) {
				System.out.println("Enter the character to remove");
				char removeChar = scan.nextLine().charAt(0);

				System.out.println("Enter the " + removeChar +
						" you would like to remove (Not the index - 1 = 1st, 2 = 2nd, etc.):");
				int which = Integer.parseInt(scan.nextLine());

				//count occurrences until we reach the requested one
				int count = 0;
				int index = -1;
				int i = 0;
				while (i < statement.length() && index == -1) {
					if (statement.charAt(i) == removeChar) {
						count++;
						if (count == which) {
							index = i;
						}
					}
					i++;
				}

				if (index == -1) {
					System.out.println("Error: the letter you are trying to remove does not exist");
				} else {
					//remove the character at found index
					statement = statement.substring(0, index) + statement.substring(index + 1);
					System.out.println("The new sentence is: " + statement);
				}
			}

			else if (command.equalsIgnoreCase(commandFive)) {
				System.out.println("Enter the character to remove");
				char removeChar = scan.nextLine().charAt(0);

				//rebuild string skipping all instances of removeChar
				String newStatement = "";
				int i = 0;
				while (i < statement.length()) {
					if (statement.charAt(i) != removeChar) {
						newStatement = newStatement + statement.charAt(i);
					}
					i++;
				}
				statement = newStatement;
				System.out.println("The new sentence is: " + statement);
			}

			else {
				//output to handle any unknown commands
				System.out.println("Command invalid. Try again");
			}
		}
	}
}
