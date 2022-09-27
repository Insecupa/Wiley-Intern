package MiniProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomerUtility customerUtility = new CustomerUtility();
        Scanner sc = new Scanner(System.in);
        System.out.println("----------Welcome------------");

        while (true) {
            System.out.println("Press 1 to add new Customer");
            System.out.println("Press 2 to display all the customers with their bill, with all the other details.");
            System.out.println("Press 3 to display the customers sorted in the descending order of their bill.");
            System.out.println("Press 4 to display the details of the customers in the given customerAreaCode.");
            System.out.println("Press 5 to serialize the data.");
            System.out.println("Press 6 to deserialize the data.");
            System.out.println("Press 0 exit.");
            System.out.print("Enter your choice: ");
            String choice = sc.next();
            sc.nextLine();
            switch (choice) {
                case "0":
                    break;
                case "1":
                    customerUtility.addCustomer();
                    break;
                case "2":
                    customerUtility.displayCustomers();
                    break;
                case "3":
                    customerUtility.displayDescendingOrder();
                    break;
                case "4":
                    customerUtility.displayCustomerWithAreaCode();
                    break;
                case "5":
                    customerUtility.serialize();
                    break;
                case "6":
                    customerUtility = CustomerUtility.deserialize();
                    System.out.println("Deserialized.");
                    break;
                default:
                    System.out.println("Wrong Choice! Try between (0-6)");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
            if (choice.equals("0"))
                break;
        }
        System.out.println("Program Terminated");
    }
}
