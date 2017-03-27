
import java.io.*;

class PrintFile {

	public static void main(String[] args) {
		
		for (int ct=0; ct < args.length; ct++)
		{displayFile(args[ct]);
		}//end for
	}//end of main method
	
	private static void displayFile(String fileName)
	{	System.out.println(fileName + ":");
		System.out.println();
		FileReader myFile = null; //NOTE--important to declare this OUTSIDE of try block
		try
		{myFile = new FileReader(fileName);	int c;
			while ((c = myFile.read()) != -1)
			{	System.out.print((char)c);
			} //end while
		}//end try
		
		catch (FileNotFoundException noFoundEx)
		{	System.out.println("Could not open " + fileName);
		}
		catch (IOException ioEx)
		{	System.out.println("Error reading from " + fileName);
		}
		finally
		{	if (myFile != null)
			{	try { myFile.close(); }
				catch (IOException ioEx) {;} 
			}
		} //end finally
	} //end of displayFile method
}//end PrintFile
