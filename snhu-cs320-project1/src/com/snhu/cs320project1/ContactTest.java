package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactTest {
	Contact TestContact = new Contact("001", "Michael", "Ross", "4 Bray Ave", "555-555-5555");
	
	
	@Test
	public void testFirstNameLength() {
		// When 
		TestContact.setFirstName("Abcdefghijk"); // 11 characters
		
		// Then
		assertTrue("First name lenght greater than 10 characters", TestContact.getFirstName().length() < 11);
	}
	
	@Test
	public void testFirstNameNull() {
		// When
		TestContact.setFirstName(null);
		
		// Then
		assertTrue("First name is null!", TestContact.getFirstName() != null);
	}
	
	@Test
	public void testLastNameLength() {
		// When
		TestContact.setLastName("Abcdefghijk"); // 11 characters
		
		// Then
		assertTrue("First name lenght greater than 10 characters", TestContact.getFirstName().length() < 11);
	}
	
	@Test
	public void testLastNameNull() {
		// When
		TestContact.setLastName(null); // 11 characters
		
		// Then
		assertTrue("Last name is null!", TestContact.getLastName() != null);
	}
	
	@Test
	public void testPhoneLengthTooLong() {
		// When
		TestContact.setPhone("12345678901");
		
		// Then
		assertTrue("Phone number is not being padded properly! Got: " + TestContact.getPhone() + " Expecting: 1234567890", TestContact.getPhone().length() == 10);
	}
	
	@Test
	public void testPhoneLengthTooShort() {
		// When
		TestContact.setPhone("123456789");
		
		// Then
		assertTrue("Phone number is not being padded properly! Got: " + TestContact.getPhone() + " Expecting 1234567890", TestContact.getPhone().length() == 10);
	}
	
	@Test
	public void testPhoneNull() {
		// When
		TestContact.setPhone(null);
		
		// Then
		assertTrue("Phone number is null!", TestContact.getPhone() != null);
	}
	
	@Test
	public void testAddressLength() {
		// When
		TestContact.setAddress("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
		
		// Then
		assertTrue("Address is too long!", TestContact.getAddress().length() < 31);
	}
	
	@Test
	public void testAddressNull() {
		// When
		TestContact.setAddress(null);
		
		// Then
		assertTrue("Address is null!", TestContact.getAddress() != null);
	}
}
