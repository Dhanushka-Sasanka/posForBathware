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
public class CustomeDTO {
    private String  BatchId ;
    private String  ItemCode ;
    private String  Discription ;
    private int  qtyOnhand ;
    private double  unitprice ;

    public CustomeDTO() {
    }

    public CustomeDTO(String BatchId, String ItemCode, String Discription, int qtyOnhand, double unitprice) {
        this.BatchId = BatchId;
        this.ItemCode = ItemCode;
        this.Discription = Discription;
        this.qtyOnhand = qtyOnhand;
        this.unitprice = unitprice;
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
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
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
     * @return the qtyOnhand
     */
    public int getQtyOnhand() {
        return qtyOnhand;
    }

    /**
     * @param qtyOnhand the qtyOnhand to set
     */
    public void setQtyOnhand(int qtyOnhand) {
        this.qtyOnhand = qtyOnhand;
    }

    /**
     * @return the unitprice
     */
    public double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    
    
}
