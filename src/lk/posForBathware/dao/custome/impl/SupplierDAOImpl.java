/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudDao;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.SupplierDAO;
import lk.posForBathware.model.entity.Supplier;

/**
 *
 * @author Danushka
 */
public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean add(Supplier entity) throws Exception {
        String sql = "INSERT INTO Supplier values(?,?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getSupplierId_PK(), entity.getSupplierName(), entity.getCompany(), entity.getNic(), entity.getTeleNo(), entity.getEmail());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE from Supplier where supplierID = ?";
        return CrudOperation.executeUpdate(sql, id);

    }

    @Override
    public Supplier search(String id) throws Exception {
        Supplier supplier = null;
        String sql = " select * from Supplier where SupplierID = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        while (rst.next()) {
            supplier = new Supplier(rst.getString("SupplierID"), rst.getString("SuplierName"), rst.getString("company"), rst.getString("NIC"), rst.getInt("TeleNO"), rst.getString("email"));

        }
        return supplier;

    }

    @Override
    public boolean update(Supplier entity) throws Exception {
        String sql = "Update Supplier Set SuplierName = ?,company = ? , nic = ? ,teleNO =?,email = ? where SupplierID = ? ";
        return CrudOperation.executeUpdate(sql, entity.getSupplierName(), entity.getCompany(), entity.getNic(), entity.getTeleNo(), entity.getEmail(), entity.getSupplierId_PK());
    }

    @Override
    public ArrayList<Supplier> getAll() throws Exception {
        ArrayList<Supplier> allSuppliers = new ArrayList<>();
        String sql = "SELECT * from Supplier";

        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            Supplier supplier = new Supplier();

            supplier.setSupplierId_PK((rst.getString("SupplierID")));
            supplier.setSupplierName(rst.getString("SuplierName"));
            supplier.setCompany(rst.getString("Company"));
            supplier.setNic(rst.getString("nic"));
            supplier.setTeleNo(Integer.parseInt(rst.getString("teleNo")));
            supplier.setEmail(rst.getString("email"));
            allSuppliers.add(supplier);

        }
        return allSuppliers;
    }

    @Override
    public Supplier searchFromNic(String nic) throws Exception {
        Supplier sup = null;
        String sql = "Select * from supplier where nic = ? ";
        ResultSet rst = CrudOperation.executeQuery(sql, nic);
        while (rst.next()) {
            sup = new Supplier(
                    rst.getString("SupplierID"),
                    rst.getString("SuplierName"),
                    rst.getString("company"),
                    rst.getString("nic"),
                    rst.getInt("teleNo"),
                    rst.getString("Email"));

        }
        return sup;
    }

}
