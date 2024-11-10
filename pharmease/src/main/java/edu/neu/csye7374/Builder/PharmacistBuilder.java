package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Factory.PharmacistFactory;
import edu.neu.csye7374.Pharmacist;

public class PharmacistBuilder extends Pharmacist implements BuilderAPI<Pharmacist> {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public PharmacistBuilder(int id, String firstName, String lastName, int age, double salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public Pharmacist buildObject() {
		return PharmacistFactory.getInstance().getObject(this);
	}
}
