package ll;

public class Student {

	String name;
	int redID;
	double gpa;

	public Student() {
		this.name = null;
		this.redID = 0;
		this.gpa = 0;
	}

	public Student(String name, int redID, double gpa) {
		this.name = name;
		this.redID = redID;
		this.gpa = gpa;
	}

	public String getStudentName() {
		return name;
	}

	public int getRedId() {
		return redID;
	}

	public double getGPA() {
		return gpa;
	}

	public boolean onProbation() {
		return gpa < 2.85;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", redID=" + redID + ", gpa=" + gpa
				+ "]";
	}
}