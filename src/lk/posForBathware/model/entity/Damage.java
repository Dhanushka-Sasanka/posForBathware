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
public class Damage  {

    private String damageId;
    private String date;
    

    public Damage() {
    }

    public Damage(String damageId, String date) {
        this.damageId = damageId;
        this.date = date;
    }

    /**
     * @return the damageId
     */
    public String getDamageId() {
        return damageId;
    }

    /**
     * @param damageId the damageId to set
     */
    public void setDamageId(String damageId) {
        this.damageId = damageId;
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
