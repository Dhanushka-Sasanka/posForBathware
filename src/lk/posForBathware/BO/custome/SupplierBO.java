/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.SupplierDTO;
import lk.posForBathware.model.entity.Supplier;

/**
 *
 * @author Danushka
 */
public interface SupplierBO extends SuperBO {

    public boolean addSupplier(SupplierDTO dto) throws Exception;

    public boolean deleteSupplier(String id) throws Exception;

    public boolean updateSupplier(SupplierDTO dto) throws Exception;

    public SupplierDTO searchSupplier(String id) throws Exception;

    public ArrayList<SupplierDTO> getAllSupplier() throws Exception;

    public SupplierDTO searchFromNic(String nic) throws Exception;

}
