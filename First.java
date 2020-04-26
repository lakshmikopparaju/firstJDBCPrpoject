package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class First {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		// Class.Forname is used to load the class
		// new keyword and other by Class.newinstanceof to create an object
		
		//DriverManager attempts to load so many classes
		
		// you may have entered the wrong credentials then we can catch the exception
		// we can also use throws keyword in this case it will not help so we go to try catch
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass","root","Lakshmi@19");
			Statement stat=con.createStatement();
			// once you created the statement you can execute the queries
			String sql="create table user(\r\n" + 
					"ID int not null primary key auto_increment,\r\n" + 
					"Name varchar(20),\r\n" + 
					"Password varchar(20)\r\n"+
					")";
			
			//create,update,delete use stat.executeupdate by passing query
			//retrieve,fetch,select data go for stat.executequery
			//the table is resultset
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				con.close();
			}
		}

	}

}
