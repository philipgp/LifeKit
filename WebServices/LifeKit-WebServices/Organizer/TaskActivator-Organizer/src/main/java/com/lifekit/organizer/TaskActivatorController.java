package com.lifekit.organizer;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.repository.ActiveTaskRepository;
import com.lifekit.organizer.repository.InboxTaskRepository;
import com.lifekit.organizer.repository.TaskRepository;

@RestController 
public class TaskActivatorController { 
	
	@Autowired
	ActiveTaskRepository activeTaskRepository;
	
	@Autowired
	InboxTaskRepository inboxTaskRepository;
	
	@Autowired
	TaskRepository taskRepository;

	@GetMapping(value = "/activateTask")
	public String getMessage(@RequestParam Long id) {
		Optional<Task> item = taskRepository.findById(id);
		inboxTaskRepository.delete((InboxTask) item.get());
		
		return "he";
	}
}
