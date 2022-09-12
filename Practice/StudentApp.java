
public class StudentApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = new Student[10];
		
		students[0] = new Student(101, "Mani", 90.23, "A");
		
		students[2] = new Student(103, "Phani", 23.2, "C");
		students[3] = new Student(104, "Kani", 45.23, "A");
		students[4] = new Student(105, "Wani", 90.23, "B");
		students[1] = new Student(102, "Gani", 73.68, "B");
		
//		for(Student student : students) {
//			System.out.println(student.toString());
//			System.out.println();
//		}
		
		
		//Default for a class is null;
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i].toString());
			System.out.println();
		}
	}

}
