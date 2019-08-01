/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.ItemDetailDTO;

/**
 *
 * @author Danushka
 */
public interface ItemDetailBO extends SuperBO {

    public boolean addItemDetail(ItemDetailDTO dto) throws Exception;

    public boolean deleteItemDetail(String id) throws Exception;

    public boolean updateItemDetail(ItemDetailDTO dto) throws Exception;

    public ItemDetailDTO searchItemDetail(String id) throws Exception;

    public ArrayList<ItemDetailDTO> getAllItemDetail() throws Exception;

    public ArrayList<String> getAllBatchIds(String itemCode) throws Exception;

    public ItemDetailDTO searchBatchAndItemCode(String itemCode, String batchId) throws Exception;
}
