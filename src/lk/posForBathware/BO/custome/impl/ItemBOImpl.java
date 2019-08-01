/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.ItemBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.dao.custome.ItemDAO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.entity.Item;

/**
 *
 * @author Danushka
 */
public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO;

    public ItemBOImpl() {
        try {
            itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEM);
        } catch (Exception ex) {
            Logger.getLogger(ItemBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean addItem(ItemDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItem(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemDTO searchItem(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws Exception {
        ArrayList<ItemDTO> itemList = new ArrayList<>();
        ArrayList<Item> all = itemDAO.getAll();
        for (Item item : all) {
            ItemDTO itemDTO = new ItemDTO(item.getItemCode_PK(), item.getBrand(), item.getQtyOnHand(), item.getUnitPrice(), item.getDescription());
            itemList.add(itemDTO);
        }
        return itemList;

    }

}
