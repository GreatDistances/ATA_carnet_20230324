package com.greatdistances.self20230324.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Equiplist extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="trip_id")
    @NotNull(message="Required field.")
    private Trip trip;

    //TODO add List<Item>, @ManyToMany

    public Equiplist() {
    }

    public Equiplist(String name, Trip trip) {
        this.trip = trip;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
