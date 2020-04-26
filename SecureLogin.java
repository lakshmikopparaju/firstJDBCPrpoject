package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SecureLogin {

public static void main(String[] args) throws SQLException {
		
		Scanner scn=new Scanner(System.in);
//		System.out.println("Enter Username");
//		String Name=scn.nextLine();
		System.out.println("Enter Password");
		String Password=scn.nextLine();
		System.out.println("Enter ID");
		int ID=scn.nextInt();
		
		Connection con=JDBCTemplate.getConnection();
		
	//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass","root","Lakshmi@19");
		

		
	//to avoid sql injection use preparestatement
		/*preparestatement will improve the performance
		many times you can pass different values it treats as a same query*/
		
		//String sql="select * from user where Name=? and Password=?";
		//String sql="insert into user(Name,Password) values(?,?)";
		String sql="update user set Password=? where id=?";
	PreparedStatement pstat=con.prepareStatement(sql);
		//? mark means positional parameter- name and password are positional parameters
		//pstat.setString(1, Name);
		pstat.setString(1,Password);
		pstat.setInt(2, ID);
		//resultset is holding the whole data
		//ResultSet rs=pstat.executeQuery();
		pstat.executeUpdate();
		//rs.next will check the data is available
		//whenever we call rs.next it moves from -1 index to 0
		//whaterver you have given thing is true then only rs.next moves otherwise it shows error
		
//		while(rs.next()) {
//			System.out.println(rs.getInt(1) +" "+rs.getString(2)+" "+rs.getString(3));
		
		//}
	}

}
