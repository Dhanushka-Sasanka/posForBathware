/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome;

import java.util.ArrayList;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.model.DTO.DamageDetailDTO;

/**
 *
 * @author Danushka
 */
public interface DamageDetailBO extends SuperBO {

    public boolean addDamageDetail(DamageDetailDTO dto) throws Exception;

    public boolean deleteDamageDetail(String id) throws Exception;

    public boolean updateDamageDetail(DamageDetailDTO dto) throws Exception;

    public DamageDetailDTO searchDamageDetail(String id) throws Exception;

    public ArrayList<DamageDetailDTO> getAllDamageDetail() throws Exception;

}
