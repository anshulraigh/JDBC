import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageSave {
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbctutorial";
        String username = "root";
        String password = "Anshulrai@05";
        String filePath = "anshulpicture.jpeg";  // Change this to the absolute path for testing
        
        try (Connection con = DriverManager.getConnection(url, username, password);
             FileInputStream fis = new FileInputStream(filePath)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String q = "insert into images(pic) values(?)";
            try (PreparedStatement pstmt = con.prepareStatement(q)) {
                pstmt.setBinaryStream(1, fis, fis.available());
                pstmt.executeUpdate();
                System.out.println("Done...");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
