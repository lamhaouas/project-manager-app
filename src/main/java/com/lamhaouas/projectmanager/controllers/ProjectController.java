package com.lamhaouas.projectmanager.controllers;

import com.lamhaouas.projectmanager.dao.ProjectRepo;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepo proRepo;
    @GetMapping("/new")
    private String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project",aProject);
        return "new-project";
    }

    @PostMapping("/save")
    private String createProject(Project project,Model model){
        proRepo.save(project);
        return "redirect:/projects/new";

    }

}
