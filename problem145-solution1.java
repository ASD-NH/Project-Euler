import java.util.Scanner;
import java.lang.Math;
import java.io.*;

/* Problem 145 - Reversibles - Solved by Stephan Lensky December 2015 */
class reversibles
{ 

	public static final int MAXVAL = 1000000000;
	
  	public static void main(String[] args) throws IOException
  	{
  		Scanner scan = new Scanner (System.in); //create scanner
  		
  		//sum = n + reverse(n)
  		//count = # of reversibles below MAXVAL
  		int sum, count = 0;
  		//curr_num is the current number being tested as a string
  		//reverse_num is the reverse of curr_num
  		String curr_num, reverse_num;
  		
  		//flag variable
  		Boolean reversible = true;
  		
  		//Main loop, i is the current number being tested
  		for (int i = 0; i < MAXVAL; i++) {
  			
  			if (i % 100000 == 0) {
  				System.out.println(i);
  			}
  			
  			//Reset variables
  			reversible = true;
  			reverse_num = "";
  			curr_num = Integer.toString(i);
  			
  			//Reverse the number (confirmed works)
  			for (int j = 0; j < curr_num.length(); j++) {
  				reverse_num = curr_num.charAt(j) + reverse_num;
  			}
  			
  			//Cast both as integers and sum them
  			sum = Integer.parseInt(curr_num) + Integer.parseInt(reverse_num);
  			
  			//Loop k times, where k is the # of digits in sum
  			for (int k = 0; k < Integer.toString(sum).length(); k++) {
  				//If the character at k % 2 = 0, there is an even digit in the number
  				int currentChar;
  				currentChar = (int) (sum / Math.pow(10, k));
  				currentChar = (int) (currentChar % Math.pow(10, k+1));
  				
  				if (((int) (currentChar % 2) == 0)) {
  					reversible = false;
  				}
  			}
  			
  			//If reversible is composed of entirely odd digits, add 1 to the total count
  			if (reversible) {
  				count += 1;
  			}
  			
  		}
  		
  		System.out.println(count);
  	}
}
