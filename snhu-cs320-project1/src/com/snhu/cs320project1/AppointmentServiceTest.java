package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AppointmentServiceTest {
	
	Date goodDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
	Date newDate = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
	String goodDescription = "Under fifty character description";
	String newDescription = "New under fifty character description";

	@Test
	public void testUniqueIds() {
		// Given
		AppointmentService testService = AppointmentService.getInstance();
		
		// When
		String testAppointment1 = testService.addAppointment(this.goodDate, this.goodDescription);
		String testAppointment2 = testService.addAppointment(this.goodDate,  this.goodDescription);
	
		// Then the first appointment id should not equal the second appointment id
		assertTrue("Test: Check different IDs, Failed! Expecting false Got: true", !testAppointment1.equals(testAppointment2));
	}
	
	@Test
	public void testAddAppointment() {
		// Given
		AppointmentService testService = AppointmentService.getInstance();
		
		// When
		String testAppointment = testService.addAppointment(this.goodDate, this.goodDescription);
		
		// Then the returned testAppointment ID string should not be null
		assertTrue("Test: Check adding an appointment, Failed! Expecting: String Got: " + testAppointment, testAppointment != null);
	}
	
	@Test
	public void testDeleteAppointment() {
		// Given
		AppointmentService testService = AppointmentService.getInstance();
		String testAppointment1 = testService.addAppointment(this.goodDate, this.goodDescription);
		String testAppointment2 = testService.addAppointment(this.goodDate, this.goodDescription);
		
		// When
		testService.deleteAppointment(testAppointment1);
		
		// Then the testAppointment1 ID should no longer exist
		assertTrue("Test: Delete appointment, Failed! Expecting: null Got: " + testService.getAppointmentById(testAppointment1), testService.getAppointmentById(testAppointment1) == null);
	}
	
	@Test
	public void testUpdateDate() {
		// Given
		AppointmentService testService = AppointmentService.getInstance();
		String testAppointment1 = testService.addAppointment(this.goodDate, this.goodDescription);
		
		// When
		testService.updateAppointmentDate(testAppointment1, newDate);
		
		// Then the new date should be reflected in the given Appointment ID
		assertTrue("Test: Update appointment date, Failed! Expecting: " + newDate + " Got: " + testService.getAppointmentById(testAppointment1).getDate(), testService.getAppointmentById(testAppointment1).getDate() == newDate);
	}
	
	@Test
	public void testUpdateDescription() {
		// Given
		AppointmentService testService = AppointmentService.getInstance();
		String testAppointment1 = testService.addAppointment(this.goodDate,  this.goodDescription);
		
		// When
		testService.updateAppointmentDescription(testAppointment1, newDescription);
		
		// Then
		assertTrue("Test: Update appointment description, Failed! Expecting: " + newDescription + " Got: " + testService.getAppointmentById(testAppointment1).getDescription(), testService.getAppointmentById(testAppointment1).getDescription() == newDescription);
	}
}
