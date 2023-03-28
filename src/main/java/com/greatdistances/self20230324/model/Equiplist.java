package com.greatdistances.self20230324.model;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Equiplist extends AbstractEntity{

    // TODO @ManyToMany (list to items = one-to-many, items to lists = one-to-many also)

    private ArrayList<Item> equiplistInventory = new ArrayList<>(); // IS THIS CORRECT?

    private String jobNumber;

    private int itemCount;

    public Equiplist(ArrayList<Item> equiplistInventory, String jobNumber) {
        this.equiplistInventory = equiplistInventory;
        this.jobNumber = jobNumber;
    }

    public Equiplist() {
    }

    public ArrayList<Item> getListInventory() {
        return equiplistInventory;
    }

    public void setListInventory(ArrayList<Item> listInventory) {
        this.equiplistInventory = listInventory;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = equiplistInventory.size(); // TODO size() will present problem for inv. items with multiple pieces.
    }
}
