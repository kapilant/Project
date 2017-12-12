import java.util.Scanner;
import java.math.*;

public class Driver
{
	public static void main(String[] Args)
	{
		int counter = 0;
		int total,length=0;
		int[]  divisors= new int[100];
		System.out.println("Enter the total number of collegues"); //getting user input for the 
		// total number
		Scanner userTotal = new Scanner(System.in);
		total = userTotal.nextInt();
		
		for (int i = 1; i <= total; i++) { // function to find the divisors e
			int mod = total % i;
		    if (mod == 0) {
		    	divisors[counter] = i;
		    	counter++;
		    }
		}
		        
		for (int i = 0; divisors[i] != 0; i++) // function to ignore the array elements that 
			//are zero
		{
		 length++;
		}
		int iwidth = (int)(Math.random()*length); // random width index
		int width = divisors[iwidth];
		int height = total/width; // corresponding height
		
		
		if(width >= 0 && height >= 0) {
			GameBoard b = new GameBoard("Locate The Blacksheep", width,height);
		}
		
	}
}
