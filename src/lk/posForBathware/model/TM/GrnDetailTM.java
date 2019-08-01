/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.model.TM;

/**
 *
 * @author Danushka
 */
public class GrnDetailTM {

    private String batchID;
    private String grnID;
    private String itemCode;
    private String discription;
    private double unitPrice;
    private int qty;

    public GrnDetailTM() {
    }

    public GrnDetailTM(String batchID, String grnID, String itemCode, String discription, double unitPrice, int qty) {
        this.batchID = batchID;
        this.grnID = grnID;
        this.itemCode = itemCode;
        this.discription = discription;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    /**
     * @return the batchID
     */
    public String getBatchID() {
        return batchID;
    }

    /**
     * @param batchID the batchID to set
     */
    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    /**
     * @return the grnID
     */
    public String getGrnID() {
        return grnID;
    }

    /**
     * @param grnID the grnID to set
     */
    public void setGrnID(String grnID) {
        this.grnID = grnID;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the discription
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * @param discription the discription to set
     */
    public void setDiscription(String discription) {
        this.discription = discription;
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

}
