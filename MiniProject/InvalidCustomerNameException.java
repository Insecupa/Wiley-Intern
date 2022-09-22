package MiniProject;

public class InvalidCustomerNameException extends Exception {
    public InvalidCustomerNameException(){
        super("The entered name is not in the current format.");
    }
}
