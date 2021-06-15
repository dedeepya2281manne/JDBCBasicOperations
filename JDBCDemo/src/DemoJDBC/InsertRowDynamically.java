package DemoJDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRowDynamically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String student_name=br.readLine();
				String city=br.readLine();
				
				pstmt.setString(1, student_name);
				pstmt.setString(2, city);
				
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
