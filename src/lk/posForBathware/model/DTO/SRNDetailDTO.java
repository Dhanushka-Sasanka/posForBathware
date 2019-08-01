/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.model.DTO;

/**
 *
 * @author Danushka
 */
public class SRNDetailDTO {

    private String srnId;
    private String BatchId;
    private String Discription;
    private int qty;
    private String date;

    public SRNDetailDTO(String srnId, String BatchId, String Discription, int qty, String date) {
        this.srnId = srnId;
        this.BatchId = BatchId;
        this.Discription = Discription;
        this.qty = qty;
        this.date = date;
    }

    public SRNDetailDTO() {
    }

    /**
     * @return the srnId
     */
    public String getSrnId() {
        return srnId;
    }

    /**
     * @param srnId the srnId to set
     */
    public void setSrnId(String srnId) {
        this.srnId = srnId;
    }

    /**
     * @return the BatchId
     */
    public String getBatchId() {
        return BatchId;
    }

    /**
     * @param BatchId the BatchId to set
     */
    public void setBatchId(String BatchId) {
        this.BatchId = BatchId;
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
