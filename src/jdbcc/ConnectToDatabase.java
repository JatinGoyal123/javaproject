package jdbcc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
	public static Connection getConnection ()
	{
		Connection con=null;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost/javadb","root","");
			/* System.out.println("Connected..."); */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	/*
	 * public static void main(String args[]) { Connection ref=getConnection();
	 * if(ref!=null) { System.out.println("Connected"); } else {
	 * System.out.println("Not "); }
	 * 
	 * }
	 */
}
