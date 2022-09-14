//Assignment - 2
public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = "mandarmjog@gmail.com";
		try {
			Email.validateEmail(email);
		}catch(EmailException ex) {
			System.out.println(ex.getMessage());	
		}
		
		email = "wiley@g@.com";
		try {
			Email.validateEmail(email);
		}catch(EmailException ex) {
			System.out.println(ex.getMessage());	
		}
	}

}
