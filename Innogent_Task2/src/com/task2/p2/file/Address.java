package com.task2.p2.file;
class Address {

int 	id;
int     pin_code;
String  city;
int     student_id;

public Address() {
		// TODO Auto-generated constructor stub
	}


public Address(int id, int pin_code, String city, int student_id) {
	super();
	this.id = id;
	this.pin_code = pin_code;
	this.city = city;
	this.student_id = student_id;
}



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getPin_code() {
	return pin_code;
}


public void setPin_code(int pin_code) {
	this.pin_code = pin_code;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public int getStudent_id() {
	return student_id;
}


public void setStudent_id(int student_id) {
	this.student_id = student_id;
}


@Override
	public String toString() {
		return "Address [id=" + id + ", pin_code=" + pin_code + ", city=" + city + ", student_id=" + student_id + "]";
	}
}