package com.snhu.cs320project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskServiceTest {

/*
	The task service shall be able to add tasks with a unique ID.
	The task service shall be able to delete tasks per task ID.
	The task service shall be able to update task fields per task ID. The following fields are updatable:
		Name
		Description	
 */
	TaskService TestTaskService = TaskService.getInstance(); 
	
	private String testTaskName1 = "My New Task";
	private String testTaskDescription1 = "My New Task Description";
	private String updatedTaskName1 = "My Updated Task";
	private String updatedTaskDescription1 = "My Updated Description";
	private String testTaskName2 = "My New Task 2";
	private String testTaskDescription2 = "My New Task Description 2";
	
	private String id1 = "";
	private String id2 = "";
	
	
	/* Test adding a task
	 * Adds a new task and then attempts to see if the returned id is null or empty.
	 */
	@Test
	public void AddTaskTest() {
		this.id1 = TestTaskService.addTask(testTaskName1, testTaskDescription1);
		assertTrue("Test: Add task, Failed! Expecting: false Got: " + id1.isEmpty(), id1.isEmpty() == false);
	}
	
	/* Test creating two tasks and validating that the IDs are not duplicated
	 * Creates two tasks and then compares the IDs to verify that they are 
	 * not the same.
	 */
	
	@Test
	public void DuplicateTaskIdTest() {
		this.id1 = TestTaskService.addTask(testTaskName1, testTaskDescription1);
		this.id2 = TestTaskService.addTask(testTaskName2, testTaskDescription2);
		assertTrue("Test: Check duplicate IDs, Failed! Expecting false Got: " + (id1 == id2), id1 != id2);
	}
	
	/* Test deleting a task
	 * Creates a task and then deletes that task.  Tests to ensure the task
	 * cannot be looked up using the task ID of the initially created task.
	 */
	@Test
	public void DeleteTaskTest() {
		Task tempTask = new Task();
		this.id2 = TestTaskService.addTask(testTaskName2, testTaskDescription2);
		TestTaskService.deleteTask(id2);
		tempTask = TestTaskService.getTaskById(id2);
		assertTrue("Test: Check delete task, Failed! Expecting null Got: " + tempTask, tempTask == null);
	}
	
	/* Test Updating the Name field of an existing Task
	 * Creates a task and then attempts to update that task.
	 * Checks to ensure that the task id has the newly updated field.
	 */
	@Test
	public void UpdateNameTest() {
		this.id1 = TestTaskService.addTask(testTaskName1, testTaskDescription1);
		TestTaskService.updateTaskName(id1, updatedTaskName1);
		assertTrue("Test: Update task name, Failed! Expecting " + updatedTaskName1 + " Got: " + TestTaskService.getTaskById(id1).getName(), TestTaskService.getTaskById(id1).getName() == updatedTaskName1);
	}
	
	/* Test updating the description field of an existing Task
	 * Creates a task and then attempts to update that task.
	 * Checks to ensure that the task id has the newly updated field.
	 */
	@Test
	public void UpdateDescTest() {
		this.id1 = TestTaskService.addTask(testTaskName1, testTaskDescription1);
		TestTaskService.updateTaskDescription(id1, updatedTaskDescription1);
		assertTrue("Test: Update task description, Failed! Expecting " + updatedTaskDescription1 + " Got: " + TestTaskService.getTaskById(id1).getDescription(), TestTaskService.getTaskById(id1).getDescription() == updatedTaskDescription1);
	}
}
