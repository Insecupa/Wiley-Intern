package Day17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddColumn {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DatabaseConnector.getConnection();
//        String query = (
//                "ALTER TABLE departments ADD COLUMN street_address varchar(50)"
//                );
//        PreparedStatement ps = con.prepareStatement(query);
//        Statement st = con.createStatement();
//        System.out.println(st.executeUpdate(query));
//        System.out.println(ps.executeUpdate());

//        if(true) {
//            System.out.println("Column Added.");
//        } else {
//            System.out.println("Column not added");
//        }


    }
}
