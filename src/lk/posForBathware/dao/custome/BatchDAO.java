/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome;

import lk.posForBathware.dao.CrudDao;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.model.entity.Batch;

/**
 *
 * @author Danushka
 */
public interface BatchDAO extends CrudDao<Batch, String>{
    
    public String searchBatchId(String id)throws Exception;
}
