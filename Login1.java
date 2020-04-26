package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login1 {

	public static void main(String[] args) throws SQLException {
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Username");
		String Name=scn.nextLine();
		System.out.println("Enter Password");
		String Password=scn.nextLine();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass","root","Lakshmi@19");
		Statement stat=con.createStatement();
		
		StringBuilder queryBuilder=new StringBuilder();
		queryBuilder.append("select * from user where name='")
		.append(Name)
		.append("'")
		.append("and Password='")
		.append(Password)
		.append("'");
		System.out.println(queryBuilder.toString());
		
		//resultset is holding the whole data
		ResultSet rs=stat.executeQuery(queryBuilder.toString());
		//rs.next will check the data is available
		//whenever we call rs.next it moves from -1 index to 0
		//whaterver you have given thing is true then only rs.next moves otherwise it shows error
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3));
		
		}
	}

}
