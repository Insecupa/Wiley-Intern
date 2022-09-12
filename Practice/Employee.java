
public class Employee implements Cloneable{
	
	private int empId;
	private String empName;
	
	public Employee() {
		this(0, "");
	}
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public String toString() {
		return "Employee Id: " + this.empId + "\nEmployee Name: " + this.empName + "\n";
	}
	


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employee e = this;
		
		return e;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = (Employee) e2.clone();
		
	}
}
