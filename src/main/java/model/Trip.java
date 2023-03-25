package model;

import javax.persistence.Entity;

@Entity
public class Trip extends AbstractEntity {

    private String jobNo;
    private String country;
    private String importDate;
    private String exportDate;
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
