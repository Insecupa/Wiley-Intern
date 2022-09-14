//Write a program to reverse a String - Assignment - 1
public class ReverseString {
	public static String reverse(String string) {
		StringBuilder sb = new StringBuilder(string);
		sb = sb.reverse();
		return sb.toString();
	}
}
