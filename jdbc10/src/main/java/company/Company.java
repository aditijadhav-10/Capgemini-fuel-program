package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		int eid;
		String ename;
		String eemail;
		String eaddress;
		double esalary;

		Scanner sc = new Scanner(System.in);

			System.out.println("Enter id:");
			eid = sc.nextInt();

			System.out.println("Enter name:");
			ename = sc.next();
			
			System.out.println("Enter email:");
			eemail=sc.next();

			System.out.println("Enter Address:");
			eaddress = sc.next();
			
			System.out.println("Enter salary:");
			esalary=sc.nextDouble();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "root");

				Statement stmt = con.createStatement();
				String query = "insert into emp values('"+eid+"','"+ename+"','"+eemail+"','"+eaddress+"','"+esalary+"')";
				stmt.executeUpdate(query);
				System.out.println("recoed saved");
				
			}catch(Exception e)
			{
				System.out.println("error"+e.toString());
			}

			

	}

}
