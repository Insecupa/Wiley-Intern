package MiniProject;

import java.io.*;

public class Main1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
////        Customer c = new Customer("101", "Wiley", "101", 123);
////        Customer c1 = new Customer("102", "eiley", "101", 123);
////        Customer c2 = new Customer("103", "riley", "102", 102);
////        Customer c3 = new Customer("104", "tiley", "102", 99);
//
//        CustomerUtility cu = new CustomerUtility();
////        CustomerUtility.customerList.add(c);
////        CustomerUtility.customerList.add(c1);
////        CustomerUtility.customerList.add(c2);
////        CustomerUtility.customerList.add(c3);
//
//        cu.addCustomer();
//        cu.addCustomer();
//
//
//        cu.displayCustomer();
//        cu.displayCustomerWithAreaCode();
//        cu.displayDescendingOrder();
////
// cu.serialize();

        CustomerUtility pu = CustomerUtility.deserialize();
        pu.displayCustomer();
    }
}
