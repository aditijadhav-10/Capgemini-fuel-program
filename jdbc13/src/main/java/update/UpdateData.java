package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateData {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee ID:");
        int eid = sc.nextInt();

        System.out.println("Enter New Name:");
        String ename = sc.next();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "root");

            Statement stmt = con.createStatement();

            String query = "update emp set ename='" + ename + "' where eid=" + eid;

            stmt.executeUpdate(query);

           System.out.println("record updated successfully");
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}