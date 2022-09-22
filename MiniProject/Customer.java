package MiniProject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Customer implements Serializable {

    private String customerId;
    private String customerName;
    private String customerAreaCode;
    private Integer numberOfUnitsConsumed;
    private Double totalBill;

    public Customer(String customerId, String customerName, String customerAreaCode, Integer numberOfUnitsConsumed) {
        setCustomerId(customerId);
        setCustomerName(customerName);
        setCustomerAreaCode(customerAreaCode);
        setNumberOfUnitsConsumed(numberOfUnitsConsumed);
        this.totalBill = calculateTotalBill();
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

    public Integer getNumberOfUnitsConsumed() {
        return numberOfUnitsConsumed;
    }

    private void setNumberOfUnitsConsumed(Integer numberOfUnitsConsumed) {
        this.numberOfUnitsConsumed = numberOfUnitsConsumed;
    }

    public Double getTotalBill() {
        return totalBill;
    }

//    private void setTotalBill(Double totalBill) {
//        this.totalBill = totalBill;
//    }

    private Double calculateTotalBill() {
        int units = this.numberOfUnitsConsumed;
        Double billToPay = 0.0;
        if(units < 100) {
            billToPay = units * 0.5;
        }else if(units < 151){
            billToPay = 100 * 0.5 + (units - 100) * 0.75;
        }else if(units > 150){
            billToPay = 100 * 0.5 + 50 * 0.75 + (units - 150) * 1;
        }

        return billToPay;
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

//    public void writeObject(ObjectOutputStream oos) throws IOException {
//        oos.defaultWriteObject();
//    }
//
//    public static void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        ois.defaultReadObject();
//    }
}
