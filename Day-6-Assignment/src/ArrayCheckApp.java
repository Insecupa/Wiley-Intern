//Assignment 5
public class ArrayCheckApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4,5,1};
		try {
			System.out.println(ArrayCheck.checkArray(arr));
		} catch (ArrayCheckException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
