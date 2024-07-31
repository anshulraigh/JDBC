import java.io.*;
import java.sql.*;

public class InsertingDynamically {
    public static void main(String args[]){
        String url = "";
        String username = "root";
        String password = "Anshulrai@05";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);

            //create a query 
            String q = "insert into table1(tName,tCity) values (?,?)";
            //get the PreparedStatement object
            PreparedStatement pstmt = con.prepareStatement(q);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name");
            String name = br.readLine();

            System.out.println("Enter City");
            String city = br.readLine();
            
            pstmt.setString(1,name);
            pstmt.setString(2,city);

            pstmt.executeUpdate();
            con.close();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
}
