/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.GRNDetailDAO;
import lk.posForBathware.model.entity.GRNDetail;

/**
 *
 * @author Danushka
 */
public class GRNDetailDAOImpl implements GRNDetailDAO {

    @Override
    public boolean add(GRNDetail entity) throws Exception {
        String sql = "INSERT into GRNDetail values (?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getGrnId_FK(), entity.getItemCode_FK(), entity.getQty(), entity.getUnitPrice(), entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GRNDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(GRNDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GRNDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
