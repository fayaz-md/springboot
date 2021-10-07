package service;

import java.util.List;

import bean.Employee;
import dao.EmployeeDao;

public class EmployeeService {
	EmployeeDao employeeDao=new EmployeeDao();
	public List<Employee> getAllEmployeeDetails()
	{
		return employeeDao.retrieveEmployeeDetails();
	}
	public String storeEmployee(Employee emp)
	{
		if(emp.getSalary()<10000)
		{
			return ("Salary must be greater than 10000");
		}
		else
		{
			if(employeeDao.storeEmployeeDetails(emp)>0)
			return "Employee record stored successfully";
			else
			return "Record didn't store";
		}
	}
	public String deleteEmployee(int id)
	{
		if(employeeDao.deleteEmployeeDetails(id)>0)
			return "Employee record deleted successfully";
		else
			return "Employee record doesn't exists";
	}
	public String updateEmployee(int id,float salary)
	{
		if(salary<10000)
			return ("Salary must be greater than 10000");
		else {
		if(employeeDao.updateEmployeeDetails(id, salary)>0)
			return "Employee record updated successfully";
		else
			return "Employee record doesn't exists";
		}
	}
}
