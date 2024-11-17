package com.client;

import java.util.List;
import java.util.Scanner;

import com.controller.EmpContoller;
import com.entity.Employee;


public class EmpClient {
public void getAllEmployee() {
		EmpContoller controller = new EmpContoller();
		List<Employee> allEmployee = controller.getAllEmployee();
		System.out.println(allEmployee);
	}

	public void insertEmployee() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Employee ID: ");
		int id = sc.nextInt();

		System.out.print("Enter Employee Name: ");
		String name = sc.next();

		System.out.print("Enter Employee Department: ");
		String dept = sc.next();

		System.out.print("Enter Employee Salary: ");
		int salary = sc.nextInt();

		System.out.print("Enter Employee Hiring Date: ");
		int hiringDate = sc.nextInt();

		System.out.print("Enter Employee Address: ");
		String address = sc.next();

		Employee emp = new Employee(id, name, dept, salary, hiringDate, address);
		EmpContoller controller = new EmpContoller();
		controller.insertEmployee(emp);

		System.out.println("Employee inserted successfully!");
	}

	public void deleteEmployee() {
		Scanner sc = new Scanner(System.in);
        EmpContoller controller = new EmpContoller();
        
        System.out.println("Enter Employee ID to delete:");
        int id = sc.nextInt();
        
        boolean success = controller.deleteEmployee(id);
        
        if (success) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee with the given ID not found.");
        }
    }
	
	// Method to update employee data
    public void updateEmployee() {
    	  Scanner sc = new Scanner(System.in);
          EmpContoller controller = new EmpContoller();
          
          System.out.println("Enter Employee ID to update:");
          int id = sc.nextInt();
          sc.nextLine(); // Consume newline
          
          System.out.println("Enter Employee Name:");
          String name = sc.nextLine();
          
          System.out.println("Enter Employee Dept:");
          String dept = sc.nextLine();
          
          System.out.println("Enter Employee Salary:");
          int salary = sc.nextInt();
          
          System.out.println("Enter Employee Hiring Date (year):");
          int hiringDate = sc.nextInt();
          sc.nextLine(); // Consume newline
          
          System.out.println("Enter Employee Address:");
          String address = sc.nextLine();
          
          Employee emp = new Employee(id, name, dept, salary, hiringDate, address);
          boolean success = controller.updateEmployee(emp);
          
          if (success) {
              System.out.println("Employee updated successfully.");
          } else {
              System.out.println("Employee with the given ID not found.");
          }
      }


	public static void main(String[] args) {

		EmpClient emp = new EmpClient();

		char ch;
		do {
			System.out.println("1.See All Employee");
			System.out.println("2.Insert Employee");
			System.out.println("3.Update Employee");
            System.out.println("4.Delete Employee");
            System.out.println("Enter Choice : ");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    emp.getAllEmployee();
                    break;
                case 2:
                	emp.insertEmployee();
                	break;
                case 3:
                    emp.updateEmployee();
                    break;
                case 4:
                    emp.deleteEmployee();
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
			System.out.println("Continue y/n");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}
}
