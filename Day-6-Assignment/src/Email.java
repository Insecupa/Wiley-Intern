//Assignment - 2
public class Email {
	public static void validateEmail(String s) throws EmailException{
		String[] str = s.split("@");
		if(str.length != 2) {
			throw new EmailException();
		}
		System.out.println("Your email address is valid.");
	}
}
