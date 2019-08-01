/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.CreditCustomerDAO;
import lk.posForBathware.model.entity.CreditCustomer;
import lk.posForBathware.model.entity.Supplier;

/**
 *
 * @author Danushka
 */
public class CreditCustomerDAOImpl implements CreditCustomerDAO {

    @Override
    public boolean add(CreditCustomer entity) throws Exception {
        String sql = "INSERT Into CCustomer values(?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getCustomerId_PK(), entity.getCustomerName(), entity.getNic(), entity.getTeleNo(), entity.getEmail());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE from CCustomer where customerId = ?";
        return CrudOperation.executeUpdate(sql, id);
    }

    @Override
    public CreditCustomer search(String id) throws Exception {
        CreditCustomer creditCustomer = null;
        String sql = "Select * from CCustomer where CustomerId = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        while (rst.next()) {
            creditCustomer = new CreditCustomer(
                    rst.getString("CustomerId"),
                    rst.getString("CustomerName"),
                    rst.getString("NIC"),
                    rst.getInt("teleNo"),
                    rst.getString("email"));
        }
        return creditCustomer;
    }

    @Override
    public boolean update(CreditCustomer entity) throws Exception {
        String sql = "UPDATE CCustomer set customerName = ? , nic = ? ,teleNo = ?, email = ? where CustomerID = ?";
        return CrudOperation.executeUpdate(sql, entity.getCustomerName(),
                entity.getNic(),
                entity.getTeleNo(),
                entity.getEmail(),
                entity.getCustomerId_PK());
    }

    @Override
    public ArrayList<CreditCustomer> getAll() throws Exception {
        ArrayList<CreditCustomer> customers = new ArrayList<>();

        String sql = "SELECT * from CCustomer";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            customers.add(new CreditCustomer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5)));
        }
        return customers;

    }

    @Override
    public CreditCustomer searchFromNic(String nic) throws Exception {
        CreditCustomer cus = null;
        String sql = "Select * from CCustomer where nic = ? ";
        ResultSet rst = CrudOperation.executeQuery(sql, nic);
        while (rst.next()) {
            cus = new CreditCustomer(
                    rst.getString("CustomerID"),
                    rst.getString("CustomerName"),
                    rst.getString("nic"),
                    rst.getInt("teleNo"),
                    rst.getString("Email"));
        }
        return cus;

    }

    @Override
    public ArrayList<String> getAllCreditCustomerIds() throws Exception {
        ArrayList<String> allCustomers = new ArrayList<>();
        String sql = "SELECT CustomerID from CCustomer";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {

            String customerIds = rst.getString("CustomerId");

            allCustomers.add(customerIds);
        }
        return allCustomers;

    }
}
