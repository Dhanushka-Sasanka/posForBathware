/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.GRNDetailDTO;

/**
 *
 * @author Danushka
 */
public interface GRNDetailBO extends SuperBO {

    public boolean addGRNDetail(GRNDetailDTO dto) throws Exception;

    public boolean deleteGRNDetail(String id) throws Exception;

    public boolean updateGRNDetail(GRNDetailDTO dto) throws Exception;

    public GRNDetailDTO searchGRNDetail(String id) throws Exception;

    public ArrayList<GRNDetailDTO> getAllGRNDetail() throws Exception;
}
