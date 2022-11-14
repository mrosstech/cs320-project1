package com.snhu.cs320project1;

import java.util.ArrayList;

public class ContactService {
	/*
		TODO: The contact service shall be able to add contacts with a unique ID.
		TODO: The contact service shall be able to delete contacts per contact ID.
		TODO: The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
			firstName
			lastName
			Number
			Address
	 */
	private Integer idStart = 0;
	private Integer id = idStart;
	
	private ArrayList<Contact> contactDB = new ArrayList<Contact>() ;
	
	
	
	
	private ContactService() {
		// This class needs to be a singleton to ensure that the IDs for the created contacts are unique.
	}
	
	private static class SingletonHelper {
		private static final ContactService INSTANCE = new ContactService();
	}
	
	public static ContactService getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public Integer addContact(String firstName, String lastName, String phone, String address) {
		Contact newContact = new Contact(id.toString(), firstName, lastName, phone, address);
		contactDB.add(newContact);
		this.id++;
		return this.id - 1;
	}
	
	public boolean updateContactFirstName(String ID, String firstName) {
		Integer numId = Integer.parseInt(ID);
		Contact tempContact = new Contact();
		if (numId > this.contactDB.size()) {
			return false;
		}
		
		tempContact.setLastName(contactDB.get(numId).getLastName());
		tempContact.setAddress(contactDB.get(numId).getAddress());
		tempContact.setPhone(contactDB.get(numId).getPhone());
		tempContact.setFirstName(firstName);
		
		contactDB.set(numId, tempContact);
		return true;
	}
	
	public boolean updateContactLastName(String ID, String lastName) {
		Integer numId = Integer.parseInt(ID);
		Contact tempContact = new Contact();
		if (numId > this.contactDB.size()) {
			return false;
		}
		
		tempContact.setFirstName(contactDB.get(numId).getFirstName());
		tempContact.setAddress(contactDB.get(numId).getAddress());
		tempContact.setPhone(contactDB.get(numId).getPhone());
		tempContact.setLastName(lastName);
		
		contactDB.set(numId, tempContact);
		return true;
	}
	
	public boolean updateContactPhone(String ID, String phone) {
		Integer numId = Integer.parseInt(ID);
		Contact tempContact = new Contact();
		if (numId > this.contactDB.size()) {
			return false;
		}
		
		tempContact.setLastName(contactDB.get(numId).getLastName());
		tempContact.setAddress(contactDB.get(numId).getAddress());
		tempContact.setFirstName(contactDB.get(numId).getFirstName());
		tempContact.setPhone(phone);
		
		contactDB.set(numId, tempContact);
		return true;
	}
	
	public boolean updateContactAddress(String ID, String address) {
		Integer numId = Integer.parseInt(ID);
		Contact tempContact = new Contact();
		if (numId > this.contactDB.size()) {
			return false;
		}
		
		tempContact.setLastName(contactDB.get(numId).getLastName());
		tempContact.setFirstName(contactDB.get(numId).getFirstName());
		tempContact.setPhone(contactDB.get(numId).getPhone());
		tempContact.setAddress(address);
		
		contactDB.set(numId, tempContact);
		return true;
	}
	public boolean deleteContact(String ID) {
		Integer numId = Integer.parseInt(ID);
		if(numId > this.contactDB.size()) {
			return false;
		}
		contactDB.remove(numId);
		return true;
	}
	
	public Contact getContactById(String ID) {
		return contactDB.get(Integer.parseInt(ID));
	}
	
}
