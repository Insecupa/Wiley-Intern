
public class MyException extends Exception{
	String message;
	public MyException() {
		message = "user Exp Class";
	}
	
	@Override 
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return "This is a user created exp";
	}
	
}
