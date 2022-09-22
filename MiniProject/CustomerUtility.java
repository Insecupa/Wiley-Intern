package MiniProject;

import java.io.*;
import java.util.*;

public class CustomerUtility implements Serializable {
    private static List<Customer> customerList;

    public CustomerUtility(){
         customerList = new ArrayList<>();
    }

    public void addCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Area Code: ");
        String code = sc.nextLine();
        System.out.print("Enter Number of Units Consumed: ");
        int units = sc.nextInt();
        customerList.add(new Customer(id, name, code, units));
    }

    public void displayCustomer() {
        System.out.println("Customer List");
        customerList.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
    }

    public void displayDescendingOrder() {
        System.out.println("Customer in Descending Order");
        customerList.stream().sorted((o1, o2) -> (int) (o2.getTotalBill()- o1.getTotalBill())).forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
    }

    public void displayCustomerWithAreaCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Area Code to search: ");
        String areaCode = scanner.nextLine();
        System.out.println("Customer based on Area Code : " + areaCode);
        customerList.stream().filter(customer -> customer.getCustomerAreaCode().equals(areaCode)).forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
    }

    public Map<String, List<Customer>> createMapOnAreaCode() {
        Map<String, List<Customer>> map = new HashMap<>();
        for(Customer cu : customerList) {
            if(map.containsKey(cu.getCustomerAreaCode())){
                List<Customer> list = map.get(cu);
                list.add(cu);
            }else{
                List<Customer> tempList = Arrays.asList(cu);
                map.put(cu.getCustomerAreaCode(), tempList);
            }
        }
        return map;
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
