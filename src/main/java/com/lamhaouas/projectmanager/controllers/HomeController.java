package com.lamhaouas.projectmanager.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamhaouas.projectmanager.dao.EmployeeRepo;
import com.lamhaouas.projectmanager.dao.ProjectRepo;
import com.lamhaouas.projectmanager.dto.ChartData;
import com.lamhaouas.projectmanager.dto.EmployeeProject;
import com.lamhaouas.projectmanager.entities.Employee;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    ProjectRepo proRepo;
    @Autowired
    EmployeeRepo empRepo;
    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();

        //convert projectData object into a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);

        model.addAttribute("projectStatusCnt", jsonString);


        //Query data for employees from DB
        List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
       model.addAttribute("employeesListProjectsCnt", employeesProjectCount);
        return "home";
    }
}
