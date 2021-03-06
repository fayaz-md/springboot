package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	public String storeEmployeeDetails(Employee emp)
	{
		if(employeeDao.storeEmployee(emp)>0)
				return "Employee record stored successfully";
		else
				return "Employee record didn't store";
	}
	public String deleteEmployeeDetails(int id)
	{
		if(employeeDao.deleteEmployee(id)>0)
			return "Employee record deleted successfully";
	else
			return "Employee record doesn't exists";
	}
	public String updateEmployeeDetails(Employee emp)
	{
		if(employeeDao.updateEmployee(emp)>0)
			return "Employee record updated successfully";
	else
			return "Employee record doesn't exists";
	}
	public List<Employee> displayEmployeeDetails()
	{
		return employeeDao.displayEmployeeDetails();
	}
}
