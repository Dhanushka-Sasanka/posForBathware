/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome;

import java.util.ArrayList;
import lk.posForBathware.dao.CrudDao;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public interface ItemDetailDAO extends CrudDao<ItemDetail, String> {

    public ArrayList<String> getAllBatchIds(String itemCode) throws Exception;

    public ItemDetail searchBatchAndItemCode(String itemCode, String batchId) throws Exception;

    public boolean updateFromItemCode(ItemDetail entity) throws Exception;
}
