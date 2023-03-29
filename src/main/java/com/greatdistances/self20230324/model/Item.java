package com.greatdistances.self20230324.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item extends AbstractEntity {

    @ManyToMany(mappedBy = "equiplist", cascade = CascadeType.ALL)
    private List<Equiplist> equiplists = new ArrayList<Equiplist>();

    //private Category category; // TODO switch to list.

    @NotNull(message="Required field.")
    @Min(value=1, message="Minimum value is 1")
    private long pieces;

    @NotNull(message="Required field.")
    @DecimalMin(value="0.1", message="Minimum possible value is 0.1 kg.")
    private double weightKgPerPiece;

    private double weightKgTotal;
    @NotNull(message="Required field.")
    @Min(value=0, message="Minimum possible value is zero.")
    private double valuePerPiece;
    private double valueTotal;

    @NotNull(message="Required field.")
    @Size(min=2, max=56, message="Character count must be between 2 and 60.")
    private String origin;

    //     @NotNull(message="Required field.")
    @Size(max=100, message="Character count must be less than 100.")
    private String serialNo;

    @NotNull(message="Required field.")
    @Size(min=2, max=30, message="Character count must be between 1 and 30.")
    private String owner;

    public Item() {
    }

    public Item(long pieces, double weightKgPerPiece, double valuePerPiece, String origin, String serialNo, String owner) {
        this.pieces = pieces;
        this.weightKgPerPiece = weightKgPerPiece;
        this.weightKgTotal = getWeightKgTotal();
        this.valuePerPiece = valuePerPiece;
        this.valueTotal = getValueTotal();
        this.origin = origin;
        this.serialNo = serialNo;
        this.owner = owner;
    }

    public long getPieces() {
        return pieces;
    }

    public void setPieces(long pieces) {
        this.pieces = pieces;
    }

    public double getWeightKgPerPiece() {
        return weightKgPerPiece;
    }

    public void setWeightKgPerPiece(double weightKgPerPiece) {
        this.weightKgPerPiece = weightKgPerPiece;
    }

    public double getWeightKgTotal() {
        return weightKgTotal;
    }

    public void setWeightKgTotal(double weightKgPerPiece, long pieces) {
        this.weightKgTotal = weightKgPerPiece * pieces;
    }

    public double getValuePerPiece() {
        return valuePerPiece;
    }

    public void setValuePerPiece(double valuePerPiece) {
        this.valuePerPiece = valuePerPiece;
    }

    public double getValueTotal() {
        return valueTotal;
    }

    public void setValueTotal(double valuePerPiece, long pieces) {
        this.valueTotal = valuePerPiece * pieces;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}