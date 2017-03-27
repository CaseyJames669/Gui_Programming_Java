/*   
Casey Bladow
Program 1 -- Due Sept 11, 2013
Basic payroll program; employer is able to drop in a .txt file and output a list
of employees with their gross pay, net pay, overtime pay, FICA amount, and the 
year they started.

Known Issues:
Doesn't pull max, min, or average.
Doesn't pull employee that has worked the longest or was most recently hired.
 - I made an attempt to create another list and sort or pull min, max, avg 
 	numbers off that, however, my attempts weren't very succeddful.
 
*/

import java.io.*; // for File
import java.util.*; // for Scanner
import java.io.IOException; 
import java.io.FileNotFoundException;
import java.io.File;

public class Asmt1{
	public static void main(String[] args) throws IOException{
		
		if(args.length > 0 ){
			File empinfo = new File(args[0]); //Pulls empinfo.txt from the project file
			
		Scanner inFile = null;
		try{
		inFile = new Scanner(new BufferedReader(
				new FileReader(empinfo))).useDelimiter("[,\\s]+"); //breaks readline by comma
		
		ArrayList<Comparable> employees = new ArrayList<Comparable>(); //my attempt to create a list...
				
		System.out.println
		("First Name   Last Name   Gross Pay   Overtime Pay   FICA Amount   Net Pay   Year Hired");//title - not properly formatted
		while (inFile.hasNext())
			{	
				//System.out.println("Please enter the overtime rate:");
				//double overtimeRate = args.equals();
				String firstName = inFile.next(); //sets firstName
				String lastName = inFile.next(); //sets lastName
				double hourlyRate = inFile.nextDouble(); //sets hourlyRate
				double hoursWorked = inFile.nextDouble(); //sets hoursWorked
				String yearHired = inFile.next(); //sets yearHired
				double grossPay; //sets grossPay
				if (hoursWorked > 40) //decides whether or not employee makes overtime
				{
					grossPay = ((hoursWorked - 40)*(hourlyRate *1.5))+(40*hourlyRate);
				} //end if
				else
					grossPay = hoursWorked * hourlyRate;
				final double FICA_AMOUNT = .075; //creates a FICA_AMOUNT constant
				double ficaTax = grossPay * FICA_AMOUNT; //finds the amount ficaTax
				double netPay = grossPay - ficaTax; //find netPay
				double overtimePay = 0;
				if (hoursWorked > 40) //if employee worked over 40 hours, they will have overtimePay
				{
					overtimePay = (hoursWorked - 40)*(hourlyRate * 1.5);
				} //end if
				else
					overtimePay = 0;
				System.out.print(firstName + "         "); //The next few lines print out and format
				System.out.print(lastName + "     ");	   //the empinfo.txt file.
				System.out.printf("%s %.2f","   $", grossPay);
				System.out.printf(" %s %.2f","   $", overtimePay);
				System.out.printf(" %s %.2f","   $", ficaTax);
				System.out.printf(" %s %.2f","   $", netPay);
				System.out.println("    " + yearHired);
				employees.add(firstName); //the next 6 lines were my attempt to add these values to the employees list
				employees.add(lastName);  //from this list I was hoping to pull the max year and min, max, avg grossPay
				employees.add(grossPay);  //however, this method did not work like I hoped.
				employees.add(ficaTax);
				employees.add(netPay);
				employees.add(yearHired);
			} //end while
		inFile.close();  //closes inFile
		}//end try
		catch(FileNotFoundException e){
			e.printStackTrace();
		}//end catch
		}//end if
		
	} //end main		
}//end class