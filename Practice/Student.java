//Classes - Composition Example?? - related Files - { Student.java, Date.java }

//has a
//Agregation and Compostion?? - Team
public class Student {
	int regNo;
	String studentName;
	Date dtOfAdmission;
	
	public Student() {
		this.regNo = 1;
		this.studentName = "NONE";
		this.dtOfAdmission = null;
	}
	public Student(int regNo, String studentName, Date dtOfAdmission) {
		this.regNo = regNo;
		this.studentName = studentName;
		this.dtOfAdmission = dtOfAdmission;
	}
	
	public void displayStudent() {
		System.out.println("Reg No: " + this.regNo + ", Name: " + this.studentName + ", Date of Admission is: " + dtOfAdmission.displayDate());
	}
	
	public static void main(String[] args) {
		Date date1 = new Date(9, 9, 2022);
		//Why 09 != 9? 07 is taken as octal and 7 as base 10
		if(date1.checkDate() == true) {
			Student student1 = new Student(1, "Balu", date1);
			student1.displayStudent();
		}else {
			System.out.println("Date is invalid");
		}
	}
}
