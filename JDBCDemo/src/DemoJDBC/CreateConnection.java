package DemoJDBC;


import java.sql.*;

public class CreateConnection {
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			if(con.isClosed()){
				System.out.print("Connection is closed");
			}
			else{
				System.out.println("Connection created.....");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
