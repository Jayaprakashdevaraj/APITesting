package week4.day1;

import java.util.ArrayList;

public class EmployeeDetails {
	private String name;
	private String job;
	private double salary;
	private EmpAddress empAddress;
	private ArrayList<String> bank;
	private boolean married;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public EmpAddress getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(EmpAddress empAddress) {
		this.empAddress = empAddress;
	}
	public ArrayList<String> getBank() {
		return bank;
	}
	public void setBank(ArrayList<String> bank) {
		this.bank = bank;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}

}
