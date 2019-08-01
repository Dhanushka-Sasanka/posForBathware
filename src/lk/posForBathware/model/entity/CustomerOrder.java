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
public class CustomerOrder {

    private String invoiceNo_PK;
    private String date;
    private String CutomerId;
    private String CCustomerId;

    public CustomerOrder() {
    }

    public CustomerOrder(String invoiceNo_PK, String date, String CutomerId, String CCustomerId) {
        this.invoiceNo_PK = invoiceNo_PK;
        this.date = date;
        this.CutomerId = CutomerId;
        this.CCustomerId = CCustomerId;
    }

    /**
     * @return the invoiceNo_PK
     */
    public String getInvoiceNo_PK() {
        return invoiceNo_PK;
    }

    /**
     * @param invoiceNo_PK the invoiceNo_PK to set
     */
    public void setInvoiceNo_PK(String invoiceNo_PK) {
        this.invoiceNo_PK = invoiceNo_PK;
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

    /**
     * @return the CutomerId
     */
    public String getCutomerId() {
        return CutomerId;
    }

    /**
     * @param CutomerId the CutomerId to set
     */
    public void setCutomerId(String CutomerId) {
        this.CutomerId = CutomerId;
    }

    /**
     * @return the CCustomerId
     */
    public String getCCustomerId() {
        return CCustomerId;
    }

    /**
     * @param CCustomerId the CCustomerId to set
     */
    public void setCCustomerId(String CCustomerId) {
        this.CCustomerId = CCustomerId;
    }

   
}
