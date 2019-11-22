package com.lifekit.organizer.repository;


 
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lifekit.organizer.entity.Project;
import com.lifekit.organizer.entity.TaskType;

@RepositoryRestResource(collectionResourceRel = "organizer", path = "projects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	Project findByName(String name);

	/* List<Task> findByLastName(@Param("name") String name); */

}
