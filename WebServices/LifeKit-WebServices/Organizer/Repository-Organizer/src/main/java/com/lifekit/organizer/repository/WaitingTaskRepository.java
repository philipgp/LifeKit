package com.lifekit.organizer.repository;


 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.TaskType;
import com.lifekit.organizer.entity.WaitingTask;

@RepositoryRestResource(collectionResourceRel = "organizer", path = TaskType.WAITING_TASK_FOLDER)
public interface WaitingTaskRepository extends PagingAndSortingRepository<WaitingTask, Long> {

	void deleteByTaskDetails(Task taskDetails);
	
	@Query("from ORG_WAITING_TASK where taskDetails.id=:id")
	public WaitingTask findByTaskId(@Param(value = "id") Long id);

	/* List<Task> findByLastName(@Param("name") String name); */

}
