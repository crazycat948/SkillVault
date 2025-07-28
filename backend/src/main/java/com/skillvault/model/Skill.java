package com.skillvault.model;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int proficiency; 

    
    public Skill() {
    }

    public Skill(String name, String description, int proficiency) {
        this.name = name;
        this.description = description;
        this.proficiency = proficiency;
    }

    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }
}

