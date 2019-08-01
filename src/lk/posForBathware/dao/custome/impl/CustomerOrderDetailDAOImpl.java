/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.CustomerOrderDetailDAO;
import lk.posForBathware.model.entity.CustomerOrderDetail;

/**
 *
 * @author Danushka
 */
public class CustomerOrderDetailDAOImpl implements CustomerOrderDetailDAO {

    @Override
    public boolean add(CustomerOrderDetail entity) throws Exception {
        String sql = "INSERT into OrderDetail values (?,?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql,entity.getBatchId_FK(),entity.getInvoiceNo_FK(),entity.getQty(),entity.getUnitPrice(),entity.getAmount(),entity.getDate());
        
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerOrderDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CustomerOrderDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerOrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
