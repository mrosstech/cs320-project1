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
	}
	
	public void setName(String thisName) {
		this.name = validateName(thisName);
	}
	
	
	public void setDescription(String thisDescription) {
		this.description = validateDescription(thisDescription);
	}
	
	public String validateName(String thisName) {
		if (thisName == null) {
			thisName = "";
		} else if (thisName.length() > 20 ) {
			thisName = thisName.substring(0, 20);
		}
		return thisName;
	}
	
	public String validateDescription(String thisDesc) {
		if (thisDesc == null) {
			thisDesc = "";
		} else if (thisDesc.length() > 50) {
			thisDesc = thisDesc.substring(0, 50);
		}
		return thisDesc;
	}
	
}
