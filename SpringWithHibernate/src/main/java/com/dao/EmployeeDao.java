package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
@Repository
public class EmployeeDao {
	@Autowired
	SessionFactory sf;
	public int storeEmployee(Employee emp)
	{
		Session session=sf.openSession();
		Transaction tran=session.getTransaction();
		tran.begin();
		session.save(emp);
		tran.commit();
		Employee e=session.get(Employee.class, emp.getId());
		if(e!=null)
			return 1;
		return 0;
	}
	public int deleteEmployee(int id)
	{
		Session session=sf.openSession();
		Employee e=session.get(Employee.class,id);
		if(e==null)
			return 0;
		Transaction tran=session.getTransaction();
		tran.begin();
		session.delete(e);
		tran.commit();
		
		return 1;
	}
	public int updateEmployee(Employee emp)
	{
		
		Session session=sf.openSession();
		Employee e=session.get(Employee.class, emp.getId());
		if(e==null)
			return 0;
		Transaction tran=session.getTransaction();
		tran.begin();
		e.setSalary(emp.getSalary());
		session.update(e);
		tran.commit();
		
		return 1;
	}
	public List<Employee> displayEmployeeDetails()
	{
	 Session session=sf.openSession();	
	 Query query=session.createQuery("select emp from Employee emp");
	 List<Employee> list=query.list();
	 return list;
	}
}
