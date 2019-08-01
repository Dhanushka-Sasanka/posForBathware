/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.BatchDAO;
import lk.posForBathware.model.entity.Batch;

/**
 *
 * @author Danushka
 */
public class BatchDAOImpl implements BatchDAO {

    @Override
    public boolean add(Batch entity) throws Exception {
        String sql = "INSERT into Batch values(?,?)";
        return CrudOperation.executeUpdate(sql, entity.getBatchID_PK(), entity.getUnitPrice());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Batch search(String id) throws Exception {
         Batch batch  = null;
        String sql = "SELECT * from Batch where batchId = ? ";
        ResultSet rst = CrudOperation.executeQuery(sql,id);
        while(rst.next()){
         batch = new Batch(rst.getString("BatchId"), rst.getDouble("Unitprice"));
        }
        return batch;
        
    }

    @Override
    public boolean update(Batch entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Batch> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String searchBatchId(String id) throws Exception {
        String batchId = null;
        String sql = "Select BatchId from batch where batchid = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        if (rst.next()) {
            batchId = rst.getString("BatchId");
        }
        return batchId;
    }

}
