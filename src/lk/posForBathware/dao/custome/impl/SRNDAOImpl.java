/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.SRNDAO;
import lk.posForBathware.model.entity.SRN;

/**
 *
 * @author Danushka
 */
public class SRNDAOImpl implements SRNDAO{

    @Override
    public boolean add(SRN entity) throws Exception {
        String sql = "INSERT into SRN values(?)";
        return CrudOperation.executeUpdate(sql,entity.getSrnId_PK());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SRN search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SRN entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SRN> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
