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
public class ItemDetailDTO {

    private String itemCode;
    private String bacthId;
    private int qtyOnHand;

    public ItemDetailDTO() {
    }

    public ItemDetailDTO(String itemCode, String bacthId, int qtyOnHand) {
        this.itemCode = itemCode;
        this.bacthId = bacthId;
        this.qtyOnHand = qtyOnHand;
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
     * @return the bacthId
     */
    public String getBacthId() {
        return bacthId;
    }

    /**
     * @param bacthId the bacthId to set
     */
    public void setBacthId(String bacthId) {
        this.bacthId = bacthId;
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
