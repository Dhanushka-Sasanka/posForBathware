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
public class ItemDetail {

    private String itemCode_FK;
    private String bacthId_FK;
    private int qtyOnHand;

    public ItemDetail() {
    }

    public ItemDetail(String itemCode_FK, String bacthId_FK, int qtyOnHand) {
        this.itemCode_FK = itemCode_FK;
        this.bacthId_FK = bacthId_FK;
        this.qtyOnHand = qtyOnHand;
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
     * @return the bacthId_FK
     */
    public String getBacthId_FK() {
        return bacthId_FK;
    }

    /**
     * @param bacthId_FK the bacthId_FK to set
     */
    public void setBacthId_FK(String bacthId_FK) {
        this.bacthId_FK = bacthId_FK;
    }

    /**
     * @return the qtyOnHand
     */
    public int getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    
}
