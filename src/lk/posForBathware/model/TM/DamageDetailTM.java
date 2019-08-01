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
public class DamageDetailTM {

    private String damageID;
    private String itemCode;
    private String discription;
    private int qty;
    private String date;

    public DamageDetailTM() {
    }

    public DamageDetailTM(String damageID, String itemCode, String discription, int qty, String date) {
        this.damageID = damageID;
        this.itemCode = itemCode;
        this.discription = discription;
        this.qty = qty;
        this.date = date;
    }

    /**
     * @return the damageID
     */
    public String getDamageID() {
        return damageID;
    }

    /**
     * @param damageID the damageID to set
     */
    public void setDamageID(String damageID) {
        this.damageID = damageID;
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
