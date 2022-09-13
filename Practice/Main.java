import java.io.File;
import java.io.IOException;

/*
 * Exception Handling
 */

/*
 * Exception - Program Breaker, can stop program abruptly
 */

/*
 * try catch finally, throw, throws;
 * One example for each
 */

//Object - (Exception Super Class) Throwable - Exception - Error


//Execption -> RunTimeException, IOException

//Exception handling != fixing
//Makes sure program works without stopping
//Types = Checked, Unchecked
//Checked = checked at compilation, forced to handle
//Unchecked = checked at runtime, writing exp block is optional
//
public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File f = new File("Helo.txt");
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
			
		}
		//You cannot include super class in exception like below: 
		
		
	}

}
