/*
 * GradeCalculator.java
 * Author:  Tisha Kaur 
 * Submission Date:  10/3/2025
 *
 * Purpose: This program takes user input for known scores and the weight of various types of grades to calculate a student's current course grade. It also determines if their desired final grade letter is possible to get and what average on the remaining assignments will get them there. 
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

public class GradeCalculator {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// print grading scale
		System.out.println("Grading Scale:\nA\t90-100\nB\t80-89\nC\t70-79\nD\t60-69\nF\tBelow 60");

		// ask for desired grade
		System.out.print("What letter grade do you want to achieve for the course?");
		String desiredGrade = scan.nextLine(); 

		// check if input is valid
		if (!(desiredGrade.equalsIgnoreCase("A") || 
				desiredGrade.equalsIgnoreCase("B") || 
				desiredGrade.equalsIgnoreCase("C") || 
				desiredGrade.equalsIgnoreCase("D") || 
				desiredGrade.equalsIgnoreCase("F"))) {
			System.out.println("The input is invalid.");
			System.exit(0);
		}

		// ask for weights
		System.out.println("Enter percentage weights below.");
		System.out.print("Exam 1:\t\t");
		int firstExam = scan.nextInt();
		System.out.print("Exam 2:\t\t");
		int secondExam = scan.nextInt();
		System.out.print("Final Exam:\t");
		int finalExam = scan.nextInt();
		System.out.print("Labs:\t\t");
		int labGrade = scan.nextInt();
		System.out.print("Projects:\t");
		int projects = scan.nextInt();
		System.out.print("Participation:\t");
		int participation = scan.nextInt();
		System.out.print("Quizzes:\t");
		int quizzes = scan.nextInt();

		// check weights add to 100
		int totalWeight = firstExam + secondExam + finalExam + labGrade + projects + participation + quizzes;
		if (!(totalWeight == 100)) {
			System.out.println("Weights don’t add up to 100, program exiting...");
			System.exit(0);
		}

		// track known weights and scores
		int knownWeight = 0;
		int weightedSum = 0;

		// exam 1, exam 2, final exam (dependent on each other)
		System.out.print("Do you know your exam 1 score?");
		String examOneAnswer = scan.next();
		int exam1Score = -1; 
		if (examOneAnswer.equalsIgnoreCase("y") || examOneAnswer.equalsIgnoreCase("yes")) {
			System.out.print("Score received on exam 1:");
			exam1Score = scan.nextInt();
			knownWeight += firstExam;
			weightedSum += firstExam * exam1Score;

			System.out.print("Do you know your exam 2 score?");
			String examTwoAnswer = scan.next();
			int exam2Score = -1;
			if (examTwoAnswer.equalsIgnoreCase("y") || examTwoAnswer.equalsIgnoreCase("yes")) {
				System.out.print("Score received on exam 2:");
				exam2Score = scan.nextInt();
				knownWeight += secondExam;
				weightedSum += secondExam * exam2Score;

				System.out.print("Do you know your final exam score?");
				String finalExamAnswer = scan.next();
				int finalExamScore = -1;
				if (finalExamAnswer.equalsIgnoreCase("y") || finalExamAnswer.equalsIgnoreCase("yes")) {
					System.out.print("Score received on final exam:");
					finalExamScore = scan.nextInt();
					knownWeight += finalExam;
					weightedSum += finalExam * finalExamScore;
				}
			}
		}

		// labs
		System.out.print("Do you know your lab average?");
		String labAnswer = scan.next();
		int labScore = -1;
		if (labAnswer.equalsIgnoreCase("y") || labAnswer.equalsIgnoreCase("yes")) {
			System.out.print("Average lab grade:");
			labScore = scan.nextInt();
			knownWeight += labGrade;
			weightedSum += labGrade * labScore;
		}

		// projects
		System.out.print("Do you know your project average?");
		String projectAnswer = scan.next();
		int projectScore = -1;
		if (projectAnswer.equalsIgnoreCase("y") || projectAnswer.equalsIgnoreCase("yes")) {
			System.out.print("Average project grade:");
			projectScore = scan.nextInt();
			knownWeight += projects;
			weightedSum += projects * projectScore;
		}

		// participation
		System.out.print("Do you know your participation average?");
		String participationAnswer = scan.next();
		int participationScore = -1;
		if (participationAnswer.equalsIgnoreCase("y") || participationAnswer.equalsIgnoreCase("yes")) {
			System.out.print("Average participation grade:");
			participationScore = scan.nextInt();
			knownWeight += participation;
			weightedSum += participation * participationScore;
		}

		// quizzes
		System.out.print("Do you know your quiz average?");
		String quizAnswer = scan.next();
		int quizScore = -1;
		if (quizAnswer.equalsIgnoreCase("y") || quizAnswer.equalsIgnoreCase("yes")) {
			System.out.print("Average quiz grade:");
			quizScore = scan.nextInt();
			knownWeight += quizzes;
			weightedSum += quizzes * quizScore;
		}

		// calculate current grade
		double currentGrade = (double) weightedSum / knownWeight;
		System.out.printf("Current grade score:%.2f\n", currentGrade);

		// find current letter grade
		String currentLetter = "";
		if (currentGrade >= 90) currentLetter = "A";
		else if (currentGrade >= 80) currentLetter = "B";
		else if (currentGrade >= 70) currentLetter = "C";
		else if (currentGrade >= 60) currentLetter = "D";
		else currentLetter = "F";


		System.out.println("Your current letter grade:" + currentLetter);

		// if all scores are known, this is final grade
		if (knownWeight == 100) {
			if (currentLetter.equalsIgnoreCase(desiredGrade)) {
				System.out.println("Congratulations! You received the " 
						+ currentLetter + " that you wanted!");
			} else {
				System.out.println("Unfortunately, a grade of " 
						+ desiredGrade.toUpperCase() + " is not possible.");
			}
		}

		// otherwise calculate needed average
		else {
			int finalOverallScore = 0;
			if (desiredGrade.equalsIgnoreCase("A")) finalOverallScore = 90;
			else if (desiredGrade.equalsIgnoreCase("B")) finalOverallScore = 80;
			else if (desiredGrade.equalsIgnoreCase("C")) finalOverallScore = 70;
			else if (desiredGrade.equalsIgnoreCase("D")) finalOverallScore = 60;
			else finalOverallScore = 0; 

			double neededAverage = 
					(100.0 * finalOverallScore - weightedSum) / (100 - knownWeight);

			if (neededAverage > 100) {
				System.out.println("Unfortunately, a grade of " 
						+ desiredGrade.toUpperCase() + " is not possible.");
			} else if (neededAverage < 0) {
				System.out.println("You will receive at least a grade of " 
						+ desiredGrade.toUpperCase() + ".");
			} else {
				System.out.printf("In order to receive a grade of %s,\n" +
						"you need to score an average greater than\n" +
						"or equal to %.2f in the rest of the grade items.\n", 
						desiredGrade.toUpperCase(), neededAverage);
			}
		}

		// close scanner
		scan.close();
	}
}