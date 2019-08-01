/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.BO.custome.ItemDetailBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.ItemDetailDAO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public class ItemDetailBOImpl implements ItemDetailBO {

    private ItemDetailDAO itemDetailDAO;

    public ItemDetailBOImpl() {
        try {
            itemDetailDAO = (ItemDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEMDETAIL);
        } catch (Exception ex) {
            Logger.getLogger(ItemDetailBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean addItemDetail(ItemDetailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItemDetail(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateItemDetail(ItemDetailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemDetailDTO searchItemDetail(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemDetailDTO> getAllItemDetail() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllBatchIds(String itemCode) throws Exception {
        return itemDetailDAO.getAllBatchIds(itemCode);
    }

    @Override
    public ItemDetailDTO searchBatchAndItemCode(String itemCode, String batchId) throws Exception {
        ItemDetail itemDetail = itemDetailDAO.searchBatchAndItemCode(itemCode, batchId);
        ItemDetailDTO item = new ItemDetailDTO(itemDetail.getItemCode_FK(), itemDetail.getBacthId_FK(), itemDetail.getQtyOnHand());
        return item;

    }

}
