/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome;

import lk.posForBathware.dao.CrudDao;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.model.entity.Batch;
import lk.posForBathware.model.entity.BatchDetail;
import lk.posForBathware.model.entity.Item;

/**
 *
 * @author Danushka
 */
public interface ItemDAO extends CrudDao<Item, String> {

    public String searchItemCode(String id) throws Exception;

}
