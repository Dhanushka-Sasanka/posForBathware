/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudDao;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.model.entity.Batch;
import lk.posForBathware.model.entity.BatchDetail;
import lk.posForBathware.model.entity.CreditCustomer;
import lk.posForBathware.model.entity.Supplier;

/**
 *
 * @author Danushka
 */
public interface CreditCustomerDAO extends CrudDao<CreditCustomer, String>{
    
    public CreditCustomer searchFromNic(String nic) throws Exception;
    
     public ArrayList<String> getAllCreditCustomerIds() throws Exception;
    
}
