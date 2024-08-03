import java.sql.*;
import java.io.*;
public class UpdateJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            String q = "update table1 set tName=?, tCity=? where tId=?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new name : ");
            String name = br.readLine();

            System.out.println("Enter new city name : ");
            String city = br.readLine();
            
            System.out.println("Enter the Student Id : ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(q); // Prepare statement

            pstmt.setString(1,name);
            pstmt.setString(2,city);

            pstmt.setInt(3,id);

            pstmt.executeUpdate();
            System.out.println("Done...");
            con.close();
        }catch(Exception e){

        }
    }
}
