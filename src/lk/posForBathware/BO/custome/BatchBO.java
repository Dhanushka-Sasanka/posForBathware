/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.entity.CreditCustomer;

/**
 *
 * @author Danushka
 */
public interface BatchBO extends SuperBO {

    public boolean addBatch(BatchDTO dto) throws Exception;

    public boolean deleteBatch(String id) throws Exception;

    public boolean updateBatch(BatchDTO dto) throws Exception;

    public BatchDTO searchBatch(String id) throws Exception;

    public ArrayList<BatchDTO> getAllBatch() throws Exception;

}
