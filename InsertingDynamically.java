import java.io.*;
import java.sql.*;

public class InsertingDynamically {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";
        Connection con = null;
        PreparedStatement pstmt = null;
        BufferedReader br = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            // Create a query
            String q = "INSERT INTO table1(tName, tCity) VALUES (?, ?)";
            
            // Get the PreparedStatement object
            pstmt = con.prepareStatement(q);
            br = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Enter Name:");
            String name = br.readLine();
            
            System.out.println("Enter City:");
            String city = br.readLine();

            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (SQLException | IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
