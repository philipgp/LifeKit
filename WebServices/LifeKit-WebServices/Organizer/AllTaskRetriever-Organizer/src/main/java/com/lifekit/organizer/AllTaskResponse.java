package com.lifekit.organizer;

import java.util.List;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.ScheduledTask;
import com.lifekit.organizer.entity.TaskInterface;
import com.lifekit.organizer.entity.WaitingTask;

public class AllTaskResponse {
	
	private    List<? extends TaskInterface> tasks;

	public List<? extends TaskInterface> getTasks() {
		return tasks;
	}

	public void setTasks(List<? extends TaskInterface> tasks) {
		this.tasks = tasks;
	}
	
	

}
