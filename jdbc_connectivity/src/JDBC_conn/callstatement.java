package JDBC_conn;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class callstatement {

    private static final String URL = "jdbc:mysql://localhost:3306/my_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Penny#219";
    private static final String PROCEDURE_CALL = "{CALL getStudentByMarks(?)}";

    public static void main(String[] args) {
        try {
            fetchStudentsWithCallableStatement(90);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fetchStudentsWithCallableStatement(int minMarks) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             CallableStatement cstmt = conn.prepareCall(PROCEDURE_CALL)) {

            cstmt.setInt(1, minMarks);

            try (ResultSet rs = cstmt.executeQuery()) {
                System.out.println("ID\tName\t\t\tMarks");
                System.out.println("------------------------------------");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int marks = rs.getInt("marks");
                    System.out.printf("%d\t%-20s\t%d\n", id, name, marks);
                }
            }
        }
    }
}