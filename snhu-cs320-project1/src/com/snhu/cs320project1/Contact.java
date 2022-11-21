package com.snhu.cs320project1;

public class Contact {

	
	// Initialize the private members of the class.
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	// Class constructors
	public Contact(String thisId, String thisFirstName, String thisLastName, String thisPhone, String thisAddress) {
		this.id = thisId;
		this.setFirstName(thisFirstName);
		this.setLastName(thisLastName);
		this.setPhone(thisPhone);
		this.setAddress(thisAddress);
	}
	
	public Contact() {
		this.id = "";
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.address = "";
	}
	
	// Sets the first name of a contact object.  Expects:
	//	firstName as a String.
	// No outputs
	public void setFirstName(String firstName) {
		if (firstName == null) {
			firstName = " ";
		}
		this.firstName = firstName.substring(0,Math.min(firstName.length(), 10));
	}
	
	// Sets the last name of a contact object.  Expects:
	//	lastName as a String.
	// No outputs
	public void setLastName(String lastName) {
		if (lastName == null) {
			lastName = "";
		}
		this.lastName = lastName.substring(0,Math.min(lastName.length(), 10));;
	}
	
	// Sets the phone number of a contact object.  Expects:
	// 	phone as a string
	// No outputs.
	public void setPhone(String phone) {
		if (phone == null) {
			phone = "";
		}
		if (phone.length() > 10) {
			this.phone = phone.substring(0, 10);
		} else if (phone.length() < 10) {
			this.phone = this.padRight(phone, 10);
		} else {
			this.phone = phone;
		}
	}
	
	// Sets the address of a contact object. Expects:
	// 	address as a string
	// No outputs.
	public void setAddress(String address) {
		if (address == null) {
			address = "";
		}
		this.address = address.substring(0, Math.min(address.length(), 30));
	}
	
	// Returns the first name of a contact object.
	public String getFirstName() {
		return this.firstName;
	}
	
	//  Returns the last name of a contact object.
	public String getLastName() {
		return this.lastName;
	}
	
	// Returns the phone number of a contact object.
	public String getPhone() {
		return this.phone;
	}
	
	// Returns the address of a contact object.
	public String getAddress() {
		return this.address;
	}
	
	// Returns the ID of a contact object.
	public String getID() {
		return this.id;
	}
	
	// Pads a string to a specific length:
	//  n - the length desired
	//  s - the original string
	private String padRight(String s, int n) {
		return String.format("%1$" + n + "s", s).replace(" ", "*");
	}
}
