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
public class CustomerOrderDTO {

    private String invoiceNo;
    private String date;
    private String CutomerId;
    private String CCustomerId;

    public CustomerOrderDTO() {
    }

    public CustomerOrderDTO(String invoiceNo, String date, String CutomerId, String CCustomerId) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.CutomerId = CutomerId;
        this.CCustomerId = CCustomerId;
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
