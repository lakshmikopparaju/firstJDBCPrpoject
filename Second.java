package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Second {

	public static void main(String[] args) throws SQLException{
	Connection con=null; // local variable should be initialized
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass","root","Lakshmi@19");
			Statement stat=con.createStatement();
			// once you created the statement you can execute the queries
			String sql="insert into user(Name,Password) values('name1','pass1')";
			stat.executeUpdate(sql);
			System.out.println("Query Executed");
			//create,update,delete use stat.executeupdate by passing query
			//retrieve,fetch,select data go for stat.executequery
			//the table is resultset
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
			con.close();
		}

	}}
}
