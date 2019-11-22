package com.lifekit.organizer.repository;


 
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.TaskType;


@RepositoryRestResource(collectionResourceRel = "organizer", path = TaskType.INBOX_TASK_FOLDER)
public interface InboxTaskRepository extends PagingAndSortingRepository<InboxTask, Long> {
	
	public void deleteByTaskDetails(Task taskDetails);
	
	@Query("from ORG_INBOX_TASK where taskDetails.id=:id")
	public InboxTask findByTaskId(@Param(value = "id") Long id);

	/* List<Task> findByLastName(@Param("name") String name); */

}
