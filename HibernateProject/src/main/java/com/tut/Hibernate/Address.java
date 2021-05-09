package com.tut.Hibernate;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="Student_Address")
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Address_id")
 private int address_id;
	
	@Column(length = 50,name="Street")
 private String street;
	
	@Column(length = 50,name="City")
 private String city;
 
	@Column(name="Is_Ture")
 private Boolean isOpen;
 
	@Transient
 private double x;
	
	@Column(name="Added_Date")
	@Temporal(TemporalType.DATE)
 private Date addedDate;
	
	@Lob
 private byte[] image;
 
public Address() {
	
}

public Address(int address_id, String street, String city, Boolean isOpen, double x, Date addedDate, byte[] image) {
	super();
	this.address_id = address_id;
	this.street = street;
	this.city = city;
	this.isOpen = isOpen;
	this.x = x;
	this.addedDate = addedDate;
	this.image = image;
}

public int getAddress_id() {
	return address_id;
}

public void setAddress_id(int address_id) {
	this.address_id = address_id;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public Boolean getIsOpen() {
	return isOpen;
}

public void setIsOpen(Boolean isOpen) {
	this.isOpen = isOpen;
}

public double getX() {
	return x;
}

public void setX(double x) {
	this.x = x;
}

public Date getAddedDate() {
	return addedDate;
}

public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

@Override
public String toString() {
	return "Address [address_id=" + address_id + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen + ", x="
			+ x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
}

 
}
