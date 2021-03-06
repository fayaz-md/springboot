package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.service.EmployeeService;
import java.util.Scanner;
public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Scanner sc=new Scanner(System.in);
		
		EmployeeService es=(EmployeeService)ac.getBean("employeeService");
		int ch,id;
		String name;
		float salary;
		do {
			System.out.println("1.Insert a record\n2.Delete a record\n3.Update a record\n4.Retreive Eployees\n5.Exit");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1: System.out.println("Enter Id: ");
					id=sc.nextInt();	
					System.out.println("Enter Name: ");
					name=sc.next();
					System.out.println("Enter salary: ");
					salary=sc.nextFloat();
					Employee emp=(Employee)ac.getBean("employee");
					emp.setId(id);
					emp.setName(name);
					emp.setSalary(salary);
					
					System.out.println(es.storeEmployeeDetails(emp));
					break;
				case 2: System.out.println("Enter Id: ");
					id=sc.nextInt();
					Employee emp1=(Employee)ac.getBean("employee");
					emp1.setId(id);
					System.out.println(es.deleteEmployeeDetails(id));
					break;
				case 3: System.out.println("Enter Id: ");
					id=sc.nextInt();
					System.out.println("Enter salary: ");
					salary=sc.nextFloat();
					Employee emp2=(Employee)ac.getBean("employee");
					emp2.setId(id);
					
					emp2.setSalary(salary);
					System.out.println(es.updateEmployeeDetails(emp2));
					break;
				case 4: es.displayEmployeeDetails().forEach(e->System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()));
					break;
				case 5:
					break;
				default:System.out.println("Enter valid choice");
				
			}
		}while(ch!=5);
		
	}

}
