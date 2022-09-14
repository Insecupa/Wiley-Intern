//Assignment 9
public class EmployeeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address permAddress = new Address(202, "Wiley Residency", "3", "Hyderabad");
		Address tempAddress = new Address(101, "Edge", "DevBirds Road", "Hyderabad");
		Employee emp = new Employee(101, "Wan Gough", permAddress, tempAddress);
		emp.display();
	}

}
