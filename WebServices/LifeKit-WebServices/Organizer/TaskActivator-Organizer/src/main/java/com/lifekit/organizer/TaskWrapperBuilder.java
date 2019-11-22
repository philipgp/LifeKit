package com.lifekit.organizer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.ScheduledTask;
import com.lifekit.organizer.entity.TaskType;
import com.lifekit.organizer.entity.WaitingTask;
import com.lifekit.organizer.repository.ActiveTaskRepository;
import com.lifekit.organizer.repository.InboxTaskRepository;
import com.lifekit.organizer.repository.ScheduledTaskRepository;
import com.lifekit.organizer.repository.WaitingTaskRepository;

@Component
public class TaskWrapperBuilder {

	@Autowired
	InboxTaskRepository inboxTaskRepository;
	
	@Autowired
	ActiveTaskRepository activeTaskRepository;
	
	@Autowired
	ScheduledTaskRepository scheduledTaskRepository;
	
	@Autowired
	WaitingTaskRepository waitingTaskRepository;
	
	
	public TaskWrapper getTaskWrapper(Long id,TaskType taskType) {
		TaskWrapper taskWrapper = null;
		//taskWrapper.setTaskType(taskType); 
		if(taskType == TaskType.ACTIVE) {
			ActiveTask activeTask = activeTaskRepository.findByTaskId(id);
			taskWrapper = new TaskWrapper(activeTask);
		}else if(taskType == TaskType.INBOX) {
			InboxTask inboxTask = inboxTaskRepository.findByTaskId(id);
			taskWrapper = new TaskWrapper(inboxTask);
		}
		else if(taskType == TaskType.SCHEDULED) {
			ScheduledTask scheduledTask = scheduledTaskRepository.findByTaskId(id);
			taskWrapper = new TaskWrapper(scheduledTask);
		}else {
			WaitingTask waitingTask = waitingTaskRepository.findByTaskId(id);
			taskWrapper = new TaskWrapper(waitingTask);
		}
		
		return taskWrapper;
	}
}
