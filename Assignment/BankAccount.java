/*
 * Create a class BankAccount with following details:
Attributes:  accountId, accountHolderName, openingBalance, 
currentBalance, 
                             totalBalance.
Methods:   depositAmount(double amount)
withdrawAmount(double amount)
getCurrentBalance()
displayTotalBalance()
Create atleast 3 bank accounts using parameterized constructor. Invoke 
the withdraAmount() and depositAmount() method randomly for different 
accounts. Display the details of the each account after transaction. Also 
show the current cash available in the bank. (Use the totalBalance to know
the current cash available in the bank)
IMP: Apply the validations for openingBalance and withDrawAmount
openingBalance should be positive number
You should not be able to withdraw the amount that the current 
balance.
 */
package Assignment;

public class BankAccount {
	private int accountId;
	private String accountHolderName;
	private double openingBalance;
	private double currentBalance;
	static double totalBalance;
	private double minBalance;

		
	private BankAccount(int accountId, String accountHolderName, double balance, AccountType accountType) {
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		
		//Assignment Question 2
		if(accountType == AccountType.SAVINGS) {
			this.minBalance = 500;
			this.openingBalance = this.currentBalance = balance;
		}else {
			this.minBalance = 1000;
			this.openingBalance = this.currentBalance = balance;
		}
		
		totalBalance += balance;
	}
	
	public void depositAmount(double amount) {		
		if(checkBank()) {
			return;
		}
		if(amount < 1) {
			System.out.println("Error amount not deposited");
			return;
		}
		this.currentBalance += amount;
		this.getDetails();
		System.out.println("Amount Deposited: " + amount);
		totalBalance += amount;
		System.out.println("The Amount has been credited.");
		System.out.println();
	}
	
	public void withdrawAmount(double amount) {	
		if(checkBank())
			return;
		else if(amount >= this.currentBalance || (this.currentBalance - amount) < this.minBalance ) {
			System.out.println( "Account Id: " + this.accountId + "; The amount tried to withdraw: " + amount + "; Error amount not withdrawn.");
			System.out.println();
			return;
		}else {
		this.currentBalance -= amount;
		this.getDetails();
		System.out.println("Amount Withdrawn: " + amount);
		totalBalance -= amount;
		System.out.println("The Amount has been debited");
		System.out.println();
		}
	}
	
	public double getCurrentBalance() {
		if(checkBank()) {
			return -1;
		}
		System.out.println("Current Balance in Account Id: " + this.accountId + " is : " + this.currentBalance);
		return this.currentBalance;
	}
	
	public static void displayTotalBalance() {
		
		System.out.println("Total Amount deposited till date: " + totalBalance);
		System.out.println();
	}
	
	public void getDetails() {
		System.out.println("Accoutn Id: " + this.accountId + "\nAccount Holder: " + this.accountHolderName + "\nCurrent Balance: " + this.currentBalance);
	}

	public boolean checkBank() {
		if(this.accountId == -1) {
			System.out.println("The account is not created please create a new account with valid details.");
			return true;
		}
		
		return false;
	}
	
	public static BankAccount accountCreator(int accountId, String accountHolderName, double balance, AccountType accountType) {
		if(balance < 0) {
			System.out.println("Cannot create a accont with 0 opening balance.");
			return new BankAccount(-1, "", -1, AccountType.SAVINGS);
		}
		else if(accountType == AccountType.CURRENT && balance < 1000) {
			System.out.println("Cannot create a current bank account. The required balance is 1000");
			return new BankAccount(-1, "", -1, AccountType.SAVINGS);
		}
		
		else if(accountType == AccountType.SAVINGS && balance < 500) {
			System.out.println("Cannot create a savings bank account. The required balance is 500.");
			return new BankAccount(-1, "", -1, AccountType.SAVINGS);
		}
		
		return new BankAccount(accountId, accountHolderName, balance, accountType);
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setBalance(double openingBalance) {
		if(this.openingBalance == -1) {
			this.openingBalance = this.currentBalance = openingBalance;
			totalBalance += openingBalance;
		}
		else {
			System.out.println("Please deposit amount to change the balance.");
			return;
		}
	}

	public double getMinBalance() {
		return minBalance;
	}

	
}
