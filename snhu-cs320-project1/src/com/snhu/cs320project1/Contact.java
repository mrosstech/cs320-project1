package com.snhu.cs320project1;

public class Contact {
	/*
		TODO: The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
		TODO: The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
		TODO: The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
		TODO: The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
		TODO: The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
	*/
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	// Class constructors
	public Contact(String thisId, String thisFirstName, String thisLastName, String thisPhone, String thisAddress) {
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
	
	private boolean checkId(String thisId) {
		
		return false;
	}
	
	private boolean checkFirstName(String thisId) {
		
		return false;
	}
	
	private boolean checkLastName(String thisId) {
		
		return false;
	}
	private boolean checkPhone(String thisId) {
		
		return false;
	}
	private boolean checkAddress(String thisId) {
		
		return false;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null) {
			firstName = " ";
		}
		this.firstName = firstName.substring(0,Math.min(firstName.length(), 10));
	}
	
	public void setLastName(String lastName) {
		if (lastName == null) {
			lastName = "";
		}
		this.lastName = lastName.substring(0,Math.min(lastName.length(), 10));;
	}
	
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
	
	public void setAddress(String address) {
		if (address == null) {
			address = "";
		}
		this.address = address.substring(0, Math.min(address.length(), 30));
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getID() {
		return this.id;
	}
	
	private String padRight(String s, int n) {
		return String.format("%1$" + n + "s", s).replace(" ", "*");
	}
}
