//Assignment 7
public enum AccountType {
	SAVINGS(0.05), CURRENT(0.025);
	double interest;
	AccountType(double interest) {
		this.interest = interest;
	}
	
	public double getInterest() {
		return this.interest;
	}
	
}
