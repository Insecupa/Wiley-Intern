package MiniProjectChanged;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    final static Scanner sc = new Scanner(System.in);
    public static void addCustomer() {

    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomerUtility customerUtility = new CustomerUtility();
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
                    String customerId = null;
                    while (customerId == null) {
                        System.out.print("ID: ");
                        customerId = sc.next();
                        if (CustomerUtility.isValidId(customerId)) {
                            sc.nextLine();
                            break;
                        }
                        customerId = null;
                    }

                    String customerName = null;
                    while (customerName == null) {
                        System.out.print("Name: ");
                        customerName = sc.nextLine();
                        if (CustomerUtility.isValidName(customerName)) {
                            break;
                        } else {
//                try {
//                    throw new InvalidNameException("Name should contain only alphabets!");
//                } catch (InvalidNameException exception) {
//                    exception.printStackTrace();
//                }
                            System.out.println("Name should contain only alphabets!");
                        }
                        customerName = null;
                    }


                    String customerAreaCode = null;
                    while (customerAreaCode == null) {
                        System.out.print("Area Code: ");
                        customerAreaCode = sc.next();
                        if (CustomerUtility.isValidCode(customerAreaCode)) {
                            break;
                        }
                        System.out.println("Please enter positive numbers only!");
                        customerAreaCode = null;
                    }

                    Integer numberOfUnitsConsumed = null;
                    while (numberOfUnitsConsumed == null) {
                        try {
                            System.out.print("Units Consumed: ");
                            numberOfUnitsConsumed = sc.nextInt();
                            if (numberOfUnitsConsumed < 0)
                                throw new Exception();
                            break;
                        } catch (Exception exception) {
                            System.out.println("Number of Units should be Integer and positive!");
                        }
                        sc.nextLine();
                        numberOfUnitsConsumed = null;
                    }
                    customerUtility.addCustomer(customerId, customerName, customerAreaCode, numberOfUnitsConsumed);
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
