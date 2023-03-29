package com.greatdistances.self20230324.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Trip extends AbstractEntity {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="equiplist_trip",
            joinColumns = {@JoinColumn(name="trip_id")},
            inverseJoinColumns = {@JoinColumn(name="equiplist_id")})
    private List<Equiplist> items = new ArrayList<Equiplist>();

    //JOBNO FIELD IS OPTIONAL
    private String jobNumber;

    @NotEmpty(message="Required field.")
    @NotNull(message="Required field.")
    @Size(min=2, max=56, message="Character count must be between 2 and 60.")
    private String country;

    @NotNull(message="Required field.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date importDate;

    @NotNull(message="Required field.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date exportDate;

    // TRANSIT FIELD IS OPTIONAL
    private String transit;

    private boolean isEquipAttached;

    public Trip(String jobNumber, String country, Date importDate, Date exportDate, String transit, boolean isEquipAttached) {
        this.jobNumber = jobNumber;
        this.country = country;
        this.importDate = importDate;
        this.exportDate = exportDate;
        this.transit = transit;
        this.isEquipAttached = false;
    }

    public Trip() {
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public void setExportDate(Date exportDate) {
        this.exportDate = exportDate;
    }

    public String getTransit() {
        return transit;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public boolean isEquipAttached() {
        return isEquipAttached;
    }

    public void setEquipAttached(boolean equipAttached) {
        isEquipAttached = equipAttached;
    }
}
