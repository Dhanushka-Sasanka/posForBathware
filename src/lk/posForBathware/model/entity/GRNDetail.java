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
public class GRNDetail  {
    private String grnId_FK;
    private String itemCode_FK;
    private int qty;
    private double unitPrice;
    private String date;

    public GRNDetail() {
    }

    public GRNDetail(String grnId_FK, String itemCode_FK, int qty, double unitPrice, String date) {
        this.grnId_FK = grnId_FK;
        this.itemCode_FK = itemCode_FK;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.date = date;
    }

    /**
     * @return the grnId_FK
     */
    public String getGrnId_FK() {
        return grnId_FK;
    }

    /**
     * @param grnId_FK the grnId_FK to set
     */
    public void setGrnId_FK(String grnId_FK) {
        this.grnId_FK = grnId_FK;
    }

    /**
     * @return the itemCode_FK
     */
    public String getItemCode_FK() {
        return itemCode_FK;
    }

    /**
     * @param itemCode_FK the itemCode_FK to set
     */
    public void setItemCode_FK(String itemCode_FK) {
        this.itemCode_FK = itemCode_FK;
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
