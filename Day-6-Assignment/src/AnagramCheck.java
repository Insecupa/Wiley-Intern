import java.util.Arrays;

//Assignment 6
public class AnagramCheck {
	public static String anagramCheck(String str, String aStr) {
		if(str.length() != aStr.length())
			return "Not an anagram";
		
		char[] strArr = str.toCharArray();
		char[] aStrArr = str.toCharArray();
		

		Arrays.sort(strArr);
		Arrays.sort(aStrArr);
		
		if(strArr.equals(aStrArr))
			return "They are an anagram";
		return "Not an anagram";
	}
}
