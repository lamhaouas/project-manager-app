package com.lamhaouas.projectmanager.dao;

import com.lamhaouas.projectmanager.dto.ChartData;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepo extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();
    @Query(nativeQuery = true, value = "SELECT stage label, COUNT(*) as val " +
            " FROM project " +
            "GROUP BY stage")
    public List<ChartData> getProjectStatus();
}
