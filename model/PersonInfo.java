
/**
 * 
 * UC-1 This is PersonInfo class model for address book here getter and setter is
 *  used to get and set the value of a address book user.
 * 
 * 
 */


package com.bridgelabz.JavaPractice.model;

public class PersonInfo {

	private String lastName;
	private String address;
	private String city;
	private String state;
	private String email;
	private int zipcode;
	private long phoneNumber;	
	private String firstName;
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String toString() {
        return "PersonInfo{" + " firstName= " + firstName + ", lastName= " + lastName + ", address= " + address + ", city= " + city + ", state= " + state + ", email= " + email + ", phoneNumber= " + phoneNumber + '}';
    }
	
}	

