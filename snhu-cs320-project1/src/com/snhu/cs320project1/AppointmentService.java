package com.snhu.cs320project1;

import java.util.ArrayList;
import java.util.Random;

public class AppointmentService {
	
	
	private ArrayList<Appointment> appointmentDB = new ArrayList<Appointment>();

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
