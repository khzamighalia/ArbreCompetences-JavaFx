package ConnectionDB;
import java.sql.*;
public class Declaration {

	public static Connection con;
	public static Statement stm;
	public static ResultSet rs;
	
	public static void connect() throws SQLException {
		  con=DriverManager.getConnection("jdbc:mysql://localhost:8000/_Tree_?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "admin");

				}
	
	public static void deconnecte() throws SQLException{
	    con.close();
	}
	
	
	
}


