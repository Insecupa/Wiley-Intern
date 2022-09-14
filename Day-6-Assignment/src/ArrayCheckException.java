//Assignment 5
public class ArrayCheckException extends Exception{
	public ArrayCheckException() {
		super("The input array is not of required size: 5");
	}
	
	public ArrayCheckException(String s) {
		super(s);
	}
}
