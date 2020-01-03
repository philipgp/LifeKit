package com.lifekit.organizer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity(name = "ORG_SCHEDULED_TASK")
public class ScheduledTask extends OrganizerEntityBase implements TaskInterface{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "TASK_DETAIL_ID")
	private Task taskDetails;

	
	public Task getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(Task taskDetails) {
		this.taskDetails = taskDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public TaskType getTaskType() {
		return TaskType.SCHEDULED;
	}


	
}
