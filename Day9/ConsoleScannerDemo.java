package Day9;

import java.io.Console;
import java.util.Scanner;

//Console
//Scanner
public class ConsoleScannerDemo {
    public static void main(String[] args) {
//        Console console = System.console();
//        System.out.println("Enter your name");
//        String user = console.readLine();
//        System.out.println(user);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = scanner.next();

        System.out.println(str + " " + str2);

    }
}
