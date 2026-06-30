package jdbc123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) {
		int sid;
		String sname;
		String saddress;
		String scourse;

		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Enter Student id:");
			sid = sc.nextInt();

			System.out.println("Enter Student name:");
			sname = sc.next();

			System.out.println("Enter Student Address:");
			saddress = sc.next();

			System.out.println("Enter Student Course:");
			scourse = sc.next();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clg", "root", "root");

			PreparedStatement ps = con.prepareStatement("insert into stu values(?,?,?,?)");
			ps.setInt(1, sid);
			ps.setString(2, sname);
			ps.setString(3, saddress);
			ps.setString(4, scourse);
			ps.executeUpdate();
			System.out.println("Done ");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
