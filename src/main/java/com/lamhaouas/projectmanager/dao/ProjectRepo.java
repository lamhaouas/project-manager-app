package com.lamhaouas.projectmanager.dao;

import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project, Long> {
}
