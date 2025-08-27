package JDBC_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class jdbc_conn {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/mydb";  // Replace with your actual DB
        String user = "root";
        String password = "Penny#219";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created successfully!");

            // Create statement and execute query
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Emp");

            // Print result
            System.out.println("ID\tName\tSalary");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println(id + "\t" + name + "\t" + salary);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection or SQL error: " + e.getMessage());
        } finally {
            // Close resources in reverse order of creation
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                System.out.println("Resources closed.");
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
