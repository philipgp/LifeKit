package com.lifekit.organizer.entity;

import java.text.SimpleDateFormat;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity(name = "ORG_REMINDER")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Reminder extends OrganizerEntityBase{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	//@JsonFormat(pattern ="dd-MMM-yyyy HH24:mi")
	
	private Date time;
	
	// @Transient
	// public String getTimeStr(){

	// 	if(time!=null){
	// 		return new SimpleDateFormat("dd-MMM-yyyy HH:mi").format(time);
	// 	}
	// 	return "";
	// }

	
	@Transient
	public String getTimeString(){
		if(time!=null){
					return new SimpleDateFormat("dd-MMM-yyyy HH:mm").format(time);
			 	}
			 	return "";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
	
	
	
	
}
