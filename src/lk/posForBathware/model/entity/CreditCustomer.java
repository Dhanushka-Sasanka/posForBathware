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
public class CreditCustomer {

    private String customerId_PK;
    private String customerName;
    private String nic;
    private int teleNo;
    private String email;

    public CreditCustomer() {
    }

    public CreditCustomer(String customerId_PK, String customerName, String nic, int teleNo, String email) {
        this.customerId_PK = customerId_PK;
        this.customerName = customerName;
        this.nic = nic;
        this.teleNo = teleNo;
        this.email = email;
    }

    /**
     * @return the customerId_PK
     */
    public String getCustomerId_PK() {
        return customerId_PK;
    }

    /**
     * @param customerId_PK the customerId_PK to set
     */
    public void setCustomerId_PK(String customerId_PK) {
        this.customerId_PK = customerId_PK;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the teleNo
     */
    public int getTeleNo() {
        return teleNo;
    }

    /**
     * @param teleNo the teleNo to set
     */
    public void setTeleNo(int teleNo) {
        this.teleNo = teleNo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
