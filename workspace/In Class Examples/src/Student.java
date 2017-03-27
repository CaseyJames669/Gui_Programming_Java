
public class Student {
	public Student(int tmpID, String tmpName, double tmpGPA){ 
		stuID = tmpID; stuName = tmpName; stuGPA = tmpGPA;
		}
	
	public String toString() 
		{return stuID + " " + stuName + " " + stuGPA;}
	
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public double getStuGPA() {
		return stuGPA;
	}
	public void setStuGPA(double stuGPA) {
		this.stuGPA = stuGPA;
	}
	private int stuID;
	private String stuName;
	private double stuGPA;
}
