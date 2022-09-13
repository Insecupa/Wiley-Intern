
public class ExceptionApp {
	
	public static void calculate(int i) throws MyException{
		if(i == 10)
			throw new MyException();
		else
			System.out.println(i);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing my Exception --> ");
		try {
			if("Hello".equals("Hello")) 
				throw new MyException();
		}catch(MyException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.toString());
		}
		
		try {
			calculate(10);
		}catch (MyException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

	}

}
