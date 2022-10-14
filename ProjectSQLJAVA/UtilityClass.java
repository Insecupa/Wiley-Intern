package ProjectSQLJAVA;

import java.sql.*;

public class UtilityClass {
    private enum Admin {
        USER_NAME("DevBirds"), PASSWORD("DevBirds123");
        String data;
        Admin(String data) {
            this.data = data;
        }
    }
    static private Boolean IS_ADMIN = false;
    Connection con;

    public UtilityClass() throws SQLException, ClassNotFoundException {
        con = DatabaseConnector.getConnection();
    }

    //Error Codes
    /*
        -101 - Not an Admin
        -1 : Unable to complete the methods
        1 : Successfully Done
        -1000 : No customer found
        -200 : No month is found
     */

    public int addCustomer(String customerName, String typeOfCustomer, int areaCode) throws SQLException {
        if(!IS_ADMIN) {
            System.out.println("You should have admin privileges to add a Customer");
            return -101;
        }
        String query = "INSERT INTO Customer(customerName, typeOfCustomer, areaCode) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, customerName);
        ps.setString(2, typeOfCustomer);
        ps.setInt(3, areaCode);
        int rows = ps.executeUpdate();
        if(rows > 0)
            return 1;
        return -1;
    }

    private int checkCustomers(int customerId) throws SQLException {
        String query = "SELECT customerId from Customer where customerId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();
        if(!rs.isBeforeFirst())
            return -1;
        return 1;
    }

    private int checkMonth(int customerId, Months month) throws SQLException {
        String query = "SELECT * FROM bill WHERE mon = ? AND customerId = ?";
        String m = String.valueOf(month);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, m);
        ps.setInt(2, customerId);
        ResultSet rs = ps.executeQuery();
        if(!rs.isBeforeFirst())
            return 1;

