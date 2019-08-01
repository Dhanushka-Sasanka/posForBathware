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
public class SupplierOrderDetail  {
    private String OrderId;
    private String itemCode;
    private String qty;

    public SupplierOrderDetail() {
    }

    public SupplierOrderDetail(String OrderId, String itemCode, String qty) {
        this.OrderId = OrderId;
        this.itemCode = itemCode;
        this.qty = qty;
    }

    /**
     * @return the OrderId
     */
    public String getOrderId() {
        return OrderId;
    }

    /**
     * @param OrderId the OrderId to set
     */
    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
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
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }
    
    
    
}
