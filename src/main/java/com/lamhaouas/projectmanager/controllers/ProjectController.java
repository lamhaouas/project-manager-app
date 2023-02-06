package com.lamhaouas.projectmanager.controllers;

import com.lamhaouas.projectmanager.dao.EmployeeRepo;
import com.lamhaouas.projectmanager.dao.ProjectRepo;
import com.lamhaouas.projectmanager.entities.Employee;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepo proRepo;
    @Autowired
    EmployeeRepo empRepo;
    @GetMapping
    private String displayProjects(Model model){
        List<Project> projects = proRepo.findAll() ;
        model.addAttribute("project", projects);
        return "projects/list-project";
    }
    @GetMapping("/new")
    private String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees =empRepo.findAll();

        model.addAttribute("project",aProject);
        model.addAttribute("allEmployees",employees);
        return "/projects/new-project";
    }

    @PostMapping("/save")
    private String createProject(Project project, Model model){
        proRepo.save(project);

        return "redirect:/projects/new";

    }

}
