package com.greatdistances.self20230324.model;

import javax.persistence.Entity;

@Entity
public class Job extends AbstractEntity {

    private String jobNumber;


    public Job() {
    }

    public Job(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

}
