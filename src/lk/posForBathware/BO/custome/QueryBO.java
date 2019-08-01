/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.CustomeDTO;
import lk.posForBathware.model.TM.ItemFormTM;

/**
 *
 * @author Danushka
 */
public interface QueryBO extends SuperBO {

    public CustomeDTO batchIdItemCodeJoin(String batchid) throws Exception;
    
    public ArrayList<ItemFormTM> allItemDetail()throws Exception;

}
