package com.lamhaouas.projectmanager.dao;

import com.lamhaouas.projectmanager.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
