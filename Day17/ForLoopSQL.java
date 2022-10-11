package Day17;

import java.sql.*;

public class ForLoopSQL {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnector.getConnection();
        String query1 = "SELECT * FROM employees";
        Statement rowCountStatement = con.createStatement();
        ResultSet rs1 = rowCountStatement.executeQuery(query1);
        String callQuery = "call setStatus(?, ?)";
        String prepQuery = (
                "update employees\n" +
                        "set stat = ?\n" +
                        "where employee_id = ?"
        );
        PreparedStatement ps = con.prepareStatement(prepQuery);
        CallableStatement callableStatement = con.prepareCall(callQuery);
        while(rs1.next()) {
            int id = rs1.getInt("employee_id");
            callableStatement.setInt(1, id);
            callableStatement.registerOutParameter(2, Types.VARCHAR);
            callableStatement.executeUpdate();
            String status = callableStatement.getString(2);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.execute();

            ps.clearParameters();
            callableStatement.clearParameters();
        }
        con.close();
    }
}
