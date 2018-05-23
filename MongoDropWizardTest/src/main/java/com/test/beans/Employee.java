package com.test.beans;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.utils.IndexType;



@Entity
@Indexes(   @Index(fields = @Field(value = "name", type = IndexType.TEXT)))	    
public class Employee {

	Employee(){
		
	}
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String age;
	
	@NotEmpty
	private String designation;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	@NotNull
	@Reference
	private Address address;
	

	public Employee(String name, String age, String designation,Address address) {
		super();
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.address = address;
	}

	public String getName() {
		return name;
	}



	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", designation="
				+ designation + "]";
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
