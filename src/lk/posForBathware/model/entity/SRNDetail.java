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
public class SRNDetail  {
    private String srnId_FK;
    private String BatchId_FK;
    private String Discription;
    private int qty;
    private String date;

    public SRNDetail() {
    }

    public SRNDetail(String srnId_FK, String BatchId_FK, String Discription, int qty, String date) {
        this.srnId_FK = srnId_FK;
        this.BatchId_FK = BatchId_FK;
        this.Discription = Discription;
        this.qty = qty;
        this.date = date;
    }

    /**
     * @return the srnId_FK
     */
    public String getSrnId_FK() {
        return srnId_FK;
    }

    /**
     * @param srnId_FK the srnId_FK to set
     */
    public void setSrnId_FK(String srnId_FK) {
        this.srnId_FK = srnId_FK;
    }

    /**
     * @return the BatchId_FK
     */
    public String getBatchId_FK() {
        return BatchId_FK;
    }

    /**
     * @param BatchId_FK the BatchId_FK to set
     */
    public void setBatchId_FK(String BatchId_FK) {
        this.BatchId_FK = BatchId_FK;
    }

    /**
     * @return the Discription
     */
    public String getDiscription() {
        return Discription;
    }

    /**
     * @param Discription the Discription to set
     */
    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    
    
}
