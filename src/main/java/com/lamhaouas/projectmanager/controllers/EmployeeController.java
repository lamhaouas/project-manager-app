package com.lamhaouas.projectmanager.controllers;

import com.lamhaouas.projectmanager.dao.EmployeeRepo;
import com.lamhaouas.projectmanager.entities.Employee;
import com.lamhaouas.projectmanager.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepo empRepo;
    @GetMapping
    private String displayEmployees(Model model){
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employee", employees);
        return "employees/list-employee";
    }
    @GetMapping("/new")
    private String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee",anEmployee);
        return "/employees/new-employee";
    }
    @PostMapping("/save")
    private String createEmployee(Model model,Employee employee){
        empRepo.save(employee);
        return "redirect:/employees/new";

    }

}

