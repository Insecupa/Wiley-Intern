//Assignment 7, 8
public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc1 = new BankAccount(101, "John Doe", AccountType.SAVINGS);
		try {
			System.out.println(acc1.calculateTotalInterest(1000, 2));
		} catch (DepositAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(acc1.calculateTotalInterest(-1, 2));
		} catch (DepositAmountException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
