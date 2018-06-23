package com.acme.payroll.reports;

import java.util.List;
import java.util.stream.Collectors;

import com.acme.payroll.model.CommissionEmployee;
import com.acme.payroll.model.Employee;
import com.acme.payroll.model.HourlyEmployee;
import com.acme.payroll.model.SalaryEmployee;

public class SimplePayrollReport {

	public static void printReport(List<Employee> employees) {
		if (employees.isEmpty()) {
			System.out.println("Missing Employees");
			return;
		}
		double total = employees.stream()
				.mapToDouble(emp ->  emp.calculateWeeklyPay())
				.sum();
		
		System.out.println("Name \t\tClass\t\tHours\tSales\tRate\tWeekly Pay");
		System.out.println("=================================================================================");
		employees.stream().forEach(emp -> {
			String reportRow = "Employee Type Unknow\n";
			if (emp instanceof SalaryEmployee) {	
				reportRow = generateSalaryRow((SalaryEmployee)emp);
			} 
			if (emp instanceof HourlyEmployee) {
				reportRow = generateHourlyRow((HourlyEmployee)emp);
			}
			
			if (emp instanceof CommissionEmployee) {
				reportRow = generateCommissionRow((CommissionEmployee)emp);
			}
			
			System.out.print(reportRow);	
		});
		
		System.out.println("=================================================================================");
		System.out.println("TOTAL " + total);
		System.out.println("*A 10% bonus is awarded\n");
	}

	private static String generateCommissionRow(CommissionEmployee emp) {
		StringBuffer sb = new StringBuffer();
		sharedReportPortion(emp, sb);
		sb.append("$" + emp.getWeeklySales());
		sb.append("\t\t");
		sb.append("$" + emp.calculateWeeklyPay());
		sb.append("\n");
		return sb.toString();
	}

	private static String generateHourlyRow(HourlyEmployee emp) {
		StringBuffer sb = new StringBuffer();
		sharedReportPortion(emp, sb);
		sb.append(emp.getHoursPerWeek());
		sb.append("\t\t");
		sb.append("$" + emp.getRate());
		sb.append("\t");
		sb.append("$" + emp.calculateWeeklyPay());
		sb.append("\n");

		
		return sb.toString();
	}

	private static void sharedReportPortion(Employee emp, StringBuffer sb) {
		sb.append(String.format("%-14s", emp.getName() )); //.replace(' ', ' ') + "\t");
		sb.append(emp.getEmployeeType() + " \t\t");
	}

	private static String generateSalaryRow(SalaryEmployee emp) {
		StringBuffer sb = new StringBuffer();
		double bonus = emp.getBonus();
		
		sharedReportPortion(emp, sb);
		sb.append("\t\t\t");
		sb.append("$" + emp.calculateWeeklyPay());
		if(bonus != 0) {
			sb.append("*");
		}
		
		sb.append("\t");
		sb.append("\n");
			
		return sb.toString();
	}

}
