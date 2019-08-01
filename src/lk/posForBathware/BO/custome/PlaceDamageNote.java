/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.DamageDTO;
import lk.posForBathware.model.DTO.DamageDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;

/**
 *
 * @author Danushka
 */
public interface PlaceDamageNote extends SuperBO {

    public boolean addDamageNote(ArrayList<DamageDTO> damageDTO, ArrayList<DamageDetailDTO> damageDetailList, ArrayList<ItemDTO> itemDetails, ArrayList<ItemDetailDTO> itemData) throws Exception;

}
