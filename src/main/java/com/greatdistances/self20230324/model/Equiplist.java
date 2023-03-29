package com.greatdistances.self20230324.model;

import javax.persistence.Entity;

@Entity
public class Equiplist extends AbstractEntity{

    private String jobNumber;

    //TODO add List<Item>, @ManyToMany

    public Equiplist() {
    }

    public Equiplist(String name, String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }
}
