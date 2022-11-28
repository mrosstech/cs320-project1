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
	
	
	public Appointment(String newId, Date newDate, String newDescription) {
		this.id = validateId(newId);
		this.date = validateDate(newDate);
		this.description = validateDescription(newDescription);
	}
	public Date getDate() {
		return this.date;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setDate(Date newDate) {
		this.date = validateDate(newDate);
	}
	
	public void setDescription(String newDescription) {
		this.description = validateDescription(newDescription);
	}
	
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
	
	public String validateDescription(String newDescription) {
		if (newDescription == null) {
			newDescription = "";
		}
		if (newDescription.length() > 50) {
			newDescription = newDescription.substring(0,50);
		}
		return newDescription;
	}
	
	public String validateId(String newId) {
		if (newId == null) {
			newId = AppointmentService.generateId();
		}
		
		if (newId.length() > 10) {
			newId = AppointmentService.generateId();
		}
		return newId;
	}
}
