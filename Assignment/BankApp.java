package Assignment;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountType savingsAccount = AccountType.SAVINGS;
		AccountType currentAccount = AccountType.CURRENT;
		
		BankAccount bankAccount1 = BankAccount.accountCreator(101, "John Doe", 430, savingsAccount);
		bankAccount1.depositAmount(100.0);
		BankAccount bankAccount2 = BankAccount.accountCreator(102, "Won Goe", 750.23, savingsAccount);
		BankAccount bankAccount3 = BankAccount.accountCreator(103, "Pan Joe", 1540.23, currentAccount);
		
		bankAccount1.setAccountId(101);
		
		bankAccount1.setBalance(1540.23);
		bankAccount1.depositAmount(2403.67);
		bankAccount1.withdrawAmount(3500.00);
		
		bankAccount2.withdrawAmount(25.86);
		
		bankAccount3.depositAmount(234.40);
		
		bankAccount1.withdrawAmount(12.3);
		
		bankAccount2.depositAmount(122);
		
		bankAccount3.withdrawAmount(343.23);
		
		BankAccount.displayTotalBalance();
	}

}
