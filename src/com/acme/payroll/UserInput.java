package com.acme.payroll;

public class UserInput {

	private String employeeType;
	private String name;
	private double hoursWorked;
	private double rate;
	private double weeklyMadeSales;
	private double salaryMonthly;


	public UserInput(String employeeType, String name) {
		this.name = name; 
		this.employeeType = employeeType;
	}

	public UserInput() {
		// TODO Auto-generated constructor stub
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType.toLowerCase();	
	}	
	public String getEmployeeType() {
		return this.employeeType;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public void setSalaryPaid(double salaryPaid) {

	}
	public void getSalaryPaird(double salaryPaid) {
	}
	
	
	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;	
	}
	public double getHoursWorked() {
		return this.hoursWorked;	
	}
	
	
	public void setHourlyPaid(double hourlyPaid) {	
	}
	public void getHourlyPaid(double hourlyPaid) {	
	}
	
	
	public void setWeeklySales(double weeklySales) {
	}
	public double getWeeklySales(double weeklySales) {
		return weeklySales;
	}

	public void setRate(double rate) {
		this.rate = rate;
		
	}
	public double getRate() {
		return this.rate;
	}

	
	
	public void setWeeklyMadeSales(double weeklyMadeSales) {
		this.weeklyMadeSales = weeklyMadeSales;
	}
	public double getWeeklyMadeSales(double calculatedPay) {
		return this.weeklyMadeSales;
	}

	public double getSalaryMonthly() {
		return salaryMonthly;
	}

	public void setSalaryMonthly(double salaryMonthly) {
		this.salaryMonthly = salaryMonthly;
	}
}
