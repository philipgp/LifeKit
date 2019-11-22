package com.lifekit.organizer;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMethod;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.ScheduledTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.TaskType;
import com.lifekit.organizer.entity.WaitingTask;

public class TaskWrapper {

	private InboxTask inboxTask;
	private ActiveTask activeTask;
	
	private ScheduledTask scheduledTask;
	private WaitingTask waitingTask;
	
	private TaskType taskType;
	
	public TaskWrapper(InboxTask inboxTask) {
		this.inboxTask= inboxTask;
		this.setTaskType(TaskType.INBOX);
	}
	public TaskWrapper(ActiveTask inboxTask) {
		this.activeTask= inboxTask;
		this.setTaskType(TaskType.ACTIVE);
	}
	public TaskWrapper(ScheduledTask inboxTask) {
		this.scheduledTask= inboxTask;
		this.setTaskType(TaskType.SCHEDULED);
	}
	public TaskWrapper(WaitingTask inboxTask) {
		this.waitingTask= inboxTask;
		this.setTaskType(TaskType.WAITING);
	}
	
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	
	public boolean hasTaskTypeChange(TaskIUpdatorRequest request) {
		if(taskType != request.getCurrentTaskType()) {
			return true;
		}
		return false;
	}
	
	public Task getTask() {
		if(taskType == TaskType.INBOX) {
			return inboxTask.getTaskDetails();
			
		}else if(taskType == TaskType.ACTIVE) {
			return activeTask.getTaskDetails();
		}
		else if(taskType == TaskType.SCHEDULED) {
			return scheduledTask.getTaskDetails();
		}else {
			return waitingTask.getTaskDetails();
		}
	}
	public InboxTask getInboxTask() {
		return inboxTask;
	}
	public void setInboxTask(InboxTask inboxTask) {
		this.inboxTask = inboxTask;
	}
	public ActiveTask getActiveTask() {
		return activeTask;
	}
	public void setActiveTask(ActiveTask activeTask) {
		this.activeTask = activeTask;
	}
	public ScheduledTask getScheduledTask() {
		return scheduledTask;
	}
	public void setScheduledTask(ScheduledTask scheduledTask) {
		this.scheduledTask = scheduledTask;
	}
	public WaitingTask getWaitingTask() {
		return waitingTask;
	}
	public void setWaitingTask(WaitingTask waitingTask) {
		this.waitingTask = waitingTask;
	}
	
}
