import java.util.Scanner;


public class TestStudent {

	public static void main(String[] args) 
	{
		
		Student[] classList;		
		classList = new Student[10];
		
		classList[0] = new Student();		
		classList[0].setFirstName("Zach");
		classList[0].setLastName("Bladow");
		classList[0].setGpa(4);
		
		
		classList[1] = new Student();
		classList[1].setFirstName("Chelsea");
		classList[1].setLastName("Daley");
		classList[1].setGpa(3);
		
		classList[2] = new Student();
		classList[2].setFirstName("Jake");
		classList[2].setLastName("Eckert");
		classList[2].setGpa(2);
		
		for (int i = 2; i > -1; i--)
		{
			System.out.println(classList[i].getFirstName() + " " + classList[i].getLastName() + " " + classList[i].getGpa());	
		}		
		
		System.out.println("\n");
		
		classList[0] = new Student("Zach", "Bladow", 4);
		classList[1] = new Student("Chelsea", "Daley", 3);
		classList[2] = new Student("Jake", "Eckert", 2);
		for (int i = 2; i > -1; i--)
		{
			System.out.println(classList[i].getFirstName() + " " + classList[i].getLastName() +  " " + classList[i].getGpa());	
		}
		
		
		
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter First Names, Last Name, and Gpa: ");
//		classList[0] = new Student(input.next(), input.next(), input.nextFloat());
//		classList[1] = new Student(input.next(), input.next(), input.nextFloat());
//		classList[2] = new Student(input.next(), input.next(), input.nextFloat());
//		
//		for (int i = 2; i > -1; i--)
//		{
//			System.out.println(classList[i].getFirstName() + " " + classList[i].getLastName() +  " " + classList[i].getGpa());	
//		}
	}

}