        return -1;
    }

    public int addBill(int customerId, Months month, int unitsConsumed) throws SQLException {
        if(!IS_ADMIN) {
            System.out.println("You should have admin privileges to add a bill");
            return -101;
        }
        if (checkCustomers(customerId) == -1){
            System.out.println("No customer with customer Id: " + customerId);
            return -1000;
        }

        if(checkMonth(customerId, month) == -1) {
            System.out.println("Bill is already present for the customer Id : " + customerId + " for the month : " +month);
            return -200;
        }

        double totalBill = calculateBill(unitsConsumed);
        String query = "INSERT INTO BILL(customerId, mon, numberOfUnits, totalBill) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, customerId);
        ps.setString(2, String.valueOf(month));
        ps.setInt(3, unitsConsumed);
        ps.setDouble(4, totalBill);
        int rows = ps.executeUpdate();
        if(rows > 0)
            return 1;
        return -1;
    }

    private double calculateBill(int numberOfUnitsConsumed) {
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

    public int printAllCustomers() throws SQLException {
        CallableStatement cs = con.prepareCall("{ call getAllCustomers() }");
        ResultSet rs = cs.executeQuery();
        if(!rs.isBeforeFirst()) {
            System.out.println("There are no customers in the list.");
            return -1;
        }

        System.out.format("%-15s %-15s %-15s %s\n","Customer Id", "Customer Name", "Type Of Customer" , "Area Code");
        System.out.println("==========================================================");
        while(rs.next()) {
            System.out.format("%-15s %-15s %-15s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3 ), rs.getString(4));
        }
        return 1;
    }

    public int billsAllForMonth(Months month) throws SQLException {
        CallableStatement cs = con.prepareCall("{ call getDetailsByMonth(?) }");
        cs.setString(1, String.valueOf(month));
        ResultSet rs = cs.executeQuery();
        if(!rs.isBeforeFirst()) {
            System.out.println("There are no customers to display.");
            return -1;
        }

        //b.billId, c.customerId, c.customerName, b.numberOfUnits, b.totalBill
        System.out.println("The Bills generated for the month: " + month);
        System.out.format("%-15s %-15s %-15s %-15s %s\n","Bill Id", "Customer ID", "Customer Name", "No Of Units" , "Total Bill");
        System.out.println("==========================================================");
        while(rs.next()) {
            System.out.format("%-15s %-15s %-15s %-15s %s\n",rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4) , rs.getDouble(5));
        }
        return 1;
    }

    public int billForCustomerAndMonth(int customerId, Months month) throws SQLException {
        CallableStatement cs = con.prepareCall("{ call getBillForCustomerMonth(?, ?) }");
        cs.setInt(1, customerId);
        cs.setString(2, String.valueOf(month));

        ResultSet rs = cs.executeQuery();
        if(!rs.isBeforeFirst()) {
            System.out.println("There are no customers to display.");
            return -1;
        }

        System.out.println("The Bills generated for the month: " + month);
        System.out.format("%-15s %-15s %-15s %-15s %s\n","Bill Id", "Customer ID", "Customer Name", "No Of Units" , "Total Bill");
        System.out.println("==========================================================");
        while(rs.next()) {
            System.out.format("%-15s %-15s %-15s %-15s %s\n",rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4) , rs.getDouble(5));
        }
        return 1;
    }

    public double getTotalByMonth(Months month) throws SQLException {
        CallableStatement cs = con.prepareCall("{ call totalBillForMonth(?, ?) }");
        cs.setString(1, String.valueOf(month));
        cs.registerOutParameter(2, Types.DECIMAL);
        cs.execute();
        Double total = cs.getDouble(2);
        System.out.println("The total amount generated for the month of " + month + " is : " + total);
        return total;
    }

    public int displayCustomerForAMonthDesc(Months month) throws SQLException {
        CallableStatement cs = con.prepareCall("{ call printByMonthDesc(?) }");
        cs.setString(1, String.valueOf(month));

        ResultSet rs = cs.executeQuery();
        if(!rs.isBeforeFirst()) {
            System.out.println("There are no customers to display.");
            return -1;
        }

        System.out.println("The Bills generated for the month: " + month);
        System.out.format("%-15s %-15s %-15s %-15s %s\n","Bill Id", "Customer ID", "Customer Name", "No Of Units" , "Total Bill");
        System.out.println("==========================================================");
        while(rs.next()) {
            System.out.format("%-15s %-15s %-15s %-15s %s\n",rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4) , rs.getDouble(5));
        }
        return 1;
    }

    public int printCustomerBasedOnAreaCode(int areaCode) throws SQLException {
        String query = "SELECT * FROM Customer where Customer.areaCode = ?";
        PreparedStatement cs = con.prepareStatement(query);
//        CallableStatement cs = con.prepareCall("{ customerBasedOnAreaCode(?) }");
        cs.setString(1, String.valueOf(areaCode));
        ResultSet rs = cs.executeQuery();
        if(!rs.isBeforeFirst()) {
            System.out.println("There are no customers in the list.");
            return -1;
        }

        System.out.println("The customers in the area with the area code: " + areaCode);
        System.out.format("%-15s %-15s %s\n","Customer Id", "Customer Name", "Type Of Customer");
        System.out.println("==========================================================");
        while(rs.next()) {
            System.out.format("%-15s %-15s %s\n", rs.getInt(1), rs.getString(2), rs.getString(3 ));
        }
        return 1;
    }

    public int changeName(int customerId, String newName) throws SQLException {
        if(!IS_ADMIN) {
            System.out.println("You should have admin privileges to edit a Customer");
            return -101;
        }

        if(checkCustomers(customerId) == -1) {
            System.out.println("No customer with customer Id: " + customerId);
            return -1000;
        }

        String query = "UPDATE Customer SET customerName = ? where customerId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newName);
        ps.setInt(2, customerId);
        int rows = ps.executeUpdate();
        if(rows > 0) {
            System.out.println("Updated Customer Details. ");
            return 1;
        }
        return -1;
    }

    public int changeAreaCode(int customerId, int areaCode) throws SQLException {
        if(!IS_ADMIN) {
            System.out.println("You should have admin privileges to edit a Customer");
            return -101;
        }
        if(checkCustomers(customerId) == -1)
            System.out.println("There is no customer with id " + customerId);

        String query = "UPDATE Customer SET areaCode = ? where customerId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, areaCode);
        ps.setInt(2, customerId);
        if(ps.executeUpdate() > 0) {
            System.out.println("Changed the details of the user.");
            return 1;
        }
        return -1;
    }
    public int deleteCustomer(int customerId) throws SQLException {
        if(!IS_ADMIN) {
            System.out.println("You should have admin privileges to delete a Customer");
            return -101;
        }

        String query = "DELETE FROM Customer where customerId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, customerId);
        int rows = ps.executeUpdate();
        if(rows > 0) {
            System.out.println("Successfully deleted the customer");
            return 1;
        }

        return -1;
    }

    public void logout() {
        if(IS_ADMIN)
            System.out.println("Logged out as an admin");
        IS_ADMIN = false;
    }

    public boolean setAdmin(String userName, String password) {
        if(userName.equals(String.valueOf(Admin.USER_NAME.data)) && password.equals(String.valueOf(Admin.PASSWORD.data))) {
            IS_ADMIN = true;
            return true;
        }
        return false;
    }

    public boolean isAdmin() {
        return IS_ADMIN;
    }

    @Override
    protected void finalize() throws Throwable {
        con.close();
        super.finalize();
    }
}
