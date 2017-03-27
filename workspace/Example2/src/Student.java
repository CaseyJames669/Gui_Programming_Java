
public class Student 
{
	private String firstName;
	private String lastName;
	private float gpa;
	
    public Student(String tempFirstName, String tempLastName, float tempGpa) 
    {
    	firstName = tempFirstName;
    	lastName = tempLastName;
    	gpa = tempGpa;
    }
    
    public Student()
    {
    	firstName = "";
    	lastName = "";
    	gpa = 0;
    }
    
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public float getGpa() 
	{
		return gpa;
	}
	public void setGpa(float gpa) 
	{
		this.gpa = gpa;
	}
}
