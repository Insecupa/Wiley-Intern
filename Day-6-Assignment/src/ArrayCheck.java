//Assignment 5
public class ArrayCheck {
	public static boolean checkArray(int[] objects) throws ArrayCheckException{
		if(objects.length <= 5)
			throw new ArrayCheckException();
		
		if(objects[0] != objects[objects.length - 1])
			return false;
		
		return true;
	}
}
