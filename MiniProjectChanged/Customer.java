package MiniProjectChanged;

import java.io.Serializable;


public class Customer implements Serializable {

    private String customerId;
    private String customerName;
    private String customerAreaCode;
    private Integer numberOfUnitsConsumed;
    private Double totalBill;

    public Customer(String customerId, String customerName, String customerAreaCode, Integer numberOfUnitsConsumed, Double totalBill) {
        setCustomerId(customerId);
        setCustomerName(customerName);
        setCustomerAreaCode(customerAreaCode);
        setNumberOfUnitsConsumed(numberOfUnitsConsumed);
        setTotalBill(totalBill);
    }

    public String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {

        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }


    private void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAreaCode() {
        return customerAreaCode;
    }

    private void setCustomerAreaCode(String customerAreaCode) {
        this.customerAreaCode = customerAreaCode;
    }

    public int getNumberOfUnitsConsumed() {
        return numberOfUnitsConsumed;
    }

    private void setNumberOfUnitsConsumed(Integer numberOfUnitsConsumed) {
        this.numberOfUnitsConsumed = numberOfUnitsConsumed;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAreaCode='" + customerAreaCode + '\'' +
                ", noOfUnitsConsumed=" + numberOfUnitsConsumed +
                ", totalBill=" + totalBill +
                '}';
    }

}
