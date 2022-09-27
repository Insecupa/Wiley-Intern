package MiniProject;

public class InvalidCustomerAreaCodeException extends Exception {
    public InvalidCustomerAreaCodeException() {
        super("The area code is not in the current format");
    }
}
