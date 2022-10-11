package Day17;

import java.sql.*;

public class CalculateAvg {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnector.getConnection();
        String query = "SELECT * FROM jobs";
        String prepQuery = "UPDATE jobs SET avg_salary = ? where job_id = ?";
        CallableStatement callableStatement = con.prepareCall("{ call calculateAvg(?, ?) }");
        PreparedStatement ps = con.prepareStatement(prepQuery);
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()) {
            int id = rs.getInt(1);
            callableStatement.setInt(1, id);
            callableStatement.registerOutParameter(2, Types.DECIMAL);
            callableStatement.executeUpdate();
            Double d = callableStatement.getDouble(2);
            ps.setDouble(1, d);
            ps.setInt(2, id);
            ps.execute();
            ps.clearParameters();
            callableStatement.clearParameters();
        }
        con.close();
    }
}
