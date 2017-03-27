import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ScannerClass {

	/**
	 * @param args
	 */
	// this class reads in a .txt file then outputs it to the command prompt.
    // It also calculates the average score for each individual person and the avg, high, and low scores of each test.
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String lastName; 
		String firstName;
		float test1 = 0;
		float test2 = 0;
		float test3 = 0; 
		float average;
		float sumT1=0;
		float sumT2=0;
		float sumT3=0;
		float high = 0;
		float high2 = 0;
		float high3 = 0;
		float low = 0;
		float low2 = 0;
		float low3 = 0;
		float zero = 0;
		float zero2 = 0;
		float zero3 = 0;
		float zero4 = 101;
		float zero5 = 101;
		float zero6 = 101;
		String fileName = new String(args[0]);
		
		//Scanner input = new Scanner(System.in);
		
		//System.out.print("Enter File Name: ");
		//fileName = input.next();	//filename entered in the command prompt
		
		//Scanner scanner = new Scanner(new BufferedReader(new FileReader("testScores.txt"))).useDelimiter(",\\s*");
		//Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName))).useDelimiter(",\\s*"); //Reading the file in 
		Scanner scanner = null;
		try
		{
		scanner = new Scanner(new BufferedReader(new FileReader(fileName))).useDelimiter(",\\s*");//creating a scanner to go through the file after , 
		
			while(scanner.hasNext())
			{		
				firstName = scanner.next();
				lastName = scanner.next();
				test1 = scanner.nextFloat(); 				
				test2 = scanner.nextFloat(); 
				test3 = scanner.nextFloat();
				average = (test1 + test2 + test3)/3;
				sumT1 += test1; 
				sumT2 += test2; 
				sumT3 += test3;
				
				if (test1 > zero)
				{
					high = test1;
					zero = test1;
				}
				
				if (test2 > zero2)
				{
					high2 = test2;
					zero2 = test2;
				}
				
				if (test3 > zero3)	
				{
					high3 = test3;
					zero3 = test3;
				}
				
				if (test1 < zero4)
				{
					low = test1;
					zero4 = test1;
				}
				
				if (test2 < zero5)
				{
					low2 = test2;
					zero5 = test2;
				}
				
				if (test3 < zero6)	
				{
					low3 = test3;
					zero6 = test3;
				}
						
				System.out.printf("%s, %s %4.1f %4.1f %4.1f Average: %4.1f \n", lastName, firstName, test1, test2, test3, average);					
			}
		
			System.out.printf("T1 Average: %4.1f HighScore: %4.1f LowScore: %4.1f \n", (sumT1/3.0), high, low);
			System.out.printf("T2 Average: %4.1f HighScore: %4.1f LowScore: %4.1f \n", (sumT2/3.0), high2, low2);
			System.out.printf("T3 Average: %4.1f HighScore: %4.1f LowScore: %4.1f \n", (sumT3/3.0), high3, low3);
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
			}
			
		}
		
	}
}
