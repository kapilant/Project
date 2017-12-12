import java.util.Scanner;
import java.math.*;
public class TestSuite {

	public static void main(String[] args) {
		int counter = 0;
		int total,length=0;
		int[]  divisors= new int[100];
		System.out.println("Enter the total number of collegues");
		Scanner userTotal = new Scanner(System.in);
		total = userTotal.nextInt();
		
		for (int i = 1; i <= total; i++) {
			int mod = total % i;
		    if (mod == 0) {
		    	divisors[counter] = i;
		    	counter++;
		    }
		}
		        
		for (int i = 0; divisors[i] != 0; i++)
		{
		 length++;
		}
		System.out.println(length);
		int iwidth = (int)(Math.random()*length);
		int width = divisors[iwidth];
		int height = total/width;
		System.out.println(width);
		System.out.println(height);
		}
	}


