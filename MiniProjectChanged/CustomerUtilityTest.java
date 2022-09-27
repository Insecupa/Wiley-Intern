package MiniProjectChanged;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static org.junit.Assert.*;

public class CustomerUtilityTest {
    private static final double DELTA = 1e-15;
    @Test
    public void addCustomer() {
        CustomerUtility cu = new CustomerUtility();
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        cu.addCustomer(c);
        List<Customer> tempList = new ArrayList<>();
        tempList.add(c);
        Assert.assertEquals(1, cu.displayCustomers());

        cu.addCustomer("102", "John", "101", 100);

        Assert.assertEquals(2, cu.displayCustomers());
    }

    @Test
    public void displayCustomers() {
        CustomerUtility cu = new CustomerUtility();
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        cu.addCustomer(c);
        Assert.assertEquals(1, cu.displayCustomers());

        CustomerUtility cu1 = new CustomerUtility();
        Assert.assertEquals(0, cu1.displayCustomers());
    }

    @Test
    public void displayDescendingOrder() {
    }

    @Test
    public void displayCustomerWithAreaCode() {
//        CustomerUtility cu = new CustomerUtility();
//        Assert.assertEquals(false, cu.displayCustomerWithAreaCode("101"));
//
//        CustomerUtility cu1 = new CustomerUtility();
//        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
//        cu1.addCustomer(c);
//
//
//        assertEquals(true, cu1.displayCustomerWithAreaCode());
        CustomerUtility cu = new CustomerUtility();
        Assert.assertFalse(cu.displayCustomerWithAreaCode());

        CustomerUtility cu1 = new CustomerUtility();
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        cu1.addCustomer(c);

        String input = "101";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(true, cu1.displayCustomerWithAreaCode());
        //Assert.assertTrue(cu1.displayCustomerWithAreaCode());
//        Assert.assertTrue(cu1.displayCustomerWithAreaCode());
    }

    @Test
    public void createMapOnAreaCode() {
        CustomerUtility cu = new CustomerUtility();
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        cu.addCustomer(c);
        Map<String, List<Customer>> map = cu.createMapOnAreaCode();
        Map<String, List<Customer>> mp = new HashMap<>();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(c);
        mp.put("101",customerList);
        assertEquals(map, mp);
        CustomerUtility cu1 = new CustomerUtility();
        Map<String, List<Customer>> mp1 = new HashMap<>();
        assertEquals(mp1, cu1.createMapOnAreaCode());
    }

    @Test
    public void serDes() throws IOException, ClassNotFoundException {
        CustomerUtility cu = new CustomerUtility();
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        cu.addCustomer(c);
        cu.serialize();
        cu = null;
        cu = CustomerUtility.deserialize();
        Assert.assertEquals(1, cu.displayCustomers());
    }

    @Test
    public void isValidName() {
        assertTrue(CustomerUtility.isValidName("Mandar"));
        assertFalse(CustomerUtility.isValidName("123"));
    }

    @Test
    public void isValidID() {
        assertTrue(CustomerUtility.isValidId("1234"));
        assertTrue(CustomerUtility.isValidId("12AB"));
        assertFalse(CustomerUtility.isValidId("%^$"));

        CustomerUtility cu = new CustomerUtility();
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        cu.addCustomer(c);

        assertFalse(CustomerUtility.isValidId("101"));
    }

    @Test
    public void isValidAreaCode() {
        assertFalse(CustomerUtility.isValidCode("-120"));
        assertFalse(CustomerUtility.isValidCode("AB"));
        assertTrue(CustomerUtility.isValidCode("123"));
    }

    @Test
    public void getTotalBill() {
        CustomerUtility cu = new CustomerUtility();
        //assertEquals(49.5, cu.getTotalBill(100));

        double bill1 = 100 * 0.5 + 25 * 0.75;
        assertEquals(bill1, cu.getTotalBill(125), DELTA);

        double bill = 100 * 0.5 + 50 * 0.75 + 25;
        assertEquals( "Total bill Calculation faild",
                bill, cu.getTotalBill(175), DELTA);
        //assertNotEquals("Test Case failed", bill - 1, cu.getTotalBill(175), DELTA);
    }

//    @Test
}
