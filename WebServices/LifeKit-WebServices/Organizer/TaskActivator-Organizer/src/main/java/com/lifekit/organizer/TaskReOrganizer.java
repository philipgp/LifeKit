package com.lifekit.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.ScheduledTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.TaskType;
import com.lifekit.organizer.entity.WaitingTask;
import com.lifekit.organizer.repository.ActiveTaskRepository;
import com.lifekit.organizer.repository.InboxTaskRepository;
import com.lifekit.organizer.repository.ScheduledTaskRepository;
import com.lifekit.organizer.repository.WaitingTaskRepository;

@Component
public class TaskReOrganizer {

	@Autowired
	InboxTaskRepository inboxTaskRepository;

	@Autowired
	ActiveTaskRepository activeTaskRepository;

	@Autowired
	ScheduledTaskRepository scheduledTaskRepository;

	@Autowired
	WaitingTaskRepository waitingTaskRepository;

	public TaskWrapper moveTaskToNewType(TaskIUpdatorRequest request,TaskWrapper previousTaskWrapper) {
		deletePreviousTaskType(previousTaskWrapper);
		return createTaskUnderNewType(previousTaskWrapper.getTask(), request);
		
	}

	private TaskWrapper createTaskUnderNewType(Task task,TaskIUpdatorRequest request) {
		TaskWrapper wrapper = null;
		if(request.getCurrentTaskType()==TaskType.INBOX) {
			InboxTask inboxTask = new InboxTask();
			inboxTask.setTaskDetails(task);
			wrapper = new TaskWrapper(inboxTaskRepository.save(inboxTask));
			
		}else if(request.getCurrentTaskType()==TaskType.ACTIVE) {
			ActiveTask activeTask = new ActiveTask();
			activeTask.setTaskDetails(task);
			wrapper = new TaskWrapper(activeTaskRepository.save(activeTask));
		}else if(request.getCurrentTaskType()==TaskType.SCHEDULED) {
			ScheduledTask scheduledTask = new ScheduledTask();
			scheduledTask.setTaskDetails(task);
			wrapper = new TaskWrapper(scheduledTaskRepository.save(scheduledTask));
		}else
		{
			WaitingTask waitingTask = new WaitingTask();
			waitingTask.setTaskDetails(task);
			wrapper = new TaskWrapper(waitingTaskRepository.save(waitingTask));
		}
		return wrapper;
	}
	private void deletePreviousTaskType(TaskWrapper taskWrapper) {
		if(taskWrapper.getTaskType()==TaskType.INBOX) {
			inboxTaskRepository.deleteByTaskDetails(taskWrapper.getTask());
		}else if(taskWrapper.getTaskType()==TaskType.ACTIVE) {
			activeTaskRepository.deleteByTaskDetails(taskWrapper.getTask());
		}else if(taskWrapper.getTaskType()==TaskType.SCHEDULED) {
			scheduledTaskRepository.deleteByTaskDetails(taskWrapper.getTask());
		}else
			waitingTaskRepository.deleteByTaskDetails(taskWrapper.getTask());


	}


}
