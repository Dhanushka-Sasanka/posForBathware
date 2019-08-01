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
public class Payment  {
    private String pamentId;
    private double amount;
    private String invoiceNo;
    private String date;

    public Payment() {
    }

    public Payment(String pamentId, double amount, String invoiceNo, String date) {
        this.pamentId = pamentId;
        this.amount = amount;
        this.invoiceNo = invoiceNo;
        this.date = date;
    }

    /**
     * @return the pamentId
     */
    public String getPamentId() {
        return pamentId;
    }

    /**
     * @param pamentId the pamentId to set
     */
    public void setPamentId(String pamentId) {
        this.pamentId = pamentId;
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
     * @return the invoiceNo
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiceNo to set
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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
