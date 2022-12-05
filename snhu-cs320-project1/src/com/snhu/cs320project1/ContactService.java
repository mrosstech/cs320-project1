package com.snhu.cs320project1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;

public class ContactService {
	/*
		The contact service shall be able to add contacts with a unique ID.
		The contact service shall be able to delete contacts per contact ID.
		The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
			firstName
			lastName
			Number
			Address
	 */
	
	private ArrayList<Contact> contactDB = new ArrayList<Contact>() ;
	
	
	private ContactService() {
		// This class needs to be a singleton to ensure that the IDs for the created contacts are unique.
	}
	
	public static class SingletonHelper {
		private static final ContactService INSTANCE = new ContactService();
	}
	
	public static ContactService getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	
	// Adds a new Contact
	//   Expects: String firstName
	//			  String lastName
	//			  String phone
	//			  String address
	//   Returns: ID string for the new entry.
		
	public String addContact(String firstName, String lastName, String phone, String address) {
		String id = generateID();
		System.out.printf("Generated ID: " + id + "\n");
		Contact newContact = new Contact(id, firstName, lastName, phone, address);
		contactDB.add(newContact);
		System.out.printf("added object: " + newContact + "\n");
		return id;
	}
	
	
	// Updates an existing contact first name
	//   Expects: String ID
	//            String firstName
	// 	 Returns: True if contact was updated, False if contact could not be found
	public boolean updateContactFirstName(String ID, String firstName) {
		Contact tempContact = new Contact();
		Integer index = getContactIndexByID(ID);
		
		if (index != null) {
			tempContact = contactDB.get(index);
			tempContact.setFirstName(firstName);
			contactDB.set(index, tempContact);
			return true;
		}
		return false;
	}

	// Updates an existing contact last name
	//   Expects: String ID
	//            String lastName
	// 	 Returns: True if contact was updated, False if contact could not be found
	public boolean updateContactLastName(String ID, String lastName) {
		Contact tempContact = new Contact();
		Integer index = getContactIndexByID(ID);
		
		if (index != null) {
			tempContact = contactDB.get(index);
			tempContact.setLastName(lastName);
			contactDB.set(index, tempContact);
			return true;
		}
		return false;
	}

	// Updates an existing contact phone number
	//   Expects: String ID
	//            String phone
	// 	 Returns: True if contact was updated, False if contact could not be found
	public boolean updateContactPhone(String ID, String phone) {
		Contact tempContact = new Contact();
		Integer index = getContactIndexByID(ID);
		
		if (index != null) {
			tempContact = contactDB.get(index);
			tempContact.setPhone(phone);
			contactDB.set(index, tempContact);
			return true;
		}
		return false;
	}
	
	
	// Updates an existing contact address
	//   Expects: String ID
	//            String address
	// 	 Returns: True if contact was updated, False if contact could not be found
	public boolean updateContactAddress(String ID, String address) {
		Contact tempContact = new Contact();
		Integer index = getContactIndexByID(ID);
		
		if (index != null) {
			tempContact = contactDB.get(index);
			tempContact.setAddress(address);
			contactDB.set(index, tempContact);
			return true;
		}
		return false;

	}

	// Deletes an existing contact
	//   Expects: String ID
	//   Returns: True if contact was updated, False if contact could not be found
	public boolean deleteContact(String ID) {
		Integer index = getContactIndexByID(ID);
		if (index != null) {
			contactDB.remove(index.intValue());
			return true;
		}
		return false;
	}
	
	// Finds a contact by ID in the contactDB
	//   Expects: String id
	//   Returns: Contact object of found contact.
	public Contact getContactById(String id) {
		Integer index = getContactIndexByID(id);
		if (index != null) {
			return contactDB.get(index.intValue());
		}
		return null;
	}
	
	// Gets the index of the contact in the contact db with the given id.
	//   Expects: String id
	//   Returns: The index of the found contact or null if not found.
	private Integer getContactIndexByID(String id) {
		for (Integer i = 0; i < contactDB.size(); i++) {
			System.out.printf("Searching for id: " + id + " at index " + i + "\n");
			System.out.printf("Comparing: " + id + " with: " + contactDB.get(i.intValue()).getID() + "\n");
			if (contactDB.get(i).getID() == id) {
				System.out.printf("Found id: " + id + " at index " + i + "\n");
				return i;
			}
		}
		return null;
	}
	
	// Generates a random ID string of 10 characters
	// consisting of alphanumeric characters.
	public static String generateID() {
		
		/* From https://www.baeldung.com/java-random-string */
		String id = "";
		Random random = new Random();
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    
	    
	    id = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
		return id;
	}
	
}
