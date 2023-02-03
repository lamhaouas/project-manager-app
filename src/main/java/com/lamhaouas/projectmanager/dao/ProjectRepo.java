package com.lamhaouas.projectmanager.dao;

import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepo extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();
}
