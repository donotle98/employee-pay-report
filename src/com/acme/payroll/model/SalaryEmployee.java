package com.acme.payroll.model;

import com.acme.payroll.UserInput;

public class SalaryEmployee extends Employee {

	private double bonus = 0;
	private double monthlySalary;

	public SalaryEmployee(String name) {
		super(name);
		this.setEmployeeType("Salary");
		}

	public SalaryEmployee(UserInput input) {
		this(input.getName());
		this.monthlySalary = input.getSalaryMonthly();
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public double calculateWeeklyPay() {
		double calculatedPay = monthlySalary / 4;

		if (bonus != 0) {
			calculatedPay = ((monthlySalary * bonus) + monthlySalary) / 4 ; 
		}
		return calculatedPay;
	}
}
