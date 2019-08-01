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
public class Customer {

    private String customerId_PK;

    public Customer() {
    }

    public Customer(String customerId_PK) {
        this.customerId_PK = customerId_PK;
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

}
