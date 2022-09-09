//Understaing static - related Files - { Employee.java }
public class Employee {
	int empId;
	String empName;
	
	static int empCounter;
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
		empCounter++;
	}
	//static instantiation block
	/*
	 * staic - variable, method, block, instantiatin block
	 */
	
	static {
		empCounter = 0;
	}
	
	public static int getEmployeeCounter() {
		return empCounter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1 = new Employee(101, "abc");
		Employee employee2 = new Employee(102, "pqr");
		Employee employee3 = new Employee(103, "xyz");
		
		System.out.println("Number of employees: " + Employee.getEmployeeCounter());
	}

}
