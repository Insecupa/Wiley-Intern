package Assignment1;

/*
 * Create Employee class with following details: 
Attributes: 
empId, empName, empDept, empBasicSalary, empGrossSalary 
Behaviour
oParameterized constructor for empId,empName, empDept and 
empBasicSalary
ocalculateGrossSalary to calculate grossSalary with following formula
grossSalary=basicSalary+HRA+DA
HRA=12% of basicSalary
DA=8%of basicSalary
 */
public class Employee {
	private int empId;
	private String empName;
	private String empDept;
	private double empBasicSalary;
	private double empGrossSalary;

	public Employee(int empId, String empName, String empDept, double empBasicSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empBasicSalary = empBasicSalary;
		this.empGrossSalary = calculateGrossSalary();
	}
	
	private double calculateGrossSalary() {
		double HRA = 0.12 * this.empBasicSalary;
		double DA = 0.08 * this.empBasicSalary;
		
		return this.empBasicSalary + HRA + DA;
	}
	
	//Problem 2
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Employee e = (Employee) obj;
		if(this.empId == e.empId && this.empName.equals(e.empName))
			return true;
		return false;
	}
	
	
	//Problem 1	
	public static Employee[] sortEmployees(Employee[] employees) {
        int n = employees.length;
        for (int i = 1; i < n; ++i) {
            Employee key = employees[i];
            int j = i - 1;
            while (j >= 0 && employees[j].getEmpGrossSalary() > key.getEmpGrossSalary()) {
                employees[j + 1] = employees[j];
                j = j - 1;
            }
            employees[j + 1] = key;				
        }
        return employees;
	}
	
	
	//Problem 1
	public static void displayEmployees(Employee[] employees, String dept) {
		for(Employee employee : employees) {
			if(employee.getEmpDept().equals(dept)) 
				System.out.println(employee.toString());
		}
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpDept() {
		return empDept;
	}

	public double getEmpBasicSalary() {
		return empBasicSalary;
	}

	public double getEmpGrossSalary() {
		return empGrossSalary;
	}
	
	@Override
	public String toString() {
		return "Emp Id: " + this.empId + "\nEmp Name: " + this.empName + "\nEmployee Department: " + this.empDept + "\nEmployee Basic Salary: " + this.empBasicSalary + "\nEmployee Gross Salary: " + this.empGrossSalary + "\n";
	}
	
}
