package com.lifekit.organizer;

import java.util.List;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.ScheduledTask;
import com.lifekit.organizer.entity.WaitingTask;

public class AllTaskResponse {
	
	private List<InboxTask> inboxTasks;
	
	private List<ActiveTask> activeTasks;
	
	private List<WaitingTask> waitingTasks;
	
	private List<ScheduledTask> scheduledTasks;

	public List<InboxTask> getInboxTasks() {
		return inboxTasks;
	}

	public void setInboxTasks(List<InboxTask> inboxTasks) {
		this.inboxTasks = inboxTasks;
	}

	public List<ActiveTask> getActiveTasks() {
		return activeTasks;
	}

	public void setActiveTasks(List<ActiveTask> activeTasks) {
		this.activeTasks = activeTasks;
	}

	public List<WaitingTask> getWaitingTasks() {
		return waitingTasks;
	}

	public void setWaitingTasks(List<WaitingTask> waitingTasks) {
		this.waitingTasks = waitingTasks;
	}

	public List<ScheduledTask> getScheduledTasks() {
		return scheduledTasks;
	}

	public void setScheduledTasks(List<ScheduledTask> scheduledTasks) {
		this.scheduledTasks = scheduledTasks;
	}
	
	
	

}
