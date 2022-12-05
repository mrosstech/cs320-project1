package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;

public class ContactServiceTest {
	private ContactService TestContactService = ContactService.getInstance();
	private String id1 = "";
	
	@Test
	public void testAddContact() {
		// Given Contact Service
		
		// When
		System.out.printf("Running add contact test...\n");
		id1 = TestContactService.addContact("michael", "ross", "4135528549", "4 bray ave");
		System.out.printf("Id: " + id1 + "\n");
		
		// Then
		assertTrue("Contact firstName not created properly!", TestContactService.getContactById(id1).getFirstName() == "michael");
		assertTrue("Contact lastName not created properly!", TestContactService.getContactById(id1).getLastName() == "ross");
		assertTrue("Contact address not created properly!", TestContactService.getContactById(id1).getAddress() == "4 bray ave");
		assertTrue("Contact phone not created properly!", TestContactService.getContactById(id1).getPhone() == "4135528549");
	}
	
	@Test
	public void testUpdateContact() {
		// Given Contact Service
		
		// When
		id1 = TestContactService.addContact("michael", "ross", "4135528549", "4 bray ave");
		System.out.printf("Running update contact test...\n");
		this.TestContactService.updateContactPhone(id1, "5555555555");
		
		// Then
		assertTrue("Contact phone number not changed!", TestContactService.getContactById(id1).getPhone() == "5555555555");
		this.TestContactService.updateContactFirstName(id1, "mark");
		assertTrue("Contact first name not changed!", TestContactService.getContactById(id1).getFirstName() == "mark");
		this.TestContactService.updateContactLastName(id1, "harmon");
		assertTrue("Contact last name not changed!", TestContactService.getContactById(id1).getLastName() == "harmon");
		this.TestContactService.updateContactAddress(id1, "5 main street");
		assertTrue("Contact address not changed!", TestContactService.getContactById(id1).getAddress() == "5 main street");
		
	}
	
	@Test
	public void testDeleteContact() {
		// Given
		// Contact Service
		
		// When
		id1 = TestContactService.addContact("michael", "ross", "4135528549", "4 bray ave");
		System.out.printf("Running delete contact test...\n");
		this.TestContactService.deleteContact(id1);
		
		// Then
		assertTrue("Contact not deleted!", TestContactService.getContactById(id1) == null);
	}
	
	@Test
	public void testUniqueIDs() {
		// Given
		// Contact service
		
		// When
		String testContact1 = TestContactService.addContact("michael", "ross", "4135528549", "4 bray ave");
		String testContact2 = TestContactService.addContact("michael", "ross", "4135528549", "4 bray ave");
		
		// Then
		assertTrue("Contact IDs not equal test, Failed! Expecting: True, Got False", TestContactService.getContactById(testContact1).getID() != TestContactService.getContactById(testContact2).getID());
	}
	


}
