//Assignment 9

/*
 * Create the Employee class, which should contain the attributes empId, 
empName. Along with that, it should also contain empAddresses, which is 
array of address. This should consist of temporary address and permanent
address. 
Write a program to instantiate the employee object and display all the 
attributes of the same.

 */

public class Employee {
	private int empId;
	private String empName;
	private Address[] empAddresses;
	
	public Employee(int empId, String empName, Address permanentAddress, Address temporaryAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAddresses = new Address[2];
		this.empAddresses[0] = permanentAddress;
		this.empAddresses[1] = temporaryAddress;
	}
	
	public void display() {
		System.out.println("Employee Id: " + this.empId + "\nEmployee Name: "
				+ this.empName + "\nPermanent Address:\n" + this.empAddresses[0].toString()
				+ "\nTemporary Address:\n" + this.empAddresses[1].toString()
				);
	}
}
