package com.test.beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Address {

	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@NotEmpty
	private String doorNo;
	@NotEmpty
	private String Street;
	@NotEmpty
	private String City;
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public Address(String doorNo, String street, String city) {
		super();
		this.doorNo = doorNo;
		Street = street;
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", Street=" + Street + ", City="
				+ City + "]";
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
}
