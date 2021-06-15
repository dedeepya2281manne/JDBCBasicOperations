package DemoJDBC;



import java.sql.*;



public class ResultSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			String query="select * from student";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()){
				System.out.println("id : "+rs.getInt(1)+" name : "+rs.getString(2)+" city : "+rs.getString(3));
			}
		}
		catch(Exception e){
			
		}
	}

}
