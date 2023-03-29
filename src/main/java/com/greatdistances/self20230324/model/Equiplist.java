package com.greatdistances.self20230324.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equiplist extends AbstractEntity{

    // TODO @ManyToMany (list to items = one-to-many, items to lists = one-to-many also)

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="equiplist_item",
            joinColumns = {@JoinColumn(name="equiplist_id")},
            inverseJoinColumns = {@JoinColumn(name="item_id")})
    private List<Item> items = new ArrayList<Item>();

    private ArrayList<Item> equiplistInventory = new ArrayList<>(); // IS THIS CORRECT?

    private String jobNumber;

    private long itemCount;

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

    public long getItemCount() {
        return itemCount;
    }

    public void setItemCount(long itemCount) {
        this.itemCount = equiplistInventory.size(); // TODO size() will present problem for inv. items with multiple pieces.
    }
}
