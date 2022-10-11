package Day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Main {

    Connection con;
    static Scanner scanner = new Scanner(System.in);
    public Main() throws SQLException, ClassNotFoundException {
        con = DatabaseConnector.getConnection();
    }

    public void createTable() throws SQLException {
        String query = "create table user(" +
                "user varchar(20) primary key," +
                "password varchar(20) not null" +
                ");";

        Statement s = con.createStatement();
    }

    public void addUser(String user, String password) throws SQLException {
        String query = "insert into user values(?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, password);

        int rows = ps.executeUpdate();
        if(rows > 0) {
            System.out.println("Added a new user");
        } else {
            System.out.println("Error adding new user");
        }
    }

    public boolean getUser(String name, String pass) throws SQLException {
        String query = "select user, password from user where user = ?";
        PreparedStatement prp;
        prp = con.prepareStatement(query);
        prp.setString(1, name);

        ResultSet rs = prp.executeQuery();
        if(rs.isBeforeFirst()) {
            while(rs.next()) {
                System.out.println(
                        "User: " + rs.getString(1) + " passsword: " + rs.getString(2)
                );
            }
        } else {
            System.out.println("User does not exist, would you like to add the user in the database? ");
            int flag = scanner.nextInt();
            if (flag == 1) {
                addUser(name, pass);
                System.out.println("User added.");
                return true;
            }
        }
        return false;
    }

    public void printUser() throws SQLException {
        String query = "select * from user";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(!rs.isBeforeFirst()) {
            System.out.println("No rows exist");
        } else {
            while(rs.next()) {
                System.out.println(
                        "User: " + rs.getString(1) + " passsword: " + rs.getString(2)
                );
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //User -> username password
        //Check for combination in the table, if not found say no user, ask and insert
        Main mDb = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the choice:\n1.Print Database\n2.Add User\n3.Get User");
        int choice = scanner.nextInt();
        while(choice >=1 && choice <=3) {
            switch (choice) {
                case 1:
                    mDb.printUser();
                    System.out.println("---------------------------------");
                    break;
                case 2:
                    System.out.println("Enter the user name: ");
                    String user1 = br.readLine();
                    System.out.println("Enter the password");
                    String pp = br.readLine();
                    mDb.addUser(user1, pp);
                    break;
                case 3:
                    System.out.println("Enter the user to search: ");
                    String s = br.readLine();
                    System.out.println("Enter the user password to search: ");
                    String p = br.readLine();
                    mDb.getUser(s,p);
            }
            System.out.println("Enter the choice:\n1.Print Database\n2.Add User");
            System.out.println("3.Get User");
            choice = scanner.nextInt();
        }

        mDb.con.close();
    }
}
