import java.util.StringTokenizer;

public class Mutable {
	public static void main(String[] args) {
		String s = "Hello world";
		StringBuffer sb = new StringBuffer(s);
		
		System.out.println(sb.toString());
		
		String email = "wileyedge@gmail.com";
		StringTokenizer st = new StringTokenizer(email, "@");
		while(st.hasMoreElements()) {
			System.out.println(st.nextElement());
		}
	}
}
