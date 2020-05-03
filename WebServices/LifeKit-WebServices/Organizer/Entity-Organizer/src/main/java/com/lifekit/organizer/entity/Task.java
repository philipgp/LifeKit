package com.lifekit.organizer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity(name = "ORG_TASK")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Task extends OrganizerEntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	private Date completedDate;
	
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "PROJECT_ID")
	private Project project;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "REMINDER_ID")
	private Reminder reminder; 
	
	private Area area;
	
	private Priority priority;
	
	private Effort effort;
	
	private TimeRequired time_required;
	

	public Effort getEffort() {
		return effort;
	}

	public void setEffort(Effort effort) {
		this.effort = effort;
	}

	public TimeRequired getTime_required() {
		return time_required;
	}

	public void setTime_required(TimeRequired time_required) {
		this.time_required = time_required;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public Reminder getReminder() {
		return reminder;
	}

	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
	
	
	
	
}
