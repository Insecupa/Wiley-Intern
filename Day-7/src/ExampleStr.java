
public class ExampleStr {

	public static void main(String[] args) {
		
		//Both have different memory locations
		String str1 = new String("Java");
		String str2 = str1.intern();
		System.out.println(str1);
		System.out.println(str1==str2);
		System.out.println(str1.hashCode() + " " + str2.hashCode());
		
		Runtime runTime = Runtime.getRuntime();
		
		//Sring builder String buffer
		
		//gc 
		
		//g1 collector
		//Serial GC
		//Parallel GC
		//Concurent map and sweep
		
		String greeting = "Hello";
		if(greeting.substring(0, 3).equals("Hel"));
		System.out.println("Yes");
		
		System.gc();
		
		String greeting1 = "Hello";
		if(greeting == greeting1)
			System.out.println("Yes");
			
	}
	
	public void finalize() {
		System.out.println("Objects released");
	}
}
