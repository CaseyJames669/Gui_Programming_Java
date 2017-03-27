import java.util.concurrent.CopyOnWriteArrayList;

public class lastNamesClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String [] lastNames = 
			{
				"apple","black","crash","diddo","empty","free","good","help","import","johnson"
			};
		
		String [] lastNames2 = new String [5];
		System.arraycopy(lastNames, 5, lastNames2, 0, 5);
			
		for (int i = 0; i < 5; i++)
		{
			System.out.println(lastNames2[i]);
		}
	}
}
