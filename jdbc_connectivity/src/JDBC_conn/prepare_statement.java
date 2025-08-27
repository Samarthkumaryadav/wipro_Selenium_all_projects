package JDBC_conn;

import java.sql.*;

public class prepare_statement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Step 1: Connection details
        String url = "jdbc:mysql://localhost:3306/sam1";
        String user = "root";
        String password = "Penny#219";

        // Step 2: Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 3: Connect to the database
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("✅ Connection Created");

        // Step 4: Delete existing data to avoid duplicate primary key errors
        Statement clearStmt = con.createStatement();
        clearStmt.executeUpdate("DELETE FROM student2");
        clearStmt.close();

        // Step 5: Prepare insert query
        String query = "INSERT INTO student2 (rollno, name, age) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);

        // Step 6: Insert 3 records
        pst.setInt(1, 101);
        pst.setString(2, "Neeva Sharma");
        pst.setInt(3, 20);
        pst.executeUpdate();

        pst.setInt(1, 102);
        pst.setString(2, "Reeva Sharma");
        pst.setInt(3, 21);
        pst.executeUpdate();

        pst.setInt(1, 103);
        pst.setString(2, "Shiva Upadhyay");
        pst.setInt(3, 22);
        pst.executeUpdate();

        pst.close();

        System.out.println("✅ All records inserted successfully.\n");

        // Step 7: Fetch and print the records
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student2");

        System.out.println("🎓 Student Table Records:");
        while (rs.next()) {
            int roll = rs.getInt("rollno");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println("Roll No: " + roll + ", Name: " + name + ", Age: " + age);
        }

        // Step 8: Close resources
        rs.close();
        stmt.close();
        con.close();
    }
}
