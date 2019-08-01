/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.entity.CreditCustomer;

/**
 *
 * @author Danushka
 */
public interface CreditCustomerBO extends SuperBO {

    public boolean addCustomer(CreditCustomer dto) throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean updateCustomer(CreditCustomer dto) throws Exception;

    public CreditCustomer searchCustomer(String id) throws Exception;

    public ArrayList<CreditCustomer> getAllCreditCustomer() throws Exception;

    public CreditCustomer searchFromNic(String nic) throws Exception;

    public ArrayList<String> getAllCreditCustomerIds() throws Exception;
}
