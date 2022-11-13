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
		
	}
	
	public Contact() {
		
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
}
