import java.sql.*;
public class InsertUsingPreparedStatement {
    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println(con.isClosed()?"Connection is closed":"Connection Created");

            //crreate a query
            String q = "insert into table1(tName,tCity) values (?,?)";

            //get the PreparedStatement object
            PreparedStatement pstmt = con.prepareStatement(q);

            //set the value to query
            pstmt.setString(1,"Ekta Tiwari");
            pstmt.setString(2,"Chhindwara");

            pstmt.executeUpdate();
            System.out.println("inserted...");

            //close the connction 
            con.close();
        } catch (Exception e) {
        }
    }
}
