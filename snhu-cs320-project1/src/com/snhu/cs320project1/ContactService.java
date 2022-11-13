package com.snhu.cs320project1;

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
	
	private Contact [] contactsDB;
	
	private ContactService() {
		// This class needs to be a singleton to ensure that the IDs for the created contacts are unique.
	}
	
	private static class SingletonHelper {
		private static final ContactService INSTANCE = new ContactService();
	}
	
	public static ContactService getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public boolean addContact(String firstName, String lastName, String phone, String address) {
		
		return false;
	}
	
	public boolean updateContact(String ID, String firstName, String lastName, String phone, String address) {
		
		return false;
	}
	
	public boolean deleteContact(String ID) {
		
		return false;
	}
	
}
