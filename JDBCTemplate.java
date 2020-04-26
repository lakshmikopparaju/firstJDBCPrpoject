//singleton means creating single object for whole project
// if we want only one object to be created for the whole project
// don't want the object to be recreated by another user
// static blocks execute for single time when the class is loaded into JVM-single copy of memory
// using this in securelogin Program
package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {

	private static Connection con;
	
	private JDBCTemplate() {
	
	}
	
	
	public static Connection getConnection() throws SQLException {
		
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass","root","Lakshmi@19");
	return con;
	}
	
}
