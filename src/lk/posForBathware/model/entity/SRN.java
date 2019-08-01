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
public class SRN  {
    private String srnId_PK;
   

    public SRN() {
    }

    public SRN(String srnId_PK) {
        this.srnId_PK = srnId_PK;
    }

    /**
     * @return the srnId_PK
     */
    public String getSrnId_PK() {
        return srnId_PK;
    }

    /**
     * @param srnId_PK the srnId_PK to set
     */
    public void setSrnId_PK(String srnId_PK) {
        this.srnId_PK = srnId_PK;
    }

   
    
}
