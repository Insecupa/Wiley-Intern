package MiniProjectChanged;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerUtility implements Serializable {
    private static List<Customer> customerList;
    private static Scanner sc;

    public CustomerUtility(){
         customerList = new ArrayList<>();
         sc = new Scanner(System.in);
    }

    public void addCustomer(Customer c) {
        customerList.add(c);
    }
    public void addCustomer(String customerId, String customerName, String customerAreaCode, int numberOfUnitsConsumed) {
        Double totalBill = getTotalBill(numberOfUnitsConsumed);
        Customer newCustomer = new Customer(customerId, customerName, customerAreaCode, numberOfUnitsConsumed,  totalBill);
        customerList.add(newCustomer);
        System.out.println("Customer Added Successfully.");
    }

    public int displayCustomers() {
        if(customerList.size() == 0) {
            System.out.println("No customers to display.");
            return 0;
        }
        System.out.println("Customer List");
        customerList.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
        return customerList.size();
    }

    public List<Customer> displayDescendingOrder() {
        if(customerList.size() == 0) {
            System.out.println("No customers to display.");
            return null;
        }else {
            System.out.println("Customer in Descending Order");
            List<Customer> sortedList =
                    customerList.stream().sorted((o1, o2) -> (int) (o2.getTotalBill() - o1.getTotalBill())).collect(Collectors.toList());
            customerList.stream().sorted((o1, o2) -> (int) (o2.getTotalBill() - o1.getTotalBill())).forEach(System.out::println);
            System.out.println("----------------------------------------------------------");
            return sortedList;
        }
    }

    public Boolean displayCustomerWithAreaCode(){
//        if(customerList.size() == 0) {
//            System.out.println("No customers to display.");
//            return false;
//        }
//        System.out.println("Customer based on Area Code : " + tempCode);
//        long count = customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(tempCode)).count();
//        if(count == 0){
//            System.out.println("No customer in the area code: " + tempCode);
//        }else{
//            customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(tempCode)).forEach(System.out::println);
//            System.out.println("----------------------------------------------------------");
//            return true;
//        }
//            return false;
        if(customerList.size() == 0) {
            System.out.println("No customers to display.");
            return false;
        }
        Scanner sc = new Scanner(System.in) ;
        System.out.print("Enter the Area Code to search: ");

        String areaCode = sc.nextLine();
        System.out.println("Customer based on Area Code : " + areaCode);
        long count = customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(areaCode)).count();
        if(count == 0){
            System.out.println("No customer in the area code: " + areaCode);
        }else{
            customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(areaCode)).forEach(System.out::println);
            System.out.println("----------------------------------------------------------");
            return true;
        }

        return false;
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

    public double getTotalBill(int numberOfUnitsConsumed) {
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


    public static boolean isValidName(String name) {
        String expression = "^[a-zA-Z\\s]+";
        return name.matches(expression);
    }


    public static boolean isValidId(String customerID) {
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

    public static boolean isValidCode(String customerAreaCode) {
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
