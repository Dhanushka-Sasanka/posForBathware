/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome;

import java.util.ArrayList;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.model.DTO.CustomeDTO;
import lk.posForBathware.model.TM.ItemFormTM;

/**
 *
 * @author Danushka
 */
public interface QueryDAO extends SuperDAO {

    public CustomeDTO batchIdItemCodeJoin(String itemcode) throws Exception;
//    public CustomeDTO batchIdItemCodeJoin(String itemcode) throws Exception;
    public ArrayList<ItemFormTM> allItemDetail()throws Exception;
}
