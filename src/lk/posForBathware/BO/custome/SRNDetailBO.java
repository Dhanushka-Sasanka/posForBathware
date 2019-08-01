/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.SRNDetailDTO;

/**
 *
 * @author Danushka
 */
public interface SRNDetailBO extends SuperBO{

    public boolean addSRNDetail(SRNDetailDTO dto) throws Exception;

    public boolean deleteSRNDetail(String id) throws Exception;

    public boolean updateSRNDetail(SRNDetailDTO dto) throws Exception;

    public SRNDetailDTO searchSRNDetail(String id) throws Exception;

    public ArrayList<SRNDetailDTO> getAllSRNDetail() throws Exception;

}
