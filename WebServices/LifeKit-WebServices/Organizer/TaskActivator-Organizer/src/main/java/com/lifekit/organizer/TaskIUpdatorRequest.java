package com.lifekit.organizer;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lifekit.organizer.entity.TaskType;

public class TaskIUpdatorRequest {

	private Long id;
	private TaskType previousTaskType;
	private TaskType currentTaskType;
	private String projectName;
	private String area;
	private String name;
	private boolean completedFlag;
	//@JsonFormat(pattern ="dd-MMM-yyyy HH24:mi")
	private String reminderTime;

	public boolean isCompletedFlag() {
		return completedFlag;
	}

	public String getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}

	public void setCompletedFlag(boolean completedFlag) {
		this.completedFlag = completedFlag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public TaskType getPreviousTaskType() {
		return previousTaskType;
	}
	public void setPreviousTaskType(TaskType previousTaskType) {
		this.previousTaskType = previousTaskType;
	}
	public TaskType getCurrentTaskType() {
		return currentTaskType;
	}
	public void setCurrentTaskType(TaskType currentTaskType) {
		this.currentTaskType = currentTaskType;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	@JsonIgnore
	public boolean hasTaskTypeChange() {
		return previousTaskType != currentTaskType;
	}
	
}
