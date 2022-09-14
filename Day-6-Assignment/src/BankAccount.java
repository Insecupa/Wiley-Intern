//Assignment 7

/*
 * Create the BankAccount with the following details: 
Attributes: accountId, accountHolderName, AccountType
                      AccountType be enum contains the types SAVINGS and
CURRENT. The enum 
Should also provide the default interest rate for SAVINGS and 
CURRENT account. That should be returned from one of the 
methods from the enum 
Behaviour: BankAccount should have the method, calculateTotalInterest 
as shown below:
calculateTotalInterest(double amount, int years)
The main class should create object of BankAccount and provide the 
accounttype. It should  later invoke the calculateTotalInterest() by providing 
arguments. Print the total interest on  investments.
 */

public class BankAccount {
	private int accountId;
	private String accountHolderName;
	private AccountType accountType;
	static double totalInvestments;
	
	public BankAccount(int accountId, String accountHolderName, AccountType accountType) {
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	
	public double calculateTotalInterest(double amount, int years) throws DepositAmountException{
		if(amount < 0)
			throw new DepositAmountException();
		double ans = (amount) * (1 + (years) * this.accountType.getInterest());
		double intToPay = ans - amount;
		totalInvestments += intToPay;
		return intToPay;
	}
	
	
}
