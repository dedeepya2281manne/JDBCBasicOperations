package DemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			if(con.isClosed()){
				System.out.print("Connection is closed");
			}
			else{
				System.out.println("Connection created.....");
				String createTable="create table student(student_id int(20) primary key auto_increment,student_name varchar(200) not null,city varchar(30))";
				Statement stmt=con.createStatement();
				stmt.executeUpdate(createTable);
				System.out.println("Table is created in Database....");
				String insert="insert into student(student_name,city) values(?,?)";
				con.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
