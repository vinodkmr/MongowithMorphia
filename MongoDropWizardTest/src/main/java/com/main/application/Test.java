package com.main.application;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Test {
	
	public String name;
	
	public Test(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
