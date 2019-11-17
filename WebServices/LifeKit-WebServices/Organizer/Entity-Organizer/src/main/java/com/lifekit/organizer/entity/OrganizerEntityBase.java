package com.lifekit.organizer.entity;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class OrganizerEntityBase {

	public OrganizerEntityBase() {
		createdDate = new Date();
	}
	
private Date createdDate;
	
	private Date lastModifiedDate;
	
	
	//@JsonFormat(pattern ="dd-MM-yyyy HH:mm")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	
	
}
