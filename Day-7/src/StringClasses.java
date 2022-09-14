import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class StringClasses {
	public static void main(String[] args) throws IOException {
		String strLit = "Ans"; //This is stored in String Pool;
		String strObj = new String("Ans"); //This is stored in Heap;
		
		//Objects are costly
		//javap
		
		
		//Reading using a buffered Reader
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(in);
//		String str = br.readLine();
//		
//		System.out.println(str);
//		
//		//Reading using a scanner
//		Scanner scanner = new Scanner(System.in);
//		String str2 = scanner.nextLine();
//		
//		System.out.println(str2);
//		
//		System.out.println(str == str2);
		
		//Testing out the compares to
		String dog = "Dog";
		String Wolf = "Wolf";
		
		
		//compareTo only checks the first character
		System.out.println(dog.compareTo(Wolf));
		System.out.println(dog.endsWith("g"));
		
		System.out.println(dog.indexOf("og"));
		
		System.out.println(dog.replaceFirst("d", "pa"));
		
		//Not replacing d
		String paog = dog.replace("do", "pa");
		System.out.println(paog);
		
		String date = "22-12-22";
		String[] dateSplit = date.split("-");
		for(String dateS : dateSplit) {
			System.out.print(dateS + " ");
		}
		
		System.out.println();
		
		String str4 = "    Hello this is the world.   ";
		
		String str5 = str4.trim();
		System.out.println(str4);
		System.out.println(str5);
	}
}
