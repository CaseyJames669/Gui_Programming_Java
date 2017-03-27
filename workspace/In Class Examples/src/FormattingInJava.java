
import java.text.DecimalFormat;

public class FormattingInJava {
	public static void main(String[] args){

		String name = "Joe Smith";
		System.out.printf("%s %n",name);
		System.out.printf("%-20s %n",name);
		System.out.printf("%20s %n",name);
		
		int hours = 40;
		System.out.printf("%5d %05d %n",hours,hours);
		
		double gp = 1867000.236;
		System.out.printf("%s %8.2f","Gross Pay: $", gp);
		System.out.printf("%s %,8.2f","Gross Pay: $", gp);
		
		//DecimalFormatfrmtCurrency = new DecimalFormat("$#,###.##");
		//double amt = 1234.56789;
		//System.out.println(frmtCurrency.format(amt));
		}
}