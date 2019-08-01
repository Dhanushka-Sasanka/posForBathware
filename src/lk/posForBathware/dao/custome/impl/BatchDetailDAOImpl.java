/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.dao.custome.BatchDetailDAO;
import lk.posForBathware.model.entity.Batch;
import lk.posForBathware.model.entity.BatchDetail;

/**
 *
 * @author Danushka
 */
public class BatchDetailDAOImpl implements BatchDetailDAO {

    @Override
    public boolean add(BatchDetail entity) throws Exception {
        String sql = "INSERT into BatchDetail values(?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getBatchId_FK(), entity.getGrnId_FK(), entity.getQty(), entity.getUnitPrice(), entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(BatchDetail entity) throws Exception {
        String sql = "UPDATE batchDetail set qty = ? where BatchId = ?";
        return CrudOperation.executeUpdate(sql, entity.getQty(),entity.getBatchId_FK());
    }

    @Override
    public ArrayList<BatchDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
