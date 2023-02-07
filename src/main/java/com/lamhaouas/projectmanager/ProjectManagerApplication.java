package com.lamhaouas.projectmanager;

import com.lamhaouas.projectmanager.dao.EmployeeRepo;
import com.lamhaouas.projectmanager.dao.ProjectRepo;
import com.lamhaouas.projectmanager.entities.Employee;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagerApplication {
	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	ProjectRepo projRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerApplication.class, args);
	}



}
