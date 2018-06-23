package com.acme.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.acme.payroll.model.CommissionEmployee;
import com.acme.payroll.model.Employee;
import com.acme.payroll.model.HourlyEmployee;
import com.acme.payroll.model.SalaryEmployee;
import com.acme.payroll.reports.*;

public class App {

	public static void main(String[] args) {
		// --------------------------------------------------------------------
		// 1) Get the user input
		List<UserInput> allUserInput = new ArrayList<>();
		//getUserInput(allUserInput);
		getUserInputImproved(allUserInput);
		//useDummyData(allUserInput);
		
		// --------------------------------------------------------------------
		// 2) Create the employee(s)
		List<Employee> employees = new ArrayList<>();
		
		// spin through the usrInput collection and for all userInput objects, create an employee and slam it into employees all by calling 
		// registerEmployee
		allUserInput.stream().forEach(usersInput -> {
			registerEmployee(usersInput, employees);
		});
		
		// --------------------------------------------------------------------
		// 3) Report the employee's salaries
		SimplePayrollReport.printReport(employees);
	}

	private static void getUserInputImproved(List<UserInput> allUserInput) {
		boolean loop = true;
		Scanner scan = new Scanner(System.in);
		while(loop) {
			UserInput userInput = new UserInput();
			System.out.println("Enter the name:");
			String name = scan.next();
			userInput.setName(name);
			System.out.println("Enter the type of employee:");
			String employeeType = scan.next();
			userInput.setEmployeeType(employeeType);

			// SALARY
			if (employeeType.toLowerCase().equals("salary")) {
				userInput.setEmployeeType("salary");
				System.out.print("How much does " + userInput.getName() + " get paid per month?");
				double monthlySalary = scan.nextInt();
				userInput.setSalaryMonthly(monthlySalary);	
			}
			// HOURLY 
			else if (employeeType.toLowerCase().equals("hourly")) {
				userInput.setEmployeeType("hourly");
				System.out.println("How much does " + userInput.getName() + " get paid per hour?");
				double rate = scan.nextDouble();
				userInput.setRate(rate);
				System.out.println("How many hours a week does " + userInput.getName() + " work?");
				double hoursWorked = scan.nextDouble();
				userInput.setHoursWorked(hoursWorked);
			} 
			// COMMISION
			else if (employeeType.toLowerCase().equals("commission")) {
				userInput.setEmployeeType("commission");
				System.out.print("How much did " + userInput.getName() + " make this week?");
				double weeklySales = scan.nextDouble();
				userInput.setWeeklyMadeSales(weeklySales);
			}
			
			
			allUserInput.add(userInput);
			
			System.out.println("Do you want to add a new employee? true or false");

			loop = scan.nextBoolean();
			scan.close();

		}
	}

	private static void registerEmployee(UserInput input, List<Employee> employees) {		
		if (input.getEmployeeType().equals("hourly")) {
			HourlyEmployee emp = new HourlyEmployee(input.getName(), input.getHoursWorked(), input.getRate() );
			employees.add(emp);
		}
		if (input.getEmployeeType().equals("salary")) {
			SalaryEmployee emp = new SalaryEmployee(input);
			emp.setBonus(.1);
			employees.add(emp);
		}
		if(input.getEmployeeType().equals("commission")) {
			CommissionEmployee emp = new CommissionEmployee(input);			
			employees.add(emp);
		}
	}
}
