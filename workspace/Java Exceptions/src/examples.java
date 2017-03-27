
public class examples {
	public static void main(String[] args) {
		try {
			Object[] myScores = newInteger[2];
			myScores[0] = new String();
		}
		catch (ArrayStoreException e){
			System.out.println("Must only add integers to the myScores array\n ");
			System.out.println(e.toString());
		}
		System.out.println("Still running");	
	}
}
