//Assignment - 2
public class EmailException extends Exception{
	public EmailException() {
		super("Your email address is Invalid.");
	}
	public EmailException(String s) {
		super(s);
	}
}
