/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.model.entity;

/**
 *
 * @author Danushka
 */
public class Batch {

    private String batchID_PK;
    private double unitPrice;

    public Batch() {
    }

    public Batch(String batchID_PK, double unitPrice) {
        this.batchID_PK = batchID_PK;
        this.unitPrice = unitPrice;
    }

    /**
     * @return the batchID_PK
     */
    public String getBatchID_PK() {
        return batchID_PK;
    }

    /**
     * @param batchID_PK the batchID_PK to set
     */
    public void setBatchID_PK(String batchID_PK) {
        this.batchID_PK = batchID_PK;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

}
