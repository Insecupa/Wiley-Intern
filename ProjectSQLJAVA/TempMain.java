package ProjectSQLJAVA;

import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.Scanner;

public class TempMain {
    static UtilityClass u;
    static Scanner scanner = new Scanner(System.in);
    static {
        try {
            u = new UtilityClass();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Months mon;
        System.out.println("Welcome to DevBirds Electricity Board.");
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.flush();
        System.out.print(
                "1.Print All Customers\n" +
                        "2.Get Bills For A Particular Month\n" +
                        "3.Print Bills For a Customer for a Month\n" +
                        "4.Get Total Bills Acquired For a Month\n" +
                        "5.Display Customer For a Month in Descending Order\n" +
                        "6.Print Customers Based on a Area Code\n" +
                        "7.Login as a Admin\n" +
                        "8.Exit\n"
        );


        int choice = Integer.parseInt(scanner.nextLine());
        while(choice >= 1 && choice <= 8) {
            switch (choice) {
                case 1:
                    u.printAllCustomers();
                    break;
                case 2:
                    System.out.println("Enter a month to get Bills: *Enter in 3 chars*");
                    mon = Months.valueOf(scanner.nextLine().toUpperCase());
                    u.billsAllForMonth(mon);
                    break;
                case 3:
                    System.out.println("Enter the Customer Id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter a month to get Bill *Enter in 3 chars*");
                    mon = Months.valueOf(scanner.nextLine().toUpperCase());
                    u.billForCustomerAndMonth(id, mon);
                    break;
                case 4:
                    //4.Get Total Bills Acquired For a Month
                    System.out.println("Enter the month to get the total bills: *Enter in 3 chars*");
                    mon = Months.valueOf(scanner.nextLine().toUpperCase());
                    u.getTotalByMonth(mon);
                    break;
                case 5:
                    //5.Display Customer For a Month in Descending Order
                    System.out.println("Enter the month name *Enter in 3 chars*");
                    mon = Months.valueOf(scanner.nextLine().toUpperCase());
                    u.displayCustomerForAMonthDesc(mon);
                    break;
                case 6:
                    //Print Customers Based on a Area Code
                    System.out.println("Enter the area code");
                    int areaCode = Integer.parseInt(scanner.nextLine());
                    u.printCustomerBasedOnAreaCode(areaCode);
                    break;
                case 7:
                    System.out.println("Enter the admin user name: ");
                    String userName = scanner.nextLine();
                    System.out.println("Enter the admin password: ");
                    String pass = scanner.nextLine();
                    if(u.setAdmin(userName, pass)) {
                        adminPanel();
                    } else {
                        System.out.println("Wrong user name or password");
                    }
                    break;
                default:
                    System.out.println("Thank you.");
                    System.exit(0);
            }
            System.out.println("-------------------------------------------");
            System.out.print(
                    "1.Print All Customers\n" +
                            "2.Get Bills For A Particular Month\n" +
                            "3.Print Bills For a Customer for a Month\n" +
                            "4.Get Total Bills Acquired For a Month\n" +
                            "5.Display Customer For a Month in Descending Order\n" +
                            "6.Print Customers Based on a Area Code\n" +
                        "7.Login as a Admin\n" +
                        "8.Exit\n"
            );

            choice = Integer.parseInt(scanner.nextLine());
        }

        scanner.close();
    }

    public static void adminPanel() throws SQLException {
        Months mon;
        int adminChoice;
        System.out.println("------------------------------------");
        System.out.println(
                "1.Add a Customer\n" +
                        "2.Add a Bill\n" +
                        "3.Change Customer Name\n" +
                        "4.Change Customer Area Code\n" +
                        "5.Delete a Customer\n" +
                        "6.Logout as a Admin\n" +
                        "7.Exit\n"
        );
        adminChoice = Integer.parseInt(scanner.nextLine());
        while(adminChoice >= 1 && adminChoice <= 7) {
            switch (adminChoice) {
                case 1:
                    System.out.println("Enter the customer name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the type of customer: ");
                    String type = scanner.nextLine();
                    System.out.println("Enter the area code: ");
                    int araCode = Integer.parseInt(scanner.nextLine());
                    if(u.addCustomer(name, type, araCode) == 1)
                        System.out.println("Added a customer");
                    else
                        System.out.println("Havent added a customer");
                    break;
                case 2:
                    System.out.println("Enter the customer Id: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the month *Enter 3 chars*");
                    mon = Months.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println("Enter the units consumed: ");
                    int units = Integer.parseInt(scanner.nextLine());
                    u.addBill(id, mon, units);
                    break;
                case 3:
                    System.out.println("Enter the customer id: ");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the name to be changed to: ");
                    String name1 = scanner.nextLine();
                    if(u.changeName(id1, name1) == -1)
                        System.out.println("Didn't change customer details");
                    break;
                case 4:
                    System.out.println("Enter the customer id: ");
                    int cu1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the area code to be changed to: ");
                    int a1 = Integer.parseInt(scanner.nextLine());
                    if(u.changeAreaCode(cu1, a1) == -1) {
                        System.out.println("Did not change the area code");
                    }
                    break;
                case 5:
                    System.out.println("Enter the customer id to be deleted: ");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    if(u.deleteCustomer(id2) == -1)
                        System.out.println("Could not delete the customer.");
                    break;
                case 6:
                    u.logout();
                    return;
                case 7:
                    System.exit(0);
            }

            System.out.println(
                    "1.Add a Customer\n" +
                            "2.Add a Bill\n" +
                            "3.Change Customer Name\n" +
                            "4.Change Customer Area Code\n" +
                            "5.Delete a Customer\n" +
                            "6.Logout as a Admin\n" +
                            "7.Exit\n"
            );
            adminChoice = Integer.parseInt(scanner.nextLine());
        }
    }
}
