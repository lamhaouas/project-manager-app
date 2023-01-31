package com.lamhaouas.projectmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private String stage;
    private String description;

    public Project(){

    }
    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getStage() {
        return stage;
    }

    public String getDescription() {
        return description;
    }
}
