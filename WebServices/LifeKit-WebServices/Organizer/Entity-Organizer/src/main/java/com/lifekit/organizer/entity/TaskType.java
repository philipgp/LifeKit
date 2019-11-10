package com.lifekit.organizer.entity;

public enum TaskType {

	
	
	ACTIVE,INBOX,SCHEDULED,WAITING;
	public final static String ACTIVE_TASK_FOLDER="activetasks";
	public final static String INBOX_TASK_FOLDER="inboxtasks";
	public final static String SCHEDULED_TASK_FOLDER="scheduledtasks";
	public final static String WAITING_TASK_FOLDER="waitingtasks";
	
	
	public String getString(TaskType taskType) {
		if(taskType == ACTIVE)
			return ACTIVE_TASK_FOLDER; 
		else if(taskType == INBOX)
			return INBOX_TASK_FOLDER;
		else if(taskType == SCHEDULED)
			return SCHEDULED_TASK_FOLDER;
		else 
			return WAITING_TASK_FOLDER;
	}
	
	public TaskType getTaskType(String taskTypeString) {
		for(TaskType task:values()) {
			if(task.getString(task).equalsIgnoreCase(taskTypeString))
				return task;
		}
		return null;
	}
}
