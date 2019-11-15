package com.lifekit.organizer.entity;

import javax.persistence.Transient;

public interface TaskInterface {

	@Transient
	public TaskType getTaskType();
}
