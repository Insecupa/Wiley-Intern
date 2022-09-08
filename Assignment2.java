/* Create a program to print Fibonacci series in the given range using the 
object oriented programming concept. */

class Fibonacci {
	int limit;

	
	public Fibonacci() {
		limit = 1;
	}
	
	public Fibonacci(int limit) {
		this.limit = limit;
	}
	
	public void printSeries() {
		int n1 = 0;
		int n2 = 1;
		int n3;
		if(limit == 1)
			System.out.println(n1);
		else {
			System.out.print(n1 + " " + n2);				
			limit = limit - 2;
			while(limit-- > 0) {
				n3 = n1 + n2;
				n1 = n2;
				n2 = n3;
				System.out.print(" " + n3);
			}
		}
		
	}
}

public class Assignment2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fibonacci1 = new Fibonacci();
		Fibonacci fibonacci2 = new Fibonacci(10);
		
		fibonacci1.printSeries();
		fibonacci2.printSeries();
	}

}
