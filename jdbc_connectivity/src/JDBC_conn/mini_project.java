package JDBC_conn;
import java.sql.*;
public class mini_project {
	public static void main(String[] args) {
	 String url = "jdbc:mysql://localhost:3306/mydb";
     String user = "root";
     String password = "Penny#219";

     try (Connection conn = DriverManager.getConnection(url, user, password);
          Statement stmt = conn.createStatement()) {

         stmt.execute("CREATE TABLE IF NOT EXISTS Student (" +
                 "id INT PRIMARY KEY, name VARCHAR(50), city VARCHAR(50), percentage FLOAT)");
     
         // 2. Insert Records
         stmt.execute("INSERT INTO Student (id, name, city, percentage) VALUES " +
                 "(1, 'Rahul', 'Indore', 85.6), " +
                 "(2, 'Priya', 'Bhopal', 90.3), " +
                 "(3, 'Aman', 'Indore', 75.0), " +
                 "(4, 'Simran', 'Delhi', 95.2), " +
                 "(5, 'Ankit', 'Bhopal', 67.4)");

         // 3. Print Table
         ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
         System.out.println("Students Table:");
         while (rs.next()) {
             System.out.println(rs.getInt("id") + " " +
                     rs.getString("name") + " " +
                     rs.getString("city") + " " +
                     rs.getFloat("percentage"));
         }
     } catch (SQLException e) {
         e.printStackTrace();}}}

