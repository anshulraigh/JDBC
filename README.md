# JDBC

1. **Load the Driver:**
    ```java
    Class.forName("com.mysql.cj.jdbc.Driver");
    ```

2. **Create a Connection:**
    ```java
    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dbname", "username", "password");
    ```

3. **Create Query, Statement, PreparedStatement, CallableStatement:**
    ```java
    String q = "SELECT * FROM students";
    Statement stmt = con.createStatement();
    ResultSet set = stmt.executeQuery(q);
    ```

4. **Process the Data:**
    ```java
    while (set.next()) {
        int id = set.getInt("studentID");
        String name = set.getString("studentName");
        System.out.println(id);
        System.out.println(name);
    }
    ```

5. **Close the Connection:**
    ```java
    con.close();
    ```
