package com.snhu.cs320project1;

import java.util.Date;

public class Appointment {
/*
	The appointment object shall have a required unique appointment ID string that cannot be longer than 10 characters. The appointment ID shall not be null and shall not be updatable.
	The appointment object shall have a required appointment Date field. The appointment Date field cannot be in the past. The appointment Date field shall not be null.
	Note: Use java.util.Date for the appointmentDate field and use before(new Date()) to check if the date is in the past.
	The appointment object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
*/
	private String id;
	private Date date;
	private String description;
	
	// Default constructor
	public Appointment() {
		this.id = validateId(null);
		this.date = validateDate(null);
		this.description = validateDescription(null);
	}
	
	// Overloaded constructor
	public Appointment(String newId, Date newDate, String newDescription) {
		this.id = validateId(newId);
		this.date = validateDate(newDate);
		this.description = validateDescription(newDescription);
	}
	
	// Returns the date of the appointment.
	public Date getDate() {
		return this.date;
	}
	
	// Returns the description of the appointment
	public String getDescription() {
		return this.description;
	}
	
	// Returns the ID of the appointment
	public String getID() {
		return this.id;
	}
	
	// Sets the value of the Date.
	//   Expects a date value
	//   Returns nothing
	public void setDate(Date newDate) {
		this.date = validateDate(newDate);
	}
	
	
	// Sets the description of the Appointment object
	//   Expects a string
	//   Returns nothing.
	public void setDescription(String newDescription) {
		this.description = validateDescription(newDescription);
	}
	
	// Validates the date provided.
	//   Expects: Date value
	//   Returns: Validated date value
	public Date validateDate(Date newDate) {
		Date today = new Date();
		if (newDate == null) {
			newDate = today;
		}
		if (newDate.before(today)) {
			newDate = today;
		}		
		return newDate;
	}
	
	// Validates the description provided.
	//   Expects: Description
	//   Returns: Validated description value
	public String validateDescription(String newDescription) {
		if (newDescription == null) {
			newDescription = "";
		}
		if (newDescription.length() > 50) {
			newDescription = newDescription.substring(0,50);
		}
		return newDescription;
	}
	
	// Validates the ID provided.
	//    Expects: ID string
	//    Returns: Validated ID string.  Generates new ID if a blank, null or invalid 
	//             id is provided.
	public String validateId(String newId) {
		if (newId == null) {
			newId = AppointmentService.generateID();
		}
		
		if (newId.length() > 10) {
			newId = AppointmentService.generateID();
		}
		return newId;
	}
}
