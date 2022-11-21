package com.snhu.cs320project1;

import java.util.ArrayList;
import java.util.Random;


public class TaskService {

	/* Task Class Requirements
		The task service shall be able to add tasks with a unique ID.
		The task service shall be able to delete tasks per task ID.
		The task service shall be able to update task fields per task ID. The following fields are updateable:
			Name
			Description
	*/
	
	
	private ArrayList<Task> taskDB = new ArrayList<Task>();
	
	private TaskService() {
		// This class needs to be a singleton to ensure that the IDs for the created contacts are unique.
	}
	
	private static class SingletonHelper {
		private static final TaskService INSTANCE = new TaskService();
	}
	
	public static TaskService getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	/* Adds a new task
	 *   Inputs: name, description
	 *   Returns: id of created task
	 */
	public String addTask(String name, String description) {
		String id = generateID();
		taskDB.add(new Task(id, name, description));
		return id;
	}
	
	/* Deletes an existing task
	 *   Inputs: id of an existing task
	 *   Returns: None
	 */
	public void deleteTask(String id) {
		Integer index = getTaskIndexByID(id);
		if (index != null) {
			taskDB.remove(index.intValue());
		}
	}
	
	/* Gets a task given a valid ID
	 *   Inputs: id of an existing task
	 *   Returns: Task object or null if no
	 *   task is found
	 */
	public Task getTaskById(String id) {
		Integer index = getTaskIndexByID(id);
		if (index != null) {
			return taskDB.get(index.intValue());
		}
		return null;
	}
	
	/* Updates the name field of an existing Task object
	 *   Inputs: id of an existing task, new name field
	 *   Returns: Updated task object or null if no task was
	 *   found with that id.
	 */
	public Task updateTaskName(String id, String name) {
		Integer index = getTaskIndexByID(id);
		if (index != null) {
			int intIndex = index.intValue();
			Task updatedTask = taskDB.get(intIndex);
			updatedTask.setName(name);
			taskDB.set(intIndex, updatedTask);
			return updatedTask;
		}
		return null;
	}
	
	/* Updates the description field of an existing Task object
	 *   Inputs: id of an existing task, new description field
	 *   Returns: Updated ask object or null if no task was
	 *   found with that id.
	 */
	public Task updateTaskDescription(String id, String description) {
		Integer index = getTaskIndexByID(id);
		if (index != null) {
			int intIndex = index.intValue();
			Task updatedTask = taskDB.get(intIndex);
			updatedTask.setDescription(description);
			taskDB.set(intIndex, updatedTask);
			return updatedTask;
		}
		return null;
	}
	
	/* Returns the index of a task in the DB given a
	 * valid task ID
	 *   Inputs: id of an existing task
	 *   Returns: index of the task in the DB or null
	 *   if no valid task was found.
	 */
	private Integer getTaskIndexByID(String id) {
		for (Integer i = 0; i < taskDB.size(); i++) {
			if (taskDB.get(i).getID() == id) {
				return i;
			}
		}
		return null;
	}
	
	/* Generates a random 10 character ID
	 *   Inputs: none
	 *   Returns: 10 character ID.
	 */
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
