import java.util.Scanner;
import java.lang.Math;
import java.io.*;

/* Problem 102 - Triangle Containment - Solved by Stephan Lensky December 2015 */
class Triangle
{
	//coords is a 3x2 array that stores 3 pairs of coordinates
	//setCoords assigns values to coords
	//getArea returns the area
	
	int[][] coords;
	
	public Triangle() {
		coords = new int[3][2];
	}
	
	public void setCoords(int point, int x, int y)
	{
		coords[point][0] = x;
		coords[point][1] = y;
	}
	public double getArea()
	{
		//Shoelace formula (calculates area of a triangle given points)
		double area = 0.5 * Math.abs((coords[0][0] - coords[2][0])*
									(coords[1][1] - coords[0][1]) - 
									(coords[0][0] - coords[1][0])*
									(coords[2][1] - coords[0][1]));
		return area;
	}
}

class Main
{ 

	public static void main(String[] args) throws IOException
  	{
  		Scanner scan = new Scanner (System.in); //create scanner
  		
  		//Initialize triangles
  		//total_area is the combined area of the last 3 triangles
  		//0 = point A
  		//1 = point B
  		//2 = point C
  		Triangle triangle1 = new Triangle();
  		Triangle triangleBA = new Triangle();
  		Triangle triangleAC = new Triangle();
  		Triangle triangleBC = new Triangle();
  		double total_area;
  		
  		//Input variables + get input
  		int ax, ay, bx, by, cx, cy;
  		
  		System.out.println("Please enter some coordinates:");
  		ax = scan.nextInt();
  		ay = scan.nextInt();
  		bx = scan.nextInt();
  		by = scan.nextInt();
  		cx = scan.nextInt();
  		cy = scan.nextInt();
  		
  		//Assign input to triangle object
  		triangle1.setCoords(0, ax, ay);
  		triangle1.setCoords(1, bx, by);
  		triangle1.setCoords(2, cx, cy);
  		
  		//Assign coordinates of origin triangles
  		triangleBA.setCoords(0, triangle1.coords[0][0], triangle1.coords[0][1]);
  		triangleBA.setCoords(1, triangle1.coords[1][0], triangle1.coords[1][1]);
  		triangleBA.setCoords(2, 0, 0);
  		
  		triangleAC.setCoords(0, triangle1.coords[0][0], triangle1.coords[0][1]);
  		triangleAC.setCoords(1, triangle1.coords[2][0], triangle1.coords[2][1]);
  		triangleAC.setCoords(2, 0, 0);
  		
  		triangleBC.setCoords(0, triangle1.coords[1][0], triangle1.coords[1][1]);
  		triangleBC.setCoords(1, triangle1.coords[2][0], triangle1.coords[2][1]);
  		triangleBC.setCoords(2, 0, 0);
  		
  		//Sum the areas and print them
  		total_area = triangleBA.getArea() + triangleAC.getArea() + triangleBC.getArea();
  		System.out.println("Area of original: " + triangle1.getArea());
  		System.out.println("Area of others (summed): " + total_area);
  		
  		//Final test
  		if (triangle1.getArea() == total_area) {
  			System.out.println("The origin is contained within the triangle");
  		}
  		else {
  			System.out.println("The original is NOT contained within the triangle");
  		}
  		
  	}
}
