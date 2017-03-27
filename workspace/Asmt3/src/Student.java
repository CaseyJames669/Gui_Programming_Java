
public class Student {
	public Student(String tmpfirstName, String tmplastName, float tmpGPA, String tmpMajor){ 
		stufirstName = tmpfirstName; stulastName = tmplastName; stuGPA = tmpGPA; stuMajor = tmpMajor;
		}
	
	public String toString() 
		{return stufirstName + " " + stulastName + " " + stuGPA + " " + stuMajor;}
	
	public String getstufirstName() {
		return stufirstName;
	}
	public void setstufirstName(String stufirstName) {
		this.stufirstName = stufirstName;
	}
	public String getstulastName() {
		return stulastName;
	}
	public void setstulastName(String stulastName) {
		this.stulastName = stulastName;
	}
	public double getStuGPA() {
		return stuGPA;
	}
	public void setStuGPA(float stuGPA) {
		this.stuGPA = stuGPA;
	}
	public String getstuMajor() {
		return stuMajor;
	}
	public void setstuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}
	
	private String stufirstName;
	private String stulastName;
	private float stuGPA;
	private String stuMajor;
}
