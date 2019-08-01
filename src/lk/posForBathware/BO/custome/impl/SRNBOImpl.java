/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.SRNBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.SRNDAO;
import lk.posForBathware.model.DTO.SRNDTO;
import lk.posForBathware.model.entity.SRN;

/**
 *
 * @author Danushka
 */
public class SRNBOImpl implements SRNBO {

    private SRNDAO srnBO;

    public SRNBOImpl() {
        try {
            srnBO = (SRNDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.SRN);
        } catch (Exception ex) {
            Logger.getLogger(SRNBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean addSRN(SRNDTO dto) throws Exception {
        SRN srn = new SRN(dto.getSrnId());
        return srnBO.add(srn);
    }

    @Override
    public boolean deleteSRN(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSRN(SRNDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SRNDTO searchSRN(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SRNDTO> getAllSRN() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
