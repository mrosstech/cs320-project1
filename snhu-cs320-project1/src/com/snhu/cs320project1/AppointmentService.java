package com.snhu.cs320project1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;



public class AppointmentService {
	
	
	private ArrayList<Appointment> appointmentDB = new ArrayList<Appointment>();
	
	
	private AppointmentService() {
		// This class needs to be a singleton to ensure that the IDs for the created appointments are unique.
	}
	
	private static class SingletonHelper {
		private static final AppointmentService INSTANCE = new AppointmentService();
	}
	
	public static AppointmentService getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	/* Adds a new appointment
	 *   Inputs: name, description
	 *   Returns: id of created task
	 */
	public String addAppointment(Date date, String description) {
		String id = generateID();
		appointmentDB.add(new Appointment(id, date, description));
		return id;
	}
	
	public void deleteAppointment(String id) {
		Integer index = getAppointmentIndexByID(id);
		if (index != null) {
			appointmentDB.remove(index.intValue());
		}
	}
	
	
	/* Updates the name field of an existing appointment object
	 *   Inputs: id of an existing appointment, new name field
	 *   Returns: Updated appointment object or null if no appointment was
	 *   found with that id.
	 */
	public Appointment updateAppointmentDate(String id, Date date) {
		Integer index = getAppointmentIndexByID(id);
		if (index != null) {
			int intIndex = index.intValue();
			Appointment updatedAppointment = appointmentDB.get(intIndex);
			updatedAppointment.setDate(date);
			appointmentDB.set(intIndex, updatedAppointment);
			return updatedAppointment;
		}
		return null;
	}
	
	/* Updates the description field of an existing Task object
	 *   Inputs: id of an existing task, new description field
	 *   Returns: Updated ask object or null if no task was
	 *   found with that id.
	 */
	public Appointment updateAppointmentDescription(String id, String description) {
		Integer index = getAppointmentIndexByID(id);
		if (index != null) {
			int intIndex = index.intValue();
			Appointment updatedAppointment = appointmentDB.get(intIndex);
			updatedAppointment.setDescription(description);
			appointmentDB.set(intIndex, updatedAppointment);
			return updatedAppointment;
		}
		return null;
	}	
	
	
	/* Gets an appointment given a valid ID
	 *   Inputs: id of an existing appointment
	 *   Returns: Appointment object or null if no
	 *   appointment is found
	 */
	public Appointment getAppointmentById(String id) {
		Integer index = getAppointmentIndexByID(id);
		if (index != null) {
			return appointmentDB.get(index.intValue());
		}
		return null;
	}	
	
	
	
	/* Returns the index of an appointment in the DB given a
	 * valid appointment ID
	 *   Inputs: id of an existing appointment
	 *   Returns: index of the appointment in the DB or null
	 *   if no valid appointment was found.
	 */
	private Integer getAppointmentIndexByID(String id) {
		for (Integer i = 0; i < appointmentDB.size(); i++) {
			if (appointmentDB.get(i).getID() == id) {
				return i;
			}
		}
		return null;
	}

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
