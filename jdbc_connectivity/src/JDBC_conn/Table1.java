package JDBC_conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Table1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "Penny#219";

        String createSQL = "CREATE TABLE IF NOT EXISTS students ("
                + "rollno INT PRIMARY KEY,"
                + "name VARCHAR(50),"
                + "per INT,"
                + "email VARCHAR(50))";

        String insertSQL = "INSERT INTO students (rollno, name, per, email) VALUES "
                + "(101, 'Neeva Sharma', 98, 'abc@gmail.com'),"
                + "(102, 'Reeva Sharma', 89, 'Reeva@gmail.com'),"
                + "(103, 'Shiva Upadhyay', 79, 'shiva@gmail.com')";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created.");
            
            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate(createSQL);
                System.out.println("Students table created.");

                try {
                    int rowInserted = stmt.executeUpdate(insertSQL);
                    if (rowInserted > 0) {
                        System.out.println("New student records inserted.");
                    }
                } catch (SQLException e) {
                    System.out.println("Records may already exist: " + e.getMessage());
                }

                System.out.println("\n--- Student Records ---");
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
                    System.out.println("rollno\tname\tper\tEmail");
                    while (rs.next()) {
                        int rollno = rs.getInt("rollno");
                        String name = rs.getString("name");
                        int per = rs.getInt("per");
                        String email = rs.getString("email");
                        System.out.println(rollno + "\t" + name + "\t" + per + "\t" + email);
                    }
                }
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
        }
    }
}