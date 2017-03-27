import java.util.Scanner;

public class SumThreeNumbers{
	public static void main(String[] args){
		Scanner myInput = new Scanner(System.in);
		int sum = 0, num, ct;
		for (ct = 1; ct <=3; ct++){
			System.out.print("Please enter an integer: ");
			num = myInput.nextInt();
			sum += num;
		}//end for
		System.out.println("The sum is: " + sum);
	}
}
