package com.lamhaouas.projectmanager.dao;

import com.lamhaouas.projectmanager.dto.EmployeeProject;
import com.lamhaouas.projectmanager.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "GROUP BY  e.first_name, e.last_name ORDER BY  3 DESC")
    public List<EmployeeProject> employeeProjects();
}
