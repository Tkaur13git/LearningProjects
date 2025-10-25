/*
 * StarGraph.java
 * Author:  Tisha Kaur 
 * Submission Date:  10/23/2025
 *
 * Purpose: This program inputs values from the user to create 2 arrays, x and y, to then output the complete calculated values that each array holds and the corresponding star grap
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

public class StarGraph {

	public static void main(String[] arg) {
		
		Scanner scan = new Scanner(System.in);
	
		System.out.print("Please enter the number of x values to process: ");
		int numToProcess = scan.nextInt();
		if (numToProcess <= 0) {
			System.out.println("The number of x values must be an integer greater than 0.");
			System.exit(0);
		}
		
		System.out.print("Enter a minimum value for x: ");
		double minValue = scan.nextDouble();
		
		System.out.print("Enter the amount to increment x: ");
		double incrementAmt = scan.nextDouble();
		
		if (incrementAmt <= 0) {
			System.out.println("The increment must be a decimal number greater than 0.");
			System.exit(0);
		}
			
		double[] x = new double[numToProcess];
		double[] y = new double[numToProcess];
	
		
		double loopVal = minValue;
		for (int i = 0; i < numToProcess; i++) {
			x[i] = loopVal;
			double absoluteValue = 20.0 * Math.abs(Math.sin(x[i]));
			y[i] = absoluteValue;
			loopVal += incrementAmt;
		}
	
		System.out.println();
		System.out.println("Values");
		
		int i = 0;
		while (i < numToProcess) {
		System.out.printf("x: %.3f, y: %.3f%n",x[i], y[i]);
		i++;
		}
		
		System.out.println();
		System.out.println("Graph");

		//print out simple graphs
		for (i = 0; i < numToProcess; i++) {
			int wholeNumStar = (int) y[i];
			System.out.print(":");
			for (int j = 0; j < wholeNumStar; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			
			scan.close();

		}
}
