/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.CustomerDAO;
import lk.posForBathware.dao.custome.CustomerOrderDAO;
import lk.posForBathware.model.entity.CreditCustomer;
import lk.posForBathware.model.entity.Customer;
import lk.posForBathware.model.entity.CustomerOrder;

/**
 *
 * @author Danushka
 */
public class CustomerOrderDAOImpl implements CustomerOrderDAO {

    @Override
    public boolean add(CustomerOrder entity) throws Exception {
        String sql = "INSERT into CustomerOrder(InvoiceNO ,date ,customerID , CCustomerId  ) values(?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getInvoiceNo_PK(), entity.getDate(), entity.getCutomerId(), entity.getCCustomerId());

    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerOrder search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CustomerOrder entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerOrder> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
