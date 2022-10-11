package Day17;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnector.getConnection();
        CallableStatement callableStatement = con.prepareCall("{ call callCounById('AR') }");
        ResultSet rs = callableStatement.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
        }

        CallableStatement callableStatement1 = con.prepareCall("{ call getSalaryByManager(?, ?) }");
        callableStatement1.setInt(1, 114);
        callableStatement1.registerOutParameter(2, Types.INTEGER);
        callableStatement1.executeUpdate();
        int ans = callableStatement1.getInt(2);
        System.out.println("Manager: " + 114 + ", Salary: " + ans);

        ResultSetMetaData r = rs.getMetaData();
        String s = r.getCatalogName(1);
        System.out.println(s);
        String query = "SELECT * FROM employees";
        Statement st = con.createStatement();
        DatabaseMetaData db = con.getMetaData();
        ResultSet dbRs = db.getSchemas();
        while(dbRs.next()) {
            System.out.println(dbRs.getString(1));
        }

        con.close();
    }
}
