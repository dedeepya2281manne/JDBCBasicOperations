package DemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertRow {
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			if(con.isClosed()){
				System.out.print("Connection is closed");
			}
			else{
				System.out.println("Connection created.....");
				String insert="insert into student(student_name,city) values(?,?)";
				PreparedStatement pstmt=con.prepareStatement(insert);
				pstmt.setString(1, "Dedeepya");
				pstmt.setString(2, "Guntur");
				pstmt.executeUpdate();
				System.out.println("A row inserted...");
				con.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
