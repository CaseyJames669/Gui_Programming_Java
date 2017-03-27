/**
 * 
 * @author Casey Bladow
 * 
 *
 */
public class Student {
	/**
	 * 
	 * @param tmpID
	 * @param tmpName
	 * @param tmpGPA
	 */
	public Student(int tmpID, String tmpName, double tmpGPA){ 
		stuID = tmpID; stuName = tmpName; stuGPA = tmpGPA;
		}

	public String toString() 
		{return stuID + " " + stuName + " " + stuGPA;}
	/**
	 * gets stuID
	 * @return stuID
	 */
	public int getStuID() {
		return stuID;
	}
	/**
	 * sets stuID
	 * @param stuID
	 */
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	/**
	 * gets stuName
	 * @return stuName
	 */
	public String getStuName() {
		return stuName;
	}
	/**
	 * sets stuName
	 * @param stuName
	 */
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	/**
	 * gets StuGPA
	 * @return stuGPA
	 */
	public double getStuGPA() {
		return stuGPA;
	}
	/**
	 * sets stuGPA
	 * @param stuGPA
	 */
	public void setStuGPA(double stuGPA) {
		this.stuGPA = stuGPA;
	}
	/**
	 * 
	 */
	private int stuID;
	private String stuName;
	private double stuGPA;
}
