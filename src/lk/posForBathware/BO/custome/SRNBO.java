/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.SRNDTO;

/**
 *
 * @author Danushka
 */
public interface SRNBO  extends SuperBO{

    public boolean addSRN(SRNDTO dto) throws Exception;

    public boolean deleteSRN(String id) throws Exception;

    public boolean updateSRN(SRNDTO dto) throws Exception;

    public SRNDTO searchSRN(String id) throws Exception;

    public ArrayList<SRNDTO> getAllSRN() throws Exception;

}
