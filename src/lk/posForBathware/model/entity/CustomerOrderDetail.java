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
public class CustomerOrderDetail  {

    private String batchId_FK;
    private String invoiceNo_FK;
    private int qty;
    private double unitPrice;
    private double amount;
    private String date;

    public CustomerOrderDetail() {
    }

    public CustomerOrderDetail(String batchId_FK, String invoiceNo_FK, int qty, double unitPrice, double amount, String date) {
        this.batchId_FK = batchId_FK;
        this.invoiceNo_FK = invoiceNo_FK;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.date = date;
    }

    /**
     * @return the batchId_FK
     */
    public String getBatchId_FK() {
        return batchId_FK;
    }

    /**
     * @param batchId_FK the batchId_FK to set
     */
    public void setBatchId_FK(String batchId_FK) {
        this.batchId_FK = batchId_FK;
    }

    /**
     * @return the invoiceNo_FK
     */
    public String getInvoiceNo_FK() {
        return invoiceNo_FK;
    }

    /**
     * @param invoiceNo_FK the invoiceNo_FK to set
     */
    public void setInvoiceNo_FK(String invoiceNo_FK) {
        this.invoiceNo_FK = invoiceNo_FK;
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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
