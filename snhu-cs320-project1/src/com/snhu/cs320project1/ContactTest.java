package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactTest {
	Contact TestContact = new Contact("001", "Michael", "Ross", "4 Bray Ave", "555-555-5555");
	
	
	@Test
	public void testFirstNameLength() {
		TestContact.setFirstName("Abcdefghijk"); // 11 characters
		assertTrue("First name lenght greater than 10 characters", TestContact.getFirstName().length() < 11);
	}
	
	@Test
	public void testFirstNameNull() {
		TestContact.setFirstName(null);
		assertTrue("First name is null!", TestContact.getFirstName() != null);
	}
	
	@Test
	public void testLastNameLength() {
		TestContact.setLastName("Abcdefghijk"); // 11 characters
		assertTrue("First name lenght greater than 10 characters", TestContact.getFirstName().length() < 11);
	}
	
	@Test
	public void testLastNameNull() {
		TestContact.setLastName(null); // 11 characters
		assertTrue("Last name is null!", TestContact.getLastName() != null);
	}
	
	@Test
	public void testPhoneLengthTooLong() {
		TestContact.setPhone("12345678901");
		assertTrue("Phone number is not being padded properly! Got: " + TestContact.getPhone() + " Expecting: 1234567890", TestContact.getPhone().length() == 10);
	}
	
	@Test
	public void testPhoneLengthTooShort() {
		TestContact.setPhone("123456789");
		assertTrue("Phone number is not being padded properly! Got: " + TestContact.getPhone() + " Expecting 1234567890", TestContact.getPhone().length() == 10);
	}
	
	@Test
	public void testPhoneNull() {
		TestContact.setPhone(null);
		assertTrue("Phone number is null!", TestContact.getPhone() != null);
	}
	
	@Test
	public void testAddressLength() {
		TestContact.setAddress("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
		assertTrue("Address is too long!", TestContact.getAddress().length() < 31);
	}
	
	@Test
	public void testAddressNull() {
		TestContact.setAddress(null);
		assertTrue("Address is null!", TestContact.getAddress() != null);
	}
}
