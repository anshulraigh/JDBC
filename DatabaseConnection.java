import java.sql.*;
class DatabaseConnection{
    public static void main(String args[]){
        String jdbcURL = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            Connection con = DriverManager.getConnection(jdbcURL,username,password);

            if(con.isClosed()){
                System.out.println("Connection is closed");
            }else{
                System.out.println("Connection Created....");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}