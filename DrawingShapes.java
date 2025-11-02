import java.util.Scanner;
/*
 * DrawingShapes.java
 * Author:  Tisha Kaur 
 * Submission Date:  10/31/2025
 *
 * Purpose: This program takes user input to draw different geometric shapes (rectangle, triangle, hexagon, octagon, or pentagon) made of asterisks, using loops and conditional statements to handle spacing and formatting.
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

public class DrawingShapes {

	/**
	 * draws a rectangle made of asterisks using given width and height.
	 * @param width  the number of asterisks per row
	 * @param height the number of rows
	 * @return a string representing the rectangle
	 */
	public String rectangle(int width, int height) {
		String rectangleOutput = "";
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				rectangleOutput += "*";
			}
			rectangleOutput += "\n";
		}
		System.out.println("Below is a " + width + " by " + height + " rectangle of *");
		return rectangleOutput;
	}

	/**
	 * draws a centered triangle made of asterisks.
	 * @param sideLength the number of rows 
	 * @return a string representing the triangle
	 */
	public String triangle(int sideLength) {
		String triangleOutput = "";
		int totalWidth = 2 * sideLength - 1;

		for (int row = 1; row <= sideLength; row++) {
			int starCount = 2 * row - 1;
			int spaceCount = (totalWidth - starCount) / 2;

			for (int space = 0; space < spaceCount; space++) {
				triangleOutput += " ";
			}
			for (int star = 0; star < starCount; star++) {
				triangleOutput += "*";
			}
			triangleOutput += "\n";
		}

		System.out.println("Below is a triangle with two side lengths of " + sideLength + " *");
		return triangleOutput;
	}

	/**
	 * draws a centered hexagon made of asterisks.
	 * @param sideLength the number of asterisks on each side
	 * @return a string representing the hexagon
	 */
	public String hexagon(int sideLength) {
		String hexagonOutput = "";
		int totalWidth = sideLength + 2 * (sideLength - 1);

		// top of hexagon
		for (int row = 0; row < sideLength; row++) {
			int starCount = sideLength + 2 * row;
			int spaceCount = (totalWidth - starCount) / 2;

			for (int space = 0; space < spaceCount; space++) {
				hexagonOutput += " ";
			}
			for (int star = 0; star < starCount; star++) {
				hexagonOutput += "*";
			}
			hexagonOutput += "\n";
		}

		// bottom of hexagon
		for (int row = sideLength - 2; row >= 0; row--) {
			int starCount = sideLength + 2 * row;
			int spaceCount = (totalWidth - starCount) / 2;

			for (int space = 0; space < spaceCount; space++) {
				hexagonOutput += " ";
			}
			for (int star = 0; star < starCount; star++) {
				hexagonOutput += "*";
			}
			hexagonOutput += "\n";
		}

		System.out.println("Below is a hexagon with side lengths of " + sideLength + " *");
		return hexagonOutput;
	}

	/**
	 * draws a centered octagon made of asterisks.
	 * @param sideLength the number of asterisks per side
	 * @return a string representing the octagon
	 */
	public String octagon(int sideLength) {
		String octagonOutput = "";
		int totalWidth = sideLength + 2 * (sideLength - 1);

		// top part
		for (int row = 0; row < sideLength - 1; row++) {
			int starCount = sideLength + 2 * row;
			int spaceCount = (totalWidth - starCount) / 2;

			for (int space = 0; space < spaceCount; space++) {
				octagonOutput += " ";
			}
			for (int star = 0; star < starCount; star++) {
				octagonOutput += "*";
			}
			octagonOutput += "\n";
		}

		// middle section
		for (int row = 0; row < sideLength; row++) {
			for (int star = 0; star < totalWidth; star++) {
				octagonOutput += "*";
			}
			octagonOutput += "\n";
		}

		// bottom part
		for (int row = sideLength - 2; row >= 0; row--) {
			int starCount = sideLength + 2 * row;
			int spaceCount = (totalWidth - starCount) / 2;

			for (int space = 0; space < spaceCount; space++) {
				octagonOutput += " ";
			}
			for (int star = 0; star < starCount; star++) {
				octagonOutput += "*";
			}
			octagonOutput += "\n";
		}

		System.out.println("Below is an octagon with side lengths of " + sideLength + " *");
		return octagonOutput;
	}

	/**
	 * draws a centered pentagon made of asterisks.
	 * @param sideLength the number of rows for the top section
	 * @return a string representing the pentagon
	 */
	public String pentagon(int sideLength) {
		String pentagonOutput = "";
		int totalWidth = 2 * sideLength - 1;

		// top section
		for (int row = 1; row <= sideLength; row++) {
			int starCount = 2 * row - 1;
			int spaceCount = (totalWidth - starCount) / 2;

			for (int space = 0; space < spaceCount; space++) {
				pentagonOutput += " ";
			}
			for (int star = 0; star < starCount; star++) {
				pentagonOutput += "*";
			}
			pentagonOutput += "\n";
		}

		// bottom section that forms rectangle
		for (int row = 0; row < sideLength - 1; row++) {
			for (int star = 0; star < totalWidth; star++) {
				pentagonOutput += "*";
			}
			if (row < sideLength - 2) {
				pentagonOutput += "\n";
			}
		}

		System.out.println("Below is a pentagon with 4 side lengths of " + sideLength + " *");
		return pentagonOutput;
	}

	//main method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DrawingShapes shapeDrawer = new DrawingShapes();

		System.out.println("Enter a shape: r t h o p");
		String selectedShape = scan.nextLine();

		if (selectedShape.equals("r") || selectedShape.equals("t") || 
				selectedShape.equals("h") || selectedShape.equals("o") || 
				selectedShape.equals("p")) {

			System.out.println("Enter a length");
			int shapeLength = scan.nextInt();

			if (shapeLength > 1) {
				String shapeResult = "";

				if (selectedShape.equals("t")) {
					shapeResult = shapeDrawer.triangle(shapeLength);
				} else if (selectedShape.equals("h")) {
					shapeResult = shapeDrawer.hexagon(shapeLength);
				} else if (selectedShape.equals("o")) {
					shapeResult = shapeDrawer.octagon(shapeLength);
				} else if (selectedShape.equals("p")) {
					shapeResult = shapeDrawer.pentagon(shapeLength);
				} else if (selectedShape.equals("r")) {
					System.out.println("Enter a height");
					int shapeHeight = scan.nextInt();

					if (shapeHeight > 1) {
						shapeResult = shapeDrawer.rectangle(shapeLength, shapeHeight);
					} else {
						System.out.println("Height must be greater than 1");
						System.out.println("Goodbye!");
					}
				}

				System.out.println(shapeResult);
			} else {
				System.out.println("Length must be greater than 1");
				System.out.println("Goodbye!");
			}

		} else {
			System.out.println("Invalid shape");
			System.out.println("Goodbye!");
		}

		scan.close();
	}
}
