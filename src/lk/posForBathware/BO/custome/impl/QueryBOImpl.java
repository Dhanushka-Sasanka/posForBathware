/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.QueryExp;
import lk.posForBathware.BO.custome.QueryBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.dao.custome.QueryDAO;
import lk.posForBathware.model.DTO.CustomeDTO;
import lk.posForBathware.model.TM.ItemFormTM;

/**
 *
 * @author Danushka
 */
public class QueryBOImpl implements QueryBO {

    private QueryDAO queryDAO;

    public QueryBOImpl() {
        try {
            queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.QUERY);
        } catch (Exception ex) {
            Logger.getLogger(QueryBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CustomeDTO batchIdItemCodeJoin(String batchid) throws Exception {
        return queryDAO.batchIdItemCodeJoin(batchid);
    }

    @Override
    public ArrayList<ItemFormTM> allItemDetail() throws Exception {
         return queryDAO.allItemDetail();
    }

}
