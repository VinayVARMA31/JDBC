import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args)  {
      try {
        //Load the Driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver class has been successfully loaded.");

        String url = "jdbc:mysql://localhost:3306/sys";
        String user ="root";
        String password ="root";
        //Crerate a connection using DriverMnager
        Connection con = DriverManager.getConnection(url,user,password);
        System.out.println("Connected to the database.");
        //Create a statement for the connection
        Statement st = con.createStatement();

        String sql ="SELECT ename FROM emp";

        //Execute the statement 
        ResultSet rs = st.executeQuery(sql);
 
        while (rs.next()) {
          System.out.println(rs.getString(1));
        }


        //close the connection 
        con.close();


      } catch (Exception e) {
        System.out.println(e);
      }
}
}
