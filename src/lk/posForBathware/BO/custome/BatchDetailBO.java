/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.BatchDetailDTO;

/**
 *
 * @author Danushka
 */
public interface BatchDetailBO extends SuperBO {

    public boolean addBatchDetail(BatchDetailDTO dto) throws Exception;

    public boolean deleteBatchDetail(String id) throws Exception;

    public boolean updateBatchDetail(BatchDetailDTO dto) throws Exception;

    public BatchDetailDTO searchBatchDetail(String id) throws Exception;

    public ArrayList<BatchDetailDTO> getAllBatchDetail() throws Exception;
}
