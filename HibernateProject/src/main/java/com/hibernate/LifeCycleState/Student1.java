package com.hibernate.LifeCycleState;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student1 
{
	@Id
	private int id;
	private String name; 
	private String city;
	
	private Certificate1 certificate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Certificate1 getCerti() {
		return certificate;
	}

	public void setCerti(Certificate1 certi) {
		this.certificate = certi;
	}

	
	
	
}
