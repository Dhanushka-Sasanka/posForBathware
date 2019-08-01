/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.SRNDetailDAO;
import lk.posForBathware.model.entity.SRNDetail;

/**
 *
 * @author Danushka
 */
public class SRNDetaiDAOlImpl implements SRNDetailDAO{

    @Override
    public boolean add(SRNDetail entity) throws Exception {
        String sql = "INSERT into SRNDetail values (?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql,entity.getSrnId_FK(),entity.getBatchId_FK(),entity.getDiscription(),entity.getQty(),entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SRNDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SRNDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SRNDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
