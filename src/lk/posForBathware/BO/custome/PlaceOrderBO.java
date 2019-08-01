/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.CustomerOrderDTO;
import lk.posForBathware.model.DTO.CustomerOrderDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;

/**
 *
 * @author Danushka
 */
public interface PlaceOrderBO extends SuperBO {

    public boolean addPlaceOrder(CustomerOrderDTO order, ArrayList<CustomerOrderDetailDTO> orderDetails,ArrayList<BatchDTO> batch,ArrayList<ItemDetailDTO>itemDetails ,ArrayList<ItemDTO> item) throws Exception;

}
