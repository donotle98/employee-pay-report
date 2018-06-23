package com.acme.payroll.model;

import com.acme.payroll.UserInput;

public class CommissionEmployee extends Employee{

	private double weeklySales;
	private double calculatedPay;

	public CommissionEmployee(String name) {
		super(name);
		this.setEmployeeType("Commissioned");
	}

	public CommissionEmployee(UserInput input) {
		this(input.getName());
		this.weeklySales = input.getWeeklyMadeSales(calculatedPay);
	}

	public double getWeeklySales() {
		return this.weeklySales;
	}

	@Override
	public double calculateWeeklyPay() {
		double calculatedPay = (weeklySales * .2); 
		return calculatedPay;
	}

}
