package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) throws SQLException{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter UserID");
		int userID=scn.nextInt();
		System.out.println("Enter Password");
		String Password=scn.next();
		
		Connection con=null; // local variable should be initialized
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass","root","Lakshmi@19");
			Statement stat=con.createStatement();
			// once you created the statement you can execute the queries
			 String sql="select * from user where ID="+userID+" and Password = '"+Password+"'";
			
			/* String is immutable if you try doing more concatinations on a single string object 
			 it creates many objects depending on your concatinations but StringBuilder will change the
			 concatinations on a single object it won't create multiple objects*/
			 StringBuilder queryBuilder=new StringBuilder();
			queryBuilder.append("select * from user where ID=")
			.append(userID)
			.append(" and Password=")
			.append("'")
			.append(Password)
			.append("'");
			
			System.out.println(queryBuilder.toString());
			
			ResultSet rs=stat.executeQuery(queryBuilder.toString());
			//next will check whether the data is available
//			if(!rs.next()) {
//			System.out.println("Username or Password is incorrect");	
//			}
			
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			else {
				System.out.println("Username or Password is incorrect");		
			}
			//stat.executeUpdate(sql);
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


