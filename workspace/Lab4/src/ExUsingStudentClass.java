import java.util.LinkedList;

public class ExUsingStudentClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Student> myAlgClass = new LinkedList<Student>();
			Student s1 = new Student(111,"Joe Blow", 4.0);
			Student s2 = new Student(222,"Bill Nye", 3.6);
			Student s3 = new Student(333,"Jimmy Crackhead", 1.2);
			
			myAlgClass.add(s1);
			myAlgClass.add(s2);
			myAlgClass.add(s3);
			
			for (Student tmpStu : myAlgClass)
			{ System.out.printf("\n%s", tmpStu.toString());		
			}
	}
}
