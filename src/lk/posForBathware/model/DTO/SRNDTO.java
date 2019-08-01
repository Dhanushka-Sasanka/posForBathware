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
public class SRNDTO {
     private String srnId;

    public SRNDTO() {
    }

    public SRNDTO(String srnId) {
        this.srnId = srnId;
    }

    /**
     * @return the srnId
     */
    public String getSrnId() {
        return srnId;
    }

    /**
     * @param srnId the srnId to set
     */
    public void setSrnId(String srnId) {
        this.srnId = srnId;
    }
    
}
