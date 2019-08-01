/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.GRNDTO;

/**
 *
 * @author Danushka
 */
public interface GRNBO extends SuperBO {

    public boolean addGRN(GRNDTO dto) throws Exception;

    public boolean deleteGRN(String id) throws Exception;

    public boolean updateGRN(GRNDTO dto) throws Exception;

    public GRNDTO searchGRN(String id) throws Exception;

    public ArrayList<GRNDTO> getAllGRN() throws Exception;

}
