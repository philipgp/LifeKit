package com.lifekit.organizer.repository;


 
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lifekit.organizer.entity.ActiveTask;
import com.lifekit.organizer.entity.InboxTask;
import com.lifekit.organizer.entity.Task;
import com.lifekit.organizer.entity.TaskType;
import com.lifekit.organizer.entity.WaitingTask;

@RepositoryRestResource(collectionResourceRel = "organizer", path = "organizer/"+TaskType.WAITING_TASK_FOLDER)
public interface WaitingTaskRepository extends PagingAndSortingRepository<WaitingTask, Long> {

	/* List<Task> findByLastName(@Param("name") String name); */

}
