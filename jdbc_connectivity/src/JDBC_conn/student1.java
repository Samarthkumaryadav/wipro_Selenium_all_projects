package JDBC_conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class student1 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "Penny#219";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            student1 dbOps = new student1();
            
            System.out.println("Database connection successful.");

            dbOps.createAndPopulateTables(stmt);
            dbOps.queryData(stmt);
            dbOps.alterTableStructure(stmt);
            dbOps.executeJoins(stmt);
            dbOps.deleteDataAndTables(stmt);

        } catch (SQLException e) {
            System.err.println("An SQL error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void createAndPopulateTables(Statement stmt) throws SQLException {
        String createStudentTable = "CREATE TABLE IF NOT EXISTS Student_Info (roll_number INT PRIMARY KEY, full_name VARCHAR(50), score INT, email_address VARCHAR(50), location VARCHAR(50))";
        stmt.executeUpdate(createStudentTable);
        System.out.println("Table 'Student_Info' created or already exists.");

        String createInstituteTable = "CREATE TABLE IF NOT EXISTS Institution (roll_number INT PRIMARY KEY, institution_name VARCHAR(50))";
        stmt.executeUpdate(createInstituteTable);
        System.out.println("Table 'Institution' created or already exists.");

        String insertStudents = "INSERT INTO Student_Info VALUES (101, 'Ravada', 98, 'ravada.s@example.com', 'Chennai'), (102, 'Eswari', 96, 'eswari.j@example.com', 'AP'), (103, 'Priya', 94, 'priya.k@example.com', 'AP'), (104, 'Riya', 92, 'riya.g@example.com', 'Chennai')";
        int studentsInserted = stmt.executeUpdate(insertStudents);
        System.out.println(studentsInserted > 0 ? "Student records inserted." : "Student records not inserted (might already exist).");

        String insertInstitutes = "INSERT INTO Institution VALUES (101, 'IIT'), (102, 'NIT'), (103, 'Raghu')";
        int institutesInserted = stmt.executeUpdate(insertInstitutes);
        System.out.println(institutesInserted > 0 ? "Institution records inserted." : "Institution records not inserted (might already exist).");
    }

    private void queryData(Statement stmt) throws SQLException {
        System.out.println("\n--- All Student Records ---");
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM Student_Info")) {
            printResultSet(rs);
        }

        int rowsUpdated = stmt.executeUpdate("UPDATE Student_Info SET score = 80 WHERE roll_number = 103");
        if (rowsUpdated > 0) {
            System.out.println("\nRecord for Roll No. 103 updated.");
        }

        try (ResultSet rs = stmt.executeQuery("SELECT full_name, score FROM Student_Info ORDER BY score DESC LIMIT 1")) {
            if (rs.next()) {
                System.out.println("Highest scorer: " + rs.getString("full_name") + " with a score of " + rs.getInt("score"));
            }
        }

        System.out.println("\n--- Students in Ascending Order of Score ---");
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM Student_Info ORDER BY score ASC")) {
            printResultSet(rs);
        }

        System.out.println("\n--- Students from 'AP' ---");
        try (ResultSet rs = stmt.executeQuery("SELECT full_name FROM Student_Info WHERE location = 'AP'")) {
            while (rs.next()) {
                System.out.println(rs.getString("full_name"));
            }
        }
    }

    private void alterTableStructure(Statement stmt) throws SQLException {
        stmt.executeUpdate("ALTER TABLE Student_Info ADD COLUMN student_age INT");
        System.out.println("\nColumn 'student_age' added.");

        stmt.executeUpdate("ALTER TABLE Student_Info MODIFY COLUMN student_age VARCHAR(10)");
        System.out.println("Column 'student_age' data type modified.");

        stmt.executeUpdate("RENAME TABLE Student_Info TO Student_Records");
        System.out.println("Table 'Student_Info' renamed to 'Student_Records'.");

        System.out.println("\n--- Updated 'Student_Records' Table ---");
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM Student_Records")) {
            while (rs.next()) {
                System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                        rs.getInt("roll_number"),
                        rs.getString("full_name"),
                        rs.getInt("score"),
                        rs.getString("email_address"),
                        rs.getString("location"));
            }
        }
    }

    private void executeJoins(Statement stmt) throws SQLException {
        System.out.println("\n--- Inner Join: Student and Institution ---");
        String innerJoinSQL = "SELECT T1.full_name, T2.institution_name " +
                              "FROM Student_Records AS T1 INNER JOIN Institution AS T2 " +
                              "ON T1.roll_number = T2.roll_number";
        try (ResultSet rs = stmt.executeQuery(innerJoinSQL)) {
            printJoinResults(rs);
        }

        System.out.println("\n--- Left Join: Student and Institution ---");
        String leftJoinSQL = "SELECT T1.full_name, T2.institution_name " +
                             "FROM Student_Records AS T1 LEFT JOIN Institution AS T2 " +
                             "ON T1.roll_number = T2.roll_number";
        try (ResultSet rs = stmt.executeQuery(leftJoinSQL)) {
            printJoinResults(rs);
        }
    }

    private void deleteDataAndTables(Statement stmt) throws SQLException {
        stmt.executeUpdate("ALTER TABLE Student_Records DROP COLUMN student_age");
        System.out.println("\nColumn 'student_age' deleted.");

        int rowsDeleted = stmt.executeUpdate("DELETE FROM Student_Records WHERE roll_number = 101");
        if (rowsDeleted > 0) {
            System.out.println("Record for Roll No. 101 deleted.");
        }

        stmt.executeUpdate("TRUNCATE TABLE Student_Records");
        System.out.println("All records from 'Student_Records' deleted.");

        stmt.executeUpdate("DROP TABLE Student_Records");
        System.out.println("Table 'Student_Records' dropped.");
        stmt.executeUpdate("DROP TABLE Institution");
        System.out.println("Table 'Institution' dropped.");
    }
    
    private void printResultSet(ResultSet rs) throws SQLException {
        System.out.println("Roll No.\tName\t\tScore\tEmail\t\t\tLocation");
        while (rs.next()) {
            System.out.printf("%d\t\t%s\t%d\t%s\t%s\n",
                    rs.getInt("roll_number"),
                    rs.getString("full_name"),
                    rs.getInt("score"),
                    rs.getString("email_address"),
                    rs.getString("location"));
        }
    }

    private void printJoinResults(ResultSet rs) throws SQLException {
        System.out.println("Student Name\t\tInstitution Name");
        while (rs.next()) {
            String studentName = rs.getString("full_name");
            String institutionName = rs.getString("institution_name");
            System.out.printf("%s\t\t%s\n",
                    studentName != null ? studentName : "N/A",
                    institutionName != null ? institutionName : "N/A");
        }
    }
}