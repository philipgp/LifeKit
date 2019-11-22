package com.lifekit.organizer;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lifekit.organizer.entity.Area;
import com.lifekit.organizer.entity.Project;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.repository.ActiveTaskRepository;
import com.lifekit.organizer.repository.InboxTaskRepository;
import com.lifekit.organizer.repository.ProjectRepository;
import com.lifekit.organizer.repository.TaskRepository;

@RestController 
public class TaskActivatorController { 
	
	@Autowired
	ActiveTaskRepository activeTaskRepository;
	
	@Autowired
	InboxTaskRepository inboxTaskRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskWrapperBuilder taskWrapperBuilder;
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	
	@Autowired
	TaskReOrganizer taskReOrganizer;

	@PostMapping(value = "/updateTask")
	@Transactional
	@ResponseBody
	public TaskWrapper activateTask(@RequestBody TaskIUpdatorRequest request) {
		TaskWrapper taskWrapper = taskWrapperBuilder.getTaskWrapper(request.getId(), request.getPreviousTaskType());
		if(taskWrapper.hasTaskTypeChange(request)) {
			taskWrapper = taskReOrganizer.moveTaskToNewType(request, taskWrapper);
		}
		Task task = taskWrapper.getTask();
		updateTaskWithNewDetails(task, request);
		taskRepository.save(task);
		return taskWrapperBuilder.getTaskWrapper(task.getId(), request.getCurrentTaskType());
	 	
	}
	
	
	private Task updateTaskWithNewDetails(Task task,TaskIUpdatorRequest request) {
		task.setName(request.getName());
		if(request.getProjectName()!=null && !request.getProjectName().isEmpty()) {
			Project project = projectRepository.findByName(request.getProjectName());
			if(project == null) {
				project = new Project();
				project.setName(request.getProjectName());
			}
				
			task.setProject(project);
		}
		if(request.getArea()!=null && !request.getArea().isEmpty()) {
			task.setArea(Area.valueOf(request.getArea()));
		}
		if(request.isCompletedFlag() && task.getCompletedDate()==null) {
			task.setCompletedDate(new Date());
		}
		if(!request.isCompletedFlag())
			task.setCompletedDate(null);
		
		return task;
	}
}

