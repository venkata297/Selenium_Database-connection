package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Get_connection {
	
	@Test
	public void TestVerifyDB() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection("jdbc:odbc:Test_Oracle","system","selenium");
			System.out.println("connection created");
			
			Statement st = con.createStatement();
			System.out.println("statement created");
			
			ResultSet rs = st.executeQuery("select * from Users");
			System.out.println("Query executed");
			
			while(rs.next()) {
				String uname= rs.getString("username");
				String pass=  rs.getString("password");
				String email= rs.getString("email");
				
				System.out.println("Uname is "+uname+" password is "+pass+" email id is "+email);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
