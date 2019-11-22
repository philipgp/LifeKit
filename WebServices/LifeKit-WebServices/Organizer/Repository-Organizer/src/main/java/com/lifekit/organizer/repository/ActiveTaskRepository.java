package com.lifekit.organizer.repository;


 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.TaskType;

@RepositoryRestResource(collectionResourceRel = "organizer", path = TaskType.ACTIVE_TASK_FOLDER)
public interface ActiveTaskRepository extends PagingAndSortingRepository<ActiveTask, Long> {

	
	@Query("select at from ORG_ACTIVE_TASK at where at.taskDetails.id=:id")
	public ActiveTask findByTaskId(@Param(value = "id") Long id);
	
	public void deleteByTaskDetails(Task taskDetails);

	/* List<Task> findByLastName(@Param("name") String name); */

}
