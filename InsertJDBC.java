import java.sql.*;
public class InsertJDBC {
    public static void main(String args[]){
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";

        try {
            //load the driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creating a connection
            try (Connection con = DriverManager.getConnection(url,username,password)) {
                System.out.println(con.isClosed() ? "Connection is closed" : "Connection Created...");
                
                //Create a query
                String q = "create table table1(tID int(20) primary key auto_increment,tName varchar(200) not null, tCity varchar(400))";
    
                //Create a statement:
                Statement stmt = con.createStatement();
                stmt.executeUpdate(q);
                System.out.println("Table created in database..");
            }

        } catch (Exception e) {

        }

    }
}
