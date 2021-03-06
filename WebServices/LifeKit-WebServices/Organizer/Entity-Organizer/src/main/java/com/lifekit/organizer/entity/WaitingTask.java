package com.lifekit.organizer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity(name = "ORG_WAITING_TASK")
public class WaitingTask extends OrganizerEntityBase implements TaskInterface{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "TASK_DETAIL_ID")
	private Task taskDetails;

	
	@Column(name="waiting_for")
	private String waitingfor;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Task getTaskDetails() {
		return taskDetails;
	}


	public void setTaskDetails(Task taskDetails) {
		this.taskDetails = taskDetails;
	}


	@Override
	public TaskType getTaskType() {
		return TaskType.WAITING;
	}


	public String getWaitingfor() {
		return waitingfor;
	}


	public void setWaitingfor(String waitingfor) {
		this.waitingfor = waitingfor;
	}


	
}
