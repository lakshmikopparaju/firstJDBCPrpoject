package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SecureLogin1 {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter ID");
//		int ID=sc.nextInt();
//		System.out.println("Enter Username");
//		String Username=sc.nextLine();
//		System.out.println("Enter Password");
//		String Password=sc.nextLine();
		try {
	
	 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/myclass", "root", "Lakshmi@19");
		Statement stat=conn.createStatement();
		String sql="create table PersonDetails(\r\n" + 
				"	ID int not null, \r\n" + 
				"	Username varchar(20), \r\n" + 
				"	Password varchar(20) \r\n" + 
				"	)";
				
		

		
		stat.executeUpdate(sql);
	
	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				conn.close();
			}
		}
	}
	
}
