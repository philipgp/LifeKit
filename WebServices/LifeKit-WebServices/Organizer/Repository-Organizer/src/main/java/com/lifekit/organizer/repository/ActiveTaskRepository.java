package com.lifekit.organizer.repository;


 
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.TaskType;

@RepositoryRestResource(collectionResourceRel = "organizer", path = TaskType.ACTIVE_TASK_FOLDER)
public interface ActiveTaskRepository extends PagingAndSortingRepository<ActiveTask, Long> {

	/* List<Task> findByLastName(@Param("name") String name); */

}
