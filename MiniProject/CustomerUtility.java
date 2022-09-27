package MiniProject;

import java.io.*;
import java.util.*;

public class CustomerUtility implements Serializable {
    public static List<Customer> customerList;
    private static Scanner sc;

    public CustomerUtility(){
         customerList = new ArrayList<>();
         sc = new Scanner(System.in);
    }

    public void addCustomer() {
        String customerId = null;
        while (customerId == null) {
            System.out.print("ID: ");
            customerId = sc.next();
            if (isValidId(customerId)) {
                sc.nextLine();
                break;
            }
            customerId = null;
        }

        String customerName = null;
        while (customerName == null) {
            System.out.print("Name: ");
            customerName = sc.nextLine();
            if (isValidName(customerName)) {
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
            if (isValidCode(customerAreaCode)) {
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

        Double totalBill = getTotalBill(numberOfUnitsConsumed);
        Customer newCustomer = new Customer(customerId, customerName, customerAreaCode, numberOfUnitsConsumed,  totalBill);
        customerList.add(newCustomer);
        System.out.println("Customer Added Successfully.");
    }

    public void displayCustomers() {
        if(customerList.size() == 0) {
            System.out.println("No customers to display.");
            return;
        }
        System.out.println("Customer List");
        customerList.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
    }

    public void displayDescendingOrder() {
        if(customerList.size() == 0) {
            System.out.println("No customers to display.");
            return;
        }else {
            System.out.println("Customer in Descending Order");

            customerList.stream().sorted((o1, o2) -> (int) (o2.getTotalBill() - o1.getTotalBill())).forEach(System.out::println);
            System.out.println("----------------------------------------------------------");
        }
    }

    public void displayCustomerWithAreaCode(){
        if(customerList.size() == 0) {
            System.out.println("No customers to display.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Area Code to search: ");
        String areaCode = null;
        while (areaCode == null) {
            System.out.print("Area Code: ");
            areaCode = sc.next();
            if (isValidCode(areaCode)) {
                break;
            }
            areaCode = null;
        }

        final String tempCode = areaCode;
        System.out.println("Customer based on Area Code : " + areaCode);
        long count = customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(tempCode)).count();
        if(count == 0){
            System.out.println("No customer in the area code: " + tempCode);
        }else{
            customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(tempCode)).forEach(System.out::println);
            System.out.println("----------------------------------------------------------");
        }
    }

    public Map<String, List<Customer>> createMapOnAreaCode() {
        Map<String, List<Customer>> map = new HashMap<>();
        if (customerList.size() == 0){
            System.out.println("No customers to create map.");
        }else {
            for (Customer cu : customerList) {
                if (map.containsKey(cu.getCustomerAreaCode())) {
                    List<Customer> list = map.get(cu);
                    list.add(cu);
                } else {
                    List<Customer> tempList = Arrays.asList(cu);
                    map.put(cu.getCustomerAreaCode(), tempList);
                }
            }
        }
        return map;
    }

    private double getTotalBill(int numberOfUnitsConsumed) {
        double bill = 0;
        if (numberOfUnitsConsumed <= 100) {
            bill = numberOfUnitsConsumed * 0.5;
        } else if (numberOfUnitsConsumed <= 150) {
            bill = 100 * 0.5 + (numberOfUnitsConsumed - 100) * 0.75;
        } else {
            bill = 100 * 0.5 + 50 * 0.75 + (numberOfUnitsConsumed - 150);
        }
        return bill;
    }


    private static boolean isValidName(String name) {
        String expression = "^[a-zA-Z\\s]+";
        return name.matches(expression);
    }


    private static boolean isValidId(String customerID) {
        for (char e : customerID.toCharArray()) {
            if (!Character.isLetter(e) && !Character.isDigit(e)) {
                System.out.println("Please enter Letters and Numbers only!");
                return false;
            }
        }
        for (Customer customer : customerList) {
            if (customer.getCustomerId().equalsIgnoreCase(customerID)) {
                System.out.println("Customer with this ID already present!");
                return false;
            }
        }
        return true;
    }

    private static boolean isValidCode(String customerAreaCode) {
        for (char e : customerAreaCode.toCharArray()) {
            if (!Character.isDigit(e))
                return false;
        }
        if (Integer.parseInt(customerAreaCode) < 0)
            return false;
        return true;
    }

    public void serialize() throws IOException {
        FileOutputStream fos = new FileOutputStream("elec.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.writeObject(customerList);
        System.out.println("Object Serialized");
        oos.close();
        fos.close();
    }

    public static CustomerUtility deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("elec.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        CustomerUtility cu = (CustomerUtility) ois.readObject();
        List<Customer> list = (List<Customer>) ois.readObject();
        cu.customerList = list;
        ois.close();
        fis.close();
        return cu;
    }
}
