//Assignment 8
public class DepositAmountException extends Exception{
	public DepositAmountException() {
		super("The amount entered is negative.");
	}
	
	public DepositAmountException(String s) {
		super(s);
	}
}
