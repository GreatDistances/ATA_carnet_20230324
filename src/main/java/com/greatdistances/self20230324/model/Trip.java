package com.greatdistances.self20230324.model;

import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Trip extends AbstractEntity {

    //JOBNO FIELD IS OPTIONAL
    private String jobNo;

    @NotNull(message="Required field.")
    @Size(min=2, max=56, message="Character count must be between 2 and 60.")
    private String country;

    @NotNull(message="Required field.")
    @Future(message="Equipment import date must be in the future.")
    private String importDate;

    @NotNull(message="Required field.")
    @Future(message="Equipment export date must be in the future.")
    private String exportDate;

    // TRANSIT FIELD IS OPTIONAL
    private String transit;

    public Trip(String jobNo, String country, String importDate, String exportDate, String transit) {
        this.jobNo = jobNo;
        this.country = country;
        this.importDate = importDate;
        this.exportDate = exportDate;
        this.transit = transit;
    }

    public Trip() {
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }
}
