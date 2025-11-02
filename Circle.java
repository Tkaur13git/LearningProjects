/*
 * Circle.java
 * Author:  Tisha Kaur 
 * Submission Date:  10/31/2025
 *
 * Purpose: This program creates a Circle class that stores a circle’s name, center, and radius. 
 * It includes methods to find the circle’s area, perimeter, and diameter, and to compare and 
 * test relationships between different circles.
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

//*******************************************************
// Circle.java
//
//*******************************************************
public class Circle {

	private String name;       // declare the private String instance name
	private double radius;     // declare the private double instance radius
	private double x;          // declare the private double instance x
	private double y;          // declare the private double instance y

	// Used to compare doubles.  Remember, don't compare doubles directly using ==
	public static final double THRESHOLD = 0.000000001;

	//----------------------------------------------
	// getName - returns the value of name
	//----------------------------------------------
	public String getName() {
		return name;
	}

	//----------------------------------------------
	// getX - returns the value of x
	//----------------------------------------------
	public double getX() {
		return x;
	}

	//----------------------------------------------
	// getY - returns the value of y
	//----------------------------------------------
	public double getY() {
		return y;
	}

	//----------------------------------------------
	// getRadius - returns the value of radius
	//----------------------------------------------
	public double getRadius() {
		return radius;
	}

	//----------------------------------------------
	// setName - assigns a new value to name
	//----------------------------------------------
	public void setName(String newName) {
		name = newName;
	}

	//----------------------------------------------
	// setX - assigns a new value to x
	//----------------------------------------------
	public void setX(double newX) {
		x = newX;
	}

	//----------------------------------------------
	// setY - assigns a new value to y
	//----------------------------------------------
	public void setY(double newY) {
		y = newY;
	}

	//----------------------------------------------
	// setRadius - assigns a new value to radius
	//----------------------------------------------
	public void setRadius(double newRadius) {
		if (newRadius >= 0) {
			radius = newRadius;  
		}
	}

	//--------------------------------------------------------
	// area - returns the area of the circle
	//--------------------------------------------------------
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	//--------------------------------------------------------
	// perimeter - returns the perimeter of the circle
	//--------------------------------------------------------
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	//--------------------------------------------------------
	// diameter - calculates the diameter of the circle
	//--------------------------------------------------------
	public double diameter() {
		return 2 * radius;
	}

	//--------------------------------------------------------
	// isUnitCircle - return true if the radius of this circle
	// is 1 and its center is (0,0), false otherwise
	//--------------------------------------------------------
	public boolean isUnitCircle() {
		return Math.abs(radius - 1) < THRESHOLD &&
				Math.abs(x) < THRESHOLD &&
				Math.abs(y) < THRESHOLD;
	}

	//--------------------------------------------------------
	// equals - returns true if both circles have the same center and radius
	//--------------------------------------------------------
	public boolean equals(Circle anotherCircle) {
		return Math.abs(radius - anotherCircle.radius) < THRESHOLD &&
				Math.abs(x - anotherCircle.x) < THRESHOLD &&
				Math.abs(y - anotherCircle.y) < THRESHOLD;
	}

	//--------------------------------------------------------
	// distance - returns distance between centers
	//--------------------------------------------------------
	public double distance(Circle anotherCircle) {
		return Math.sqrt(Math.pow(x - anotherCircle.x, 2) +
				Math.pow(y - anotherCircle.y, 2));
	}

	//--------------------------------------------------------
	// isSmaller - true if this circle's diameter < another's
	//--------------------------------------------------------
	public boolean isSmaller(Circle anotherCircle) {
		return this.diameter() < anotherCircle.diameter();
	}

	//--------------------------------------------------------
	// compareTo - returns -1, 0, or 1 depending on circle size
	//--------------------------------------------------------
	public int compareTo(Circle anotherCircle) {
		if (this.isSmaller(anotherCircle)) return -1;
		else if (anotherCircle.isSmaller(this)) return 1;
		else return 0;
	}

	//--------------------------------------------------------
	// intersects - true if distance between centers < sum of radii
	//--------------------------------------------------------
	public boolean intersects(Circle anotherCircle) {
		return this.distance(anotherCircle) < (this.radius + anotherCircle.radius);
	}

	//--------------------------------------------------------
	// toString - return a String representation of this circle
	//--------------------------------------------------------
	public String toString() {
		return "name: " + name + "\ncenter: (" + x + "," + y + ")\nradius: " + radius;
	}
}
