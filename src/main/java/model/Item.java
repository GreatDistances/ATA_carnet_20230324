package model;

import javax.persistence.Entity;

@Entity
public class Item extends AbstractEntity {

    private Category category; // TODO switch to list.

    //private Tag tags; // TODO switch to list.
    //private Trip trip; // TODO switch to list.
    private int pieces;
    private double weightKgPerPiece;
    private double weightKgTotal;
    private double valuePerPiece;
    private double valueTotal;
    private String country;
    private String serialNo;

    public Item() {
    }

    public Item(int pieces, double weightKgPerPiece, double valuePerPiece, String country, String serialNo) {
        this.pieces = pieces;
        this.weightKgPerPiece = weightKgPerPiece;
        this.weightKgTotal = getWeightKgTotal();
        this.valuePerPiece = valuePerPiece;
        this.valueTotal = valuePerPiece * pieces;
        this.country = country;
        this.serialNo = serialNo;
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
        return weightKgPerPiece * pieces;
    }

    public void setWeightTotal(double weightKgPerPiece, int pieces) {
        this.weightKgTotal = weightKgPerPiece * pieces;
    }

    public double getValuePerPiece() {
        return valuePerPiece;
    }

    public void setValuePerPiece(double valuePerPiece) {
        this.valuePerPiece = valuePerPiece;
    }

    public double getValueTotal() {
        return valuePerPiece * pieces;
    }

    public void setValueTotal(double valuePerPiece, int pieces) {
        this.valueTotal = valuePerPiece * pieces;
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
}