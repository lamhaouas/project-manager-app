package com.lamhaouas.projectmanager.dao;

import com.lamhaouas.projectmanager.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

}
