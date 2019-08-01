/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.ItemDTO;

/**
 *
 * @author Danushka
 */
public interface ItemBO extends SuperBO{
    
    public boolean addItem(ItemDTO dto) throws Exception;

    public boolean deleteItem(String id) throws Exception;

    public boolean updateItem(ItemDTO dto) throws Exception;

    public ItemDTO searchItem(String id) throws Exception;

    public ArrayList<ItemDTO> getAllItem() throws Exception;
    
}
