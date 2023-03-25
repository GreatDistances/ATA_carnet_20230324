package com.greatdistances.self20230324.model;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item extends AbstractEntity {

    //private Category category; // TODO switch to list.
    //private Tag tags; // TODO switch to list.
    //private Trip trip; // TODO switch to list.

    @NotNull(message="Required field.")
    @Min(value=1, message="Minimum value is 1")
    private int pieces;

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
    private String country;

    @NotNull(message="Required field.")
    @Size(max=100, message="Character count must be less than 100.")
    private String serialNo;

    @NotNull(message="Required field.")
    @Size(min=2, max=30, message="Character count must be between 1 and 30.")
    private String owner;

    public Item() {
    }

    public Item(int pieces, double weightKgPerPiece, double valuePerPiece, String country, String serialNo, String owner) {
        this.pieces = pieces;
        this.weightKgPerPiece = weightKgPerPiece;
        this.weightKgTotal = getWeightKgTotal();
        this.valuePerPiece = valuePerPiece;
        this.valueTotal = getValueTotal();
        this.country = country;
        this.serialNo = serialNo;
        this.owner = owner;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
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

    public void setWeightKgTotal(double weightKgTotal) {
        this.weightKgTotal = weightKgTotal;
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

    public void setValueTotal(double valueTotal) {
        this.valueTotal = valueTotal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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