import java.sql.*; // Import SQL package
import javax.swing.JFileChooser; // Import JFileChooser for file selection
import java.io.FileInputStream; // Import FileInputStream for reading file data
import java.io.File; // Import File class
import javax.swing.JOptionPane; // Import JOptionPane for dialog boxes

public class InsertBigImage {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbctutorial"; // Database URL
        String username = "root"; // Database username
        String password = "Anshulrai@05"; // Database password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //load the driver
            Connection c = DriverManager.getConnection(url, username, password); // Establish connection
            String q = "insert into images(pic) value(?)"; // SQL query to insert image
            
            PreparedStatement pstmt = c.prepareStatement(q); // Prepare statement
            
            JFileChooser jfc = new JFileChooser(); // File chooser for image selection
            jfc.showOpenDialog(null); // Open file chooser dialog
            File file = jfc.getSelectedFile(); // Get selected file
            FileInputStream fis = new FileInputStream(file); // File input stream to read file
            pstmt.setBinaryStream(1, fis, fis.available()); // Set binary stream in query
            pstmt.executeUpdate(); // Execute update
            JOptionPane.showMessageDialog(null, "Success"); // Show success message
            c.close(); // Close connection
        } catch(Exception e) {
            e.printStackTrace(); // Handle exceptions
        }
    }
}
