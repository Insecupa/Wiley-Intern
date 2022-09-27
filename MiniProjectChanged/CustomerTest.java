package MiniProjectChanged;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void getCustomerId() {
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        assertEquals("101", c.getCustomerId());
        Customer c1 = new Customer("102", "Wiley", "101", 100, 50.0);
        assertEquals("102", c1.getCustomerId());
    }

    @Test
    public void getCustomerName() {
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        assertEquals("Wiley", c.getCustomerName());
    }

    @Test
    public void getCustomerAreaCode() {
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        assertEquals("101", c.getCustomerAreaCode());
    }

    @Test
    public void getNumberOfUnitsConsumed() {
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        assertEquals(100, c.getNumberOfUnitsConsumed());
    }

    @Test
    public void getTotalBill() {
        Customer c = new Customer("101", "Wiley", "101", 100, 50.0);
        assertEquals((Double) 50.0, c.getTotalBill());
    }
}