package main;

import java.util.Scanner;

import bean.Employee;
import service.EmployeeService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int ch;
		EmployeeService employeeService=new EmployeeService();
		do
		{
			System.out.println("1. Insert record\n2. Delete Record");
			System.out.println("3. Update record\n4. Display Records");
			System.out.println("5.Exit\nEnter choice");
			ch=sc.nextInt();
		
			switch(ch)
			{
			case 1:
				System.out.println("Enter the id: ");
				int id=sc.nextInt();
				System.out.println("Enter the Name: ");
				String name=sc.next();
				System.out.println("Enter the Salary: ");
				float salary=sc.nextFloat();
				Employee emp=new Employee(id,name,salary);
				System.out.println(employeeService.storeEmployee(emp));
				break;
			case 2:
				System.out.println("Enter the id to be deleted");
				int id1=sc.nextInt();
				System.out.println(employeeService.deleteEmployee(id1));
				break;
			case 3:System.out.println("Enter the id whose salary to be updated");
				int id2=sc.nextInt();
				System.out.println("Enter the new salary");
				float sal=sc.nextFloat();
				System.out.println(employeeService.updateEmployee(id2, sal));
				break;
			case 4:
				employeeService.getAllEmployeeDetails().forEach(e->System.out.println(e));
				break;
			case 5:System.out.println("Thank You");
			break;
			default:
				System.out.println("Enter valid choice");
			}
		}while(ch!=5);
	}

}
