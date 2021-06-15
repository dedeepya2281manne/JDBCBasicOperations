package DemoJDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTable {

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
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String update="update student set student_name=?, city=? where student_id=?";
				System.out.print("Enter student name : ");
				String student_name=br.readLine();
				System.out.print("Enter city name : ");
				String city=br.readLine();
				System.out.print("Enter id : ");
				int student_id=Integer.parseInt(br.readLine());
				
				PreparedStatement pstmt=con.prepareStatement(update);
				pstmt.setString(1, student_name);
				pstmt.setString(2, city);
				pstmt.setInt(3, student_id);
				
				
				pstmt.executeUpdate();
				System.out.println("A row updated...");
				con.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}


	}

}
