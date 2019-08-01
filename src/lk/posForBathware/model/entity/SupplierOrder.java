/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.model.entity;

import java.util.ArrayList;

/**
 *
 * @author Danushka
 */
public class SupplierOrder  {
    private String orderId;
    private ArrayList<SupplierOrderDetail>supplierOrderDetails;

    public SupplierOrder() {
    }

    public SupplierOrder(String orderId, ArrayList<SupplierOrderDetail> supplierOrderDetails) {
        this.orderId = orderId;
        this.supplierOrderDetails = supplierOrderDetails;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the supplierOrderDetails
     */
    public ArrayList<SupplierOrderDetail> getSupplierOrderDetails() {
        return supplierOrderDetails;
    }

    /**
     * @param supplierOrderDetails the supplierOrderDetails to set
     */
    public void setSupplierOrderDetails(ArrayList<SupplierOrderDetail> supplierOrderDetails) {
        this.supplierOrderDetails = supplierOrderDetails;
    }
    
    
}
