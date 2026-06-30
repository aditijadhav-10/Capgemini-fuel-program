package jdbc55;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clg", "root", "root");

			Statement stmt = con.createStatement();
			String query = "create table stu(sid int,sname varchar(30),saddress varchar(300),scourse varchar(200))";
			stmt.executeUpdate(query);
			System.out.println("Table created");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

