package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import bean.Employee;
import resource.DbConnection;

public class EmployeeDao {
	Connection con;
	public EmployeeDao(){
		con=DbConnection.getDbConnection();
	}
	public List<Employee> retrieveEmployeeDetails()
	{
		List<Employee> list=new ArrayList<Employee>();
		try {
			
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from employee");
		while(rs.next())
		{
			Employee emp=new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getFloat(3));
			list.add(emp);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public int storeEmployeeDetails(Employee emp)
	{
		try {
			PreparedStatement pstm=con.prepareStatement("insert into employee values(?,?,?)");
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setFloat(3, emp.getSalary());
			return pstm.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return 0;
	}
	public int deleteEmployeeDetails(int id) {
		try {
			PreparedStatement pstm=con.prepareStatement("delete from employee where id=?");
			pstm.setInt(1, id);
			return pstm.executeUpdate();

		}
		catch(Exception e)
		{
			
		}
		return 0;

	}
	public int updateEmployeeDetails(int id,float salary)
	{
		try {
			PreparedStatement pstm=con.prepareStatement("update employee modify set salary=? where id=?");
			pstm.setInt(2, id);
			pstm.setFloat(1, salary);
			return pstm.executeUpdate();

		}
		catch(Exception e)
		{
			
		}
		return 0;

	}
}
