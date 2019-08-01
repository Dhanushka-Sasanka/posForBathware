/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.DTO.SRNDTO;
import lk.posForBathware.model.DTO.SRNDetailDTO;

/**
 *
 * @author Danushka
 */
public interface PlaceSrnBO extends SuperBO {

    public boolean addSrnNote(SRNDTO srndto, ArrayList<SRNDetailDTO> srnDetail, ArrayList<BatchDTO> batchIds,ArrayList<ItemDTO>itemCodes, ArrayList<ItemDetailDTO> itemDetailDTO, ArrayList<ItemDTO> itemDTO) throws Exception;

}
