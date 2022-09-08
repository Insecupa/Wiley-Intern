//This program illustrates the usage of Default Constructor and 
//parameterized constructor. This program also shows the usage of 
// "this" keyword

public class Employee {
	int empId;
	String empName;
	
	public Employee() {
		empId = 0;
		empName = "No Name";
	}
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public void printDetails() {
		System.out.println("Emp Id: " + empId);
		System.out.println("Emp Name: " + empName);
	}
}
