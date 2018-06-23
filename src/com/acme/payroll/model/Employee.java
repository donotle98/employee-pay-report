package com.acme.payroll.model;

public abstract class Employee {

	private String name;
	private String employeeType;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	
	public String getEmployeeType() {
		return this.employeeType;
	}

	public abstract double calculateWeeklyPay();
}
