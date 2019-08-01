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
public class DamageDetail {

    private String damageId_FK;
    private String itemCode_FK;
    private String discription;
    private int qty;
    private String date;

    public DamageDetail() {
    }

    public DamageDetail(String damageId_FK, String itemCode_FK, String discription, int qty, String date) {
        this.damageId_FK = damageId_FK;
        this.itemCode_FK = itemCode_FK;
        this.discription = discription;
        this.qty = qty;
        this.date = date;
    }

    /**
     * @return the damageId_FK
     */
    public String getDamageId_FK() {
        return damageId_FK;
    }

    /**
     * @param damageId_FK the damageId_FK to set
     */
    public void setDamageId_FK(String damageId_FK) {
        this.damageId_FK = damageId_FK;
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
