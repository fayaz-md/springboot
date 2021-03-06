package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
@Repository
public class EmployeeDao {
	@Autowired
	DataSource ds;
	public int storeEmployee(Employee emp)
	{
		try {
			Connection con=ds.getConnection();
			PreparedStatement pstm=con.prepareStatement("insert into employee values(?,?,?)");
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setFloat(3, emp.getSalary());
			return pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return 0;
	}
	public int deleteEmployee(Employee emp)
	{
		try
		{
			Connection con=ds.getConnection();
			PreparedStatement stm=con.prepareStatement("delete from employee where id=?");
			stm.setInt(1, emp.getId());
			return stm.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public int updateEmployee(Employee emp)
	{
		try {
			Connection con=ds.getConnection();
			PreparedStatement stm=con.prepareStatement("update employee modify set salary=? where id=?");
			stm.setFloat(1,emp.getSalary());
			stm.setInt(2,emp.getId());
			return stm.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public void displayEmployeeDetails()
	{
		try {
			Connection con=ds.getConnection();
			PreparedStatement stm=con.prepareStatement("select * from employee");
			ResultSet rs=stm.executeQuery();
			System.out.println("-----------Employee Details------------");
			while(rs.next())
			{
				System.out.println("Id: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Salary: "+rs.getFloat(3));
				System.out.println("-------------------------------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
