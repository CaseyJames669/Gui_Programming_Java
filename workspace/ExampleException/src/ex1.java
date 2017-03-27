import java.util.Scanner;
import java.io.*;

public class ex1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		int x = 4;
		String[] classList = {"Joe Smith"};
		Scanner sc;
		
		try 
		{
			sc = new Scanner(new BufferedReader(new FileReader("testScores.txt")));
			System.out.println(x/0);
			System.out.println(classList[1]);
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("The Array ClassList Was Out Of Bounds");
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause());
//			System.out.println(e.toString());
		}
		
		catch (ArithmeticException e)
		{
			System.out.println("There was an arithmetic ERROR");
		}
		
		catch (Exception e)
		{
			System.out.println(e.toString());
		}		
		
		System.out.println("Still Running");
	}

}
