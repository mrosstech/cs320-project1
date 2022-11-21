package com.snhu.cs320project1;

public class Task {
	/* Task Class Requirements
	The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
	The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
	The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.
		*/
	
	private String id;
	private String name;
	private String description;
	
	/* Constructor */
	public Task(String thisId, String thisName, String thisDesc) {
		setName(thisName);
		setDescription(thisDesc);
		setId(thisId);
	}
	/* Constructor */
	public Task() {
		setName("");
		setDescription("");
		setId(null);
	}
	
	
	/* Sets the name of the task */
	public void setName(String thisName) {
		this.name = validateName(thisName);
	}
	
	/* Sets the description of the task */
	public void setDescription(String thisDescription) {
		this.description = validateDescription(thisDescription);
	}
	
	/* Sets the id of the task */
	public void setId(String thisId) {
		this.id = validateID(thisId);
	}
	
	/* Gets the task description */
	public String getDescription() {
		return this.description;
	}
	
	/* Gets the task name */
	public String getName() {
		return this.name;
	}
	
	/* Gets the task ID */
	public String getID() {
		return this.id;
	}
	
	/* Validates the task name
	 * returns an empty string if the input is null
	 * returns a truncated string to 20 characters or
	 * the original string if the input is less than 20
	 * characters
	 */
	public String validateName(String thisName) {
		if (thisName == null) {
			thisName = "";
		} else if (thisName.length() > 20 ) {
			thisName = thisName.substring(0, 20);
		}
		return thisName;
	}
	
	/* Validates the task description
	 * returns an empty string if the input is null
	 * returns a truncated string to 50 characters or
	 * the original string if the input is less than 50
	 * characters
	 */
	public String validateDescription(String thisDesc) {
		if (thisDesc == null) {
			thisDesc = "";
		} else if (thisDesc.length() > 50) {
			thisDesc = thisDesc.substring(0, 50);
		}
		return thisDesc;
	}
	
	/* Validates the task ID
	 * returns an valid ID if the input is null or
	 * truncates the string to 10 characters.
	 */
	public String validateID(String thisId) {
		if (thisId == null) {
			this.id = TaskService.generateID();
		} else if (thisId.length() > 10) {
			thisId = thisId.substring(0,10);
		}
		return thisId;
	}
	
}
