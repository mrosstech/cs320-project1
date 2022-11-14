package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactServiceTest {
	private ContactService TestContactService = ContactService.getInstance();
	
	@Test
	public void testSingleton() {
		
	}
	@Test
	public void testAddContact() {
		Integer id;
		id = this.TestContactService.addContact("michael", "ross", "4135528549", "4 bray ave");
		System.out.printf("Id: " + id.toString());
		assertTrue("Contact firstName not created properly!", TestContactService.getContactById(id.toString()).getFirstName() == "michael");
		assertTrue("Contact lastName not created properly!", TestContactService.getContactById(id.toString()).getLastName() == "ross");
		assertTrue("Contact address not created properly!", TestContactService.getContactById(id.toString()).getAddress() == "4 bray ave");
		assertTrue("Contact phone not created properly!", TestContactService.getContactById(id.toString()).getPhone() == "4135528549");
	}
	
	@Test
	public void testUpdateContact() {
		this.TestContactService.updateContactPhone("0", "5555555555");
		assertTrue("Contact phone number not changed!", TestContactService.getContactById("0").getPhone() == "5555555555");
		this.TestContactService.updateContactFirstName("0", "mark");
		assertTrue("Contact first name not changed!", TestContactService.getContactById("0").getFirstName() == "mark");
		this.TestContactService.updateContactLastName("0", "harmon");
		assertTrue("Contact last name not changed!", TestContactService.getContactById("0").getLastName() == "harmon");
		this.TestContactService.updateContactAddress("0", "5 main street");
		assertTrue("Contact address not changed!", TestContactService.getContactById("0").getAddress() == "5 main street");
		
	}
	
	@Test
	public void testDeleteContact() {
		this.TestContactService.deleteContact("0");
		assertTrue("Contact not deleted!", TestContactService.getContactById("0") == null);
	}
	


}
