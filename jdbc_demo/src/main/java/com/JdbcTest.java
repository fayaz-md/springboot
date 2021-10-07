package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fisdb","root","Simplilearn");
			System.out.println("Connceted successfully");
			PreparedStatement st=con.prepareStatement("select * from employee");
			PreparedStatement st1=con.prepareStatement("update employee modify set name=? where id=?");
			st1.setString(1,"sneha");
			st1.setInt(2, 122);
			st1.executeUpdate();
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat("salary"));
			}
			rs.close();
			st.close();
			st1.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
