/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.BO.custome.CreditCustomerBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.CreditCustomerDAO;
import lk.posForBathware.model.entity.CreditCustomer;

/**
 *
 * @author Danushka
 */
public class CreditCustomerBOImpl implements CreditCustomerBO{
    private CreditCustomerDAO customerDAO;

    public CreditCustomerBOImpl() throws Exception {
         customerDAO =   (CreditCustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.CREDITCUSTOMER); 
         
    }

    @Override
    public boolean addCustomer(CreditCustomer dto) throws Exception {
        return customerDAO.add(dto);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CreditCustomer dto) throws Exception {
        return customerDAO.update(dto);
          }

    @Override
    public CreditCustomer searchCustomer(String id) throws Exception {
        return customerDAO.search(id);
    }

    @Override
    public ArrayList<CreditCustomer> getAllCreditCustomer() throws Exception {
        return customerDAO.getAll();
    }

    @Override
    public CreditCustomer searchFromNic(String nic) throws Exception {
        return customerDAO.searchFromNic(nic);
    }

    @Override
    public ArrayList<String> getAllCreditCustomerIds() throws Exception {
           return customerDAO.getAllCreditCustomerIds();
    }

}


    