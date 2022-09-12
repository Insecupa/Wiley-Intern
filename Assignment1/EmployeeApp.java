package Assignment1;

public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] employee = new Employee[5];
		employee[0] = new Employee(101, "John Doe", "IT", 1090.00);
		employee[1] = new Employee(102, "Won Goh", "Management", 700.35);
		employee[2] = new Employee(103, "Ban Low", "IT", 1540.22);
		employee[3] = new Employee(104, "Twan Pough", "Analytics", 812.35);
		employee[4] = new Employee(105, "Can Dow", "Hygiene", 433.23);

		
		
		for(Employee emplo : employee) {
			System.out.println(emplo.getEmpName() + "  " + emplo.getEmpGrossSalary());
		}
		
		//Problem 1
		Employee.sortEmployees(employee);
				
		//Problem 1
		String dept = "IT";
		Employee.displayEmployees(employee, dept);
		
		//Problem 2
		Employee employee5 = new Employee(105, "Can Dow", "Hygiene", 433.23);
		if(employee5.equals(employee[0]))
			System.out.println("These both are equal.");
		else
			System.out.println("These both are not equal.");
	}
}
