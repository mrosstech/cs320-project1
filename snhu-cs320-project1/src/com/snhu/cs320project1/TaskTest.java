package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

	Task TestTask = new Task("id", "This is a task", "This is a long description way past the number of characters allowed!");
	
	// Test Task Name Possibilities
	
	@Test
	public void testTaskNameLengthTooLong() {
		TestTask.setName("Long task name that is longer than 20 characters"); // 47 characters
		assertTrue("Test: Task NameToo Long, Failed! Expecting: 'Long task name that ' Got: " + TestTask.getName(), TestTask.getName().length() < 21);
	}
	
	@Test
	public void testTaskNameLengthShort() {
		TestTask.setName("shortTask"); // 9 characters
		assertTrue("Test: Short task failed, Failed! Expecting: 'shortTask' Got: " + TestTask.getName(), TestTask.getName() == "shortTask");
	}
	
	@Test
	public void testTaskNameLengthIsTwenty() {
		TestTask.setName("Task is twenty chars"); // 20 characters
		assertTrue("Test: Exactly 20 chars, Failed! Expecting: 'Task is twenty chars' Got: " + TestTask.getName(), TestTask.getName() == "Task is twenty chars");
	}
	
	@Test
	public void testTaskNameLengthIsNull() {
		TestTask.setName(null); // null test
		assertTrue("Test: Null task name, Failed! Expecting: '' Got: " + TestTask.getName(), TestTask.getName() == "");
	}
	
	// Test Task Description Possibilities
	@Test
	public void testTaskDescLengthTooLong() {
		TestTask.setDescription("Long task desc that is longer than 50 characters now"); // 52 characters
		assertTrue("Test: Task Desc Too Long, Failed! Expecting: 'Long task desc that is longer than 50 characters no' Got: " + TestTask.getDescription(), TestTask.getDescription().length() < 51);
	}
	
	@Test
	public void testTaskDescLengthShort() {
		TestTask.setDescription("Short Task Description"); // 22 characters
		assertTrue("Test: Short task failed, Failed! Expecting: 'Short Task Description' Got: " + TestTask.getDescription(), TestTask.getDescription() == "Short Task Description");
	}
	
	@Test
	public void testTaskDescLengthIsFifty() {
		TestTask.setDescription("Task description that is exactly fifty characters!"); // 20 characters
		assertTrue("Test: Exactly 50 chars, Failed! Expecting: 'Task description that is exactly fifty characters!' Got: " + TestTask.getDescription(), TestTask.getDescription() == "Task description that is exactly fifty characters!");
	}
	
	@Test
	public void testTaskDescLengthIsNull() {
		TestTask.setDescription(null); // null test
		assertTrue("Test: Null task description, Failed! Expecting: '' Got: " + TestTask.getDescription(), TestTask.getDescription() == "");
	}

}
