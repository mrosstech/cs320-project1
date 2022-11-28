package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AppointmentTest {
	
	Date yesterday = Date.from(Instant.now().minus(1, ChronoUnit.DAYS));
	String goodId = "ABCDEFGHIJ";
	String goodDescription = "Under fifty character description";
	

	@Test
	public void testAppointmentDateTooEarly() {
		// Given
		Date earlyDate = yesterday;
		Date today = new Date();
		Date runtime = Date.from(Instant.now().minus(1, ChronoUnit.MINUTES)); // Give the test 1 minute to run.
		
		// When
		Appointment testAppointment = new Appointment(this.goodId, earlyDate, goodDescription);
		
		// Then date should come back as todays date +- the time it took the test to run.
		assertTrue("Test: Check early date, Failed! Expecting " + today + " Got: " + testAppointment.getDate(), testAppointment.getDate().after(runtime));
	}
	
	@Test
	public void testAppointmentDateToday() {
		// Given
		Appointment testAppointment = new Appointment();
		Date runtime = Date.from(Instant.now().minus(1, ChronoUnit.MINUTES)); // Give the test 1 minute to run.
		
		
		// When
		Date todaysDate = new Date();
		testAppointment.setDate(todaysDate);
		
		// Then date should stay as todays date
		assertTrue("Test: Check todays date, Failed! Expecting " + todaysDate + " Got: " + testAppointment.getDate(), testAppointment.getDate().after(runtime) );
	}
	
	@Test
	public void testDateNull() {
		// Given
		Appointment testAppointment = new Appointment();
		Date runtime = Date.from(Instant.now().minus(1, ChronoUnit.MINUTES)); // Give the test 1 minute to run.
		
		// When
		Date newDate = null;
		Date todaysDate = new Date();
		testAppointment.setDate(newDate);
		
		// Then date should be todays date
		assertTrue("Test: Check null date, Failed! Expecting " + todaysDate + " Got: " + testAppointment.getDate(), testAppointment.getDate().after(runtime) );
	}
	
	@Test
	public void testDescriptionTooLong() {
		// Given
		Appointment testAppointment = new Appointment();
		
		// When
		String longDescription = "Description clearly over fifty characters right here. Definitely"; // 64 characters
		testAppointment.setDescription(longDescription);
		String truncatedDescription = "Description clearly over fifty characters right he";
		
		// Then description should be truncated to 50 characters
		assertTrue("Test: Check description too long, Failed! Expecting " + truncatedDescription + " Got: " + testAppointment.getDescription(), truncatedDescription.equals(testAppointment.getDescription()) );
	}
	
	@Test
	public void testDescriptionNull() {
		// Given
		Appointment testAppointment = new Appointment();
		
		// When
		String nullDescription = null;
		testAppointment.setDescription(nullDescription);
		String emptyDescription = "";
		
		// Then description should be a blank string
		assertTrue("Test: Check description null, Failed! Expecting '" + emptyDescription + "' Got: '" + testAppointment.getDescription() + "'", emptyDescription == testAppointment.getDescription());
		
	}
}
