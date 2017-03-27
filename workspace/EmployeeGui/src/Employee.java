
public class Employee 
{
	    private String firstName;
	    private String lastName;
	    private int salary;
	    private int yrsWorked;
	    private double bonusPercentage;
	    
	    public Employee()
	    {
	        firstName = "";
	        lastName= "";
	        salary = 0;
	        yrsWorked = 0;
	        bonusPercentage = 0.00;
	        
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public int getSalary() {
	        return salary;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }

	    public int getYrsWorked() {
	        return yrsWorked;
	    }

	    public void setYrsWorked(int yrsWorked) {
	        this.yrsWorked = yrsWorked;
	    }

	    public double getBonusPercentage() {
	        return bonusPercentage;
	    }

	    public void setBonusPercentage(double bonusPercentage) {
	        this.bonusPercentage = bonusPercentage;
	    }	
}
