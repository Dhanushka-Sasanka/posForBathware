/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.BatchDetailDTO;
import lk.posForBathware.model.DTO.GRNDTO;
import lk.posForBathware.model.DTO.GRNDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;

/**
 *
 * @author Danushka
 */
public interface GRNFillingReportBO extends SuperBO {

    public boolean putGRNReport(BatchDTO batchDTO, GRNDTO grndto, ArrayList<BatchDetailDTO> batchDetails, ItemDTO itemDTO, ArrayList<GRNDetailDTO> grnDetails, ArrayList<ItemDetailDTO> itemDetails);
}
