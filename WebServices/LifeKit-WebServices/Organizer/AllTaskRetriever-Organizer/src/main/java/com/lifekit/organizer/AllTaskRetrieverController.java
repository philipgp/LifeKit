package com.lifekit.organizer;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.ScheduledTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.WaitingTask;
import com.lifekit.organizer.repository.ActiveTaskRepository;
import com.lifekit.organizer.repository.InboxTaskRepository;
import com.lifekit.organizer.repository.ScheduledTaskRepository;
import com.lifekit.organizer.repository.TaskRepository;
import com.lifekit.organizer.repository.WaitingTaskRepository;

@RestController 
public class AllTaskRetrieverController { 
	
	@Autowired
	ActiveTaskRepository activeTaskRepository;
	
	@Autowired
	InboxTaskRepository inboxTaskRepository;
	
	@Autowired
	WaitingTaskRepository waitingTaskRepository;
	
	@Autowired
	ScheduledTaskRepository scheduledTaskRepository;
	
	@Autowired
	TaskRepository taskRepository;

	@GetMapping(value = "/getAll")
	public AllTaskResponse getAll() {
		
		AllTaskResponse response = new AllTaskResponse();
		response.setActiveTasks((List<ActiveTask>) activeTaskRepository.findAll());
		response.setInboxTasks((List<InboxTask>) inboxTaskRepository.findAll());
		response.setWaitingTasks((List<WaitingTask>) ( waitingTaskRepository.findAll()));
		
		response.setScheduledTasks((List<ScheduledTask>) ( scheduledTaskRepository.findAll()));
		return response;
	}
}
