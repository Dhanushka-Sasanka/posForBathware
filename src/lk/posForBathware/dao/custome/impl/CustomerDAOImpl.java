/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.CustomerDAO;
import lk.posForBathware.model.entity.Customer;
import lk.posForBathware.model.entity.CustomerOrder;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer dto) throws Exception {
        String sql = "Insert Into Customer values (?)";
        return CrudOperation.executeUpdate(sql, dto.getCustomerId_PK());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer search(String dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Customer dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
