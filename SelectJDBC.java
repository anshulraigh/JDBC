import java.sql.*;
import java.sql.DriverManager;

public class SelectJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            String q = "select * from table1";

            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while(set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println(id + " " + name + " " + city);
            }
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
