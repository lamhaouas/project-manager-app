package com.lamhaouas.projectmanager.controllers;

import com.lamhaouas.projectmanager.dao.EmployeeRepo;
import com.lamhaouas.projectmanager.dao.ProjectRepo;
import com.lamhaouas.projectmanager.entities.Employee;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProjectRepo proRepo;
    @Autowired
    EmployeeRepo empRepo;
    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
       List<Employee> employees = empRepo.findAll();
       model.addAttribute("employees", employees);
        return "home";
    }
}
