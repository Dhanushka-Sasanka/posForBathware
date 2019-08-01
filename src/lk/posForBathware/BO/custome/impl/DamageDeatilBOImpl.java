/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.DamageDetailBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.DamageDetailDAO;
import lk.posForBathware.model.DTO.DamageDetailDTO;
import lk.posForBathware.model.entity.DamageDetail;

/**
 *
 * @author Danushka
 */
public class DamageDeatilBOImpl implements DamageDetailBO {

    private DamageDetailDAO damageDetail;

    public DamageDeatilBOImpl() {
        try {
            damageDetail = (DamageDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.DAMAGEDETAIL);
        } catch (Exception ex) {
            Logger.getLogger(DamageDeatilBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean addDamageDetail(DamageDetailDTO dto) throws Exception {
        DamageDetail damage = new DamageDetail(dto.getDamageId(), dto.getItemCode(), dto.getDiscription(), dto.getQty(), dto.getDate());
        return damageDetail.add(damage);
    }

    @Override
    public boolean deleteDamageDetail(String id) throws Exception {
        return damageDetail.delete(id);
    }

    @Override
    public boolean updateDamageDetail(DamageDetailDTO dto) throws Exception {
        DamageDetail dm = new DamageDetail(dto.getDamageId(), dto.getItemCode(), dto.getDiscription(), dto.getQty(), dto.getDate());
        return damageDetail.update(dm);
    }

    @Override
    public DamageDetailDTO searchDamageDetail(String id) throws Exception {
        DamageDetail search = damageDetail.search(id);
        DamageDetailDTO dto = new DamageDetailDTO(search.getDamageId_FK(), search.getItemCode_FK(), search.getDiscription(), search.getQty(), search.getDate());
        return dto;
    }

    @Override
    public ArrayList<DamageDetailDTO> getAllDamageDetail() throws Exception {
        ArrayList<DamageDetailDTO> list = new ArrayList<>();
        ArrayList<DamageDetail> all = damageDetail.getAll();
        for (DamageDetail damge : all) {
            DamageDetailDTO damages = new DamageDetailDTO(damge.getDamageId_FK(), damge.getItemCode_FK(), damge.getDiscription(), damge.getQty(), damge.getDate());
            list.add(damages);
        }
        return list;
    }

}
