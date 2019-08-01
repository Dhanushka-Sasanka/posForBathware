/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import lk.posForBathware.BO.custome.SupplierBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.SupplierDAO;
import lk.posForBathware.model.DTO.SupplierDTO;
import lk.posForBathware.model.entity.Supplier;

/**
 *
 * @author Danushka
 */
public class SupplierBOImpl implements SupplierBO {

    private SupplierDAO supplierDAO;

    public SupplierBOImpl() throws Exception {

        supplierDAO = (SupplierDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.SUPPLIER);

    }

    @Override
    public boolean addSupplier(SupplierDTO dto) throws Exception {
        Supplier supplierRf = new Supplier(dto.getSupplierID(), dto.getSupplierName(), dto.getCompany(), dto.getNic(), dto.getTeleNo(), dto.getEmail());
        return supplierDAO.add(supplierRf);

    }

    @Override
    public boolean deleteSupplier(String id) throws Exception {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean updateSupplier(SupplierDTO dto) throws Exception {
        Supplier supplier = new Supplier(dto.getSupplierID(), dto.getSupplierName(), dto.getCompany(), dto.getNic(), dto.getTeleNo(), dto.getEmail());
        return supplierDAO.update(supplier);
    }

    @Override
    public SupplierDTO searchSupplier(String id) throws Exception {
        Supplier supplier = supplierDAO.search(id);
        SupplierDTO supplierDTO = new SupplierDTO(supplier.getSupplierId_PK(),supplier.getSupplierName(),supplier.getCompany(),supplier.getNic(),supplier.getTeleNo(),supplier.getEmail());
        return supplierDTO;
    }

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws Exception {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList<>();
        ArrayList<Supplier> all = supplierDAO.getAll();
        for (Supplier sup : all) {
            SupplierDTO supplierDTOref = new SupplierDTO(sup.getSupplierId_PK(), sup.getSupplierName(), sup.getCompany(), sup.getNic(), sup.getTeleNo(), sup.getEmail());
            allSuppliers.add(supplierDTOref);

        }
        return allSuppliers;
    }

    @Override
    public SupplierDTO searchFromNic(String nic) throws Exception {
        Supplier searchNic = supplierDAO.searchFromNic(nic);
        SupplierDTO dto = new SupplierDTO(searchNic.getSupplierId_PK(),searchNic.getSupplierName(),searchNic.getCompany(),searchNic.getNic(),searchNic.getTeleNo(),searchNic.getEmail());
        return dto;
    }

   
}
