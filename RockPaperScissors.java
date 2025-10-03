/*
 * RockPaperScissors.java
 * Author:  Tisha Kaur 
 * Submission Date:  10/1/2025
 *
 * Purpose: This program is a rock, paper, scissor game where the user can play against the computer by entering their move, the computer will output it's move and the score of the round.
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
import java.util.Scanner;

public class RockPaperScissors {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//ask user how many points they want to play until
		System.out.print("Points to win: ");
		int desiredPts = scan.nextInt();
		scan.nextLine();

		//declare score keeping and specific move(scissors, rock, paper) variables
		int userScore = 0;
		int computerScore = 0;
		String userMove;
		String computerMove;

		//loop continues until either the player or the computer reaches the target number of wins
		while (userScore < desiredPts && computerScore < desiredPts) {
			System.out.print("Rock, paper, or scissors? ");
			userMove = scan.nextLine().trim();
			
			//keep asking until the user provides a valid move
			while (!(userMove.equalsIgnoreCase("rock") ||
					userMove.equalsIgnoreCase("paper") ||
					userMove.equalsIgnoreCase("scissors"))) {
				System.out.print("Rock, paper, or scissors? ");
				userMove = scan.nextLine().trim();
			}

		    //get the computer’s move for this round
			computerMove = ComputerOpponent.getMove();

		    //determine the round outcome and update scores
			if (userMove.equalsIgnoreCase("rock")) {
				if (computerMove.equals("rock")) {
					System.out.printf(", so it's a tie. (%d-%d)%n", userScore, computerScore);
				} else if (computerMove.equals("paper")) {
					computerScore++;
					System.out.printf(", so you lose. (%d-%d)%n", userScore, computerScore);
				} else {
					userScore++;
					System.out.printf(", so you win! (%d-%d)%n", userScore, computerScore);
				}
			} else if (userMove.equalsIgnoreCase("paper")) {
				if (computerMove.equals("rock")) {
					userScore++;
					System.out.printf(", so you win! (%d-%d)%n", userScore, computerScore);
				} else if (computerMove.equals("paper")) {
					System.out.printf(", so it's a tie. (%d-%d)%n", userScore, computerScore);
				} else {
					computerScore++;
					System.out.printf(", so you lose. (%d-%d)%n", userScore, computerScore);
				}
			} else {
				if (computerMove.equals("rock")) {
					computerScore++;
					System.out.printf(", so you lose. (%d-%d)%n", userScore, computerScore);
				} else if (computerMove.equals("paper")) {
					userScore++;
					System.out.printf(", so you win! (%d-%d)%n", userScore, computerScore);
				} else {
					System.out.printf(", so it's a tie. (%d-%d)%n", userScore, computerScore);
				}
			}
		}

		//after the loop, announce the final result
		if (userScore == desiredPts) {
			System.out.println("Congratulations! You won!");
		} else {
			System.out.println("Sorry, you lost. Better luck next time!");
		}

		scan.close(); // close scanner
	}
}
