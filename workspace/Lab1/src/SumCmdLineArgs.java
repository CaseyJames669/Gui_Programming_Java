public class SumCmdLineArgs{
	public static void main(String[] args){
		int numEntries = args.length;
		System.out.println(numEntries);
		int sum = 0, num;
		for (int ct = 0; ct < numEntries; ct++){
			num = Integer.parseInt(args[ct]);
			sum += num;
		}//end for
		System.out.println(sum);
	}//end main
}//end SumCmdLineArgs
