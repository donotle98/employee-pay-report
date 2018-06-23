package com.acme.payroll.model;

public class HourlyEmployee extends Employee {

	private double hoursPerWeek;
	private double rate;
	public HourlyEmployee(String name, double hoursPerWeek, double rate) {
		super(name);	
		this.setEmployeeType("Hourly");
		this.hoursPerWeek = hoursPerWeek; 
		this.setRate(rate); 
	}

	public double getHoursPerWeek() {
		return this.hoursPerWeek;
	}
	
	public void setHoursPerWeek(double hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double calculateWeeklyPay() {
		double calculatedPay = hoursPerWeek * rate;
		if (hoursPerWeek > 40) {
			calculatedPay = ((rate * 2) * (hoursPerWeek - 40)) + (40 * rate);
		}
		return calculatedPay;
	}

}
