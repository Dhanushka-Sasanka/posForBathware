/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.GRNDAO;
import lk.posForBathware.dao.custome.GRNDetailDAO;
import lk.posForBathware.model.entity.GRN;
import lk.posForBathware.model.entity.GRNDetail;

/**
 *
 * @author Danushka
 */
public class GRNDAOImple implements GRNDAO{

    @Override
    public boolean add(GRN entity) throws Exception {
    String sql = "INSERT into GRN values (?,?,?)"; 
    return CrudOperation.executeUpdate(sql, entity.getGrnId_PK(),entity.getDiscription(),entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GRN search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(GRN entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GRN> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
