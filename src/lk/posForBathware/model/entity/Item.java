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
public class Item {

    private String itemCode_PK;
    private String brand;
    private int qtyOnHand;
    private double unitPrice;
    private String description;

    public Item() {
    }

    public Item(String itemCode_PK, String brand, int qtyOnHand, double unitPrice, String description) {
        this.itemCode_PK = itemCode_PK;
        this.brand = brand;
        this.qtyOnHand = qtyOnHand;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    /**
     * @return the itemCode_PK
     */
    public String getItemCode_PK() {
        return itemCode_PK;
    }

    /**
     * @param itemCode_PK the itemCode_PK to set
     */
    public void setItemCode_PK(String itemCode_PK) {
        this.itemCode_PK = itemCode_PK;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
