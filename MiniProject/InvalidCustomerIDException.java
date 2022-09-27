package MiniProject;

public class InvalidCustomerIDException extends Exception{
    public InvalidCustomerIDException(){
        super("Customer ID is not in the format ...");
    }
}
