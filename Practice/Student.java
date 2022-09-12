
public class Student {
	private int studentId;
	private String studentName;
	private double score;
	private String classBelonging;
	
	public Student(){
		
	}

	public Student(int studentId, String studentName, double score, String classBelonging) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.score = score;
		this.classBelonging = classBelonging;
	}
	
	@Override
	public String toString() {
		return "Student Id: " + this.studentId + "\nStudent Name: " + this.studentName + "\nStudent Score: " + this.score + "\nStudent Class: " + this.classBelonging;
	}
}
