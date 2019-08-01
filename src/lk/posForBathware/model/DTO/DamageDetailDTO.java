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
public class DamageDetailDTO {

    private String damageId;
    private String itemCode;
    private String discription;
    private int qty;
    private String date;

    public DamageDetailDTO() {
    }

    public DamageDetailDTO(String damageId, String itemCode, String discription, int qty, String date) {
        this.damageId = damageId;
        this.itemCode = itemCode;
        this.discription = discription;
        this.qty = qty;
        this.date = date;
    }

    /**
     * @return the damageId
     */
    public String getDamageId() {
        return damageId;
    }

    /**
     * @param damageId the damageId to set
     */
    public void setDamageId(String damageId) {
        this.damageId = damageId;
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
