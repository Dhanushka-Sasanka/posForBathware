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
public class GRN  {
    private String grnId_PK;
    private String discription;
    private String date;
   

    public GRN() {
    }

    public GRN(String grnId_PK, String discription, String date) {
        this.grnId_PK = grnId_PK;
        this.discription = discription;
        this.date = date;
    }

    /**
     * @return the grnId_PK
     */
    public String getGrnId_PK() {
        return grnId_PK;
    }

    /**
     * @param grnId_PK the grnId_PK to set
     */
    public void setGrnId_PK(String grnId_PK) {
        this.grnId_PK = grnId_PK;
    }

    /**
     * @return the discription
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * @param discription the discription to set
     */
    public void setDiscription(String discription) {
        this.discription = discription;
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
