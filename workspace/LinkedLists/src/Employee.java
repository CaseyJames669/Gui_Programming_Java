import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.BufferedReader;

import javax.xml.bind.ParseConversionEvent;

public class Employee 
{
	public static void main(String[] args) throws IOException
	{
		String name;
		String fileName = new String(args[0]);
		//String fileName;
		String lastName = "";
		String firstName = "";
		double salary = 0;
		int yrsWorked = 0;
		double bonusPer = 0;
		double percent = 0;
		double totalSalary = 0;
		double totalTotal = 0;
		Boolean test = false;
		
		LinkedList list = new java.util.LinkedList();
		LinkedList list2 = new java.util.LinkedList();

//		Scanner input = new Scanner(System.in);		
//		System.out.print("Enter File Name: ");
//		fileName = input.next();
		
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName))).useDelimiter(",\\s*"); //Reading the file in

		while(scanner.hasNext())
		{		
			name = scanner.next();
			
			String[] testing = name.split("\\s+");
			
			if(testing.length > 0) 
			{
		        firstName = testing[0];
		        lastName = testing[1];
		    }
	
			salary = scanner.nextInt();
			
			yrsWorked = scanner.nextInt();
			
			if (yrsWorked < 5)
			{
				bonusPer = 2;				
			}
			
			if (yrsWorked >= 5)
			{
				bonusPer = 3;
			}		
			
			totalSalary = ((bonusPer/100)*salary) + salary;		
			 
//list.add(firstName + "\t" + lastName + "\t" + salary + "\t" + yrsWorked + "\t" + bonusPer + "%\t" + totalSalary + "\n");
			
			list.add(firstName + "\t");
			list.add(lastName + "\t");
			list.add("$" + salary + "\t");
			list.add(yrsWorked + "\t");
			list.add(bonusPer + "%\t");
			list.add("$" + totalSalary + "\n");
			
//			list.add(firstName);
//			list.add(lastName);
//			list.add(salary);
//			list.add(yrsWorked);
//			list.add(bonusPer);
//			list.add(totalSalary);
		}
		
		System.out.println("ABC Company Employee Roster");
		System.out.println("First\tLast\tSalary\t\tYears\tBonus\tTotalSalary");
		for(int i=0; i< list.size(); i++)
		{	
				System.out.print(list.get(i));			
		}	

		//Collections.sort(list);
		
		int years = 0;
		float grandTotal = 0;
		for(int i=3; i < list.size(); i++)
		{
			years = Integer.parseInt(list.get(i).toString().replace("%", "").replace("\t", ""));
		
			if (years >= 5)
			{
				totalTotal = Double.parseDouble(list.get(i + 2).toString().replace("$", ""));
				list2.add(totalTotal);
			}		
			
			i+=5;
		}
		
		for(int i=0; i < list2.size(); i++)
		{
			grandTotal += Float.parseFloat(list2.get(i).toString());
		}
		
		grandTotal = grandTotal/list2.size();
		
		System.out.println("\nAverage Total Salary for Employees with 5 or More Years: " + grandTotal);
		
		Scanner input2 = new Scanner(System.in);		
		System.out.print("Search for Last Name: ");
		String searchName = input2.next();

		for(int i=1; i< list.size(); i++)
		{			
			if (list.get(i).toString().contains(searchName))
			{
				System.out.println(list.get(i-1).toString() + " " + list.get(i).toString() + " " + list.get(i+1));
				test = true; 
				i+=6;
			}			
		}	 
		
		if (test == false)
		{
			System.out.println("The list does NOT contain " + searchName);
		}
	}
}
