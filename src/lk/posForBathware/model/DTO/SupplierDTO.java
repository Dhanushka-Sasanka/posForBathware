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
public class SupplierDTO {

    private String SupplierID;
    private String supplierName;
    private String company;
    private String nic;
    private int teleNo;
    private String email;

    public SupplierDTO() {
    }

    public SupplierDTO(String SupplierID, String supplierName, String company, String nic, int teleNo, String email) {
        this.SupplierID = SupplierID;
        this.supplierName = supplierName;
        this.company = company;
        this.nic = nic;
        this.teleNo = teleNo;
        this.email = email;
    }

    /**
     * @return the SupplierID
     */
    public String getSupplierID() {
        return SupplierID;
    }

    /**
     * @param SupplierID the SupplierID to set
     */
    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
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
