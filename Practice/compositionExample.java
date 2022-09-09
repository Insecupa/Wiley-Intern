//This file demonstrates the usage of Composition in Java;
//Composition is basically a stricter aggregation;

//This is a subject Class
class Subject{
	int subId;
	int teacherId;
	String teacherName;
	int marksScored;
	
	public Subject(int subId, int teacherId, String teacherName, int marksScored) {
		super();
		this.subId = subId;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.marksScored = marksScored;
	}
}

//This is the student class, and as seen we cannot add a subject without using;
//a method from eStudent class, this enables us to destroy all the subject instances;
//if the eStudent instance is deleted unlike in Aggregation we have to delete it manually
class eStudent{
	int studentId;
	String studentName;
	int noOfSubjects;
	Subject[] subjects;
	
	public eStudent(int studentId, String studentName, int noOfSubjcets) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.noOfSubjects = noOfSubjcets;
		this.subjects = new Subject[noOfSubjects];
	}
	
	public void addSubject(int subjectNo, int subId, int teacherId, String teacherName, int marksScored) {
		this.subjects[subjectNo - 1] = new Subject(subId, teacherId, teacherName, marksScored);
	}
}

public class compositionExample {
	public static void main(String[] args) {
		eStudent student1 = new eStudent(101, "Radha", 5);
		student1.addSubject(1, 201, 301, "Radhe", 15);
	}
}
