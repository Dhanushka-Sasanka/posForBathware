/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.PlaceDamageNote;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.DamageDAO;
import lk.posForBathware.dao.custome.DamageDetailDAO;
import lk.posForBathware.dao.custome.ItemDAO;
import lk.posForBathware.dao.custome.ItemDetailDAO;
import lk.posForBathware.dbConnection.DBConnection;
import lk.posForBathware.model.DTO.DamageDTO;
import lk.posForBathware.model.DTO.DamageDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.entity.Damage;
import lk.posForBathware.model.entity.DamageDetail;
import lk.posForBathware.model.entity.Item;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public class PlaceDamageNoteImpl implements PlaceDamageNote {

    private DamageDAO damageDAO;
    private DamageDetailDAO damageDetailDAO;
    private ItemDAO itemDAO;
    private ItemDetailDAO itemDetailDAO;

    public PlaceDamageNoteImpl() {
        try {
            damageDAO = (DamageDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.DAMAGE);
            damageDetailDAO = (DamageDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.DAMAGEDETAIL);
            itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEM);
            itemDetailDAO = (ItemDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEMDETAIL);
        } catch (Exception ex) {
            Logger.getLogger(PlaceDamageNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean addDamageNote(ArrayList<DamageDTO> damageDTO, ArrayList<DamageDetailDTO> damageDetailList, ArrayList<ItemDTO> itemDetails, ArrayList<ItemDetailDTO> itemData) throws Exception {

        Connection connection = DBConnection.getDBConnection().getConnection();

        connection.setAutoCommit(false);
        System.out.println("1");
        for (DamageDTO damagedto : damageDTO) {
            Damage damageEntity = new Damage(damagedto.getDamageId(), damagedto.getDate());
            boolean isAdded = damageDAO.add(damageEntity);
            System.out.println("2");
            if (!isAdded) {
                System.out.println("3rol");
                connection.rollback();
                return false;
            }
            for (ItemDTO itemDetail : itemDetails) {
                Item item = new Item();
                item.setItemCode_PK(itemDetail.getItemCode());                                                          //(itemDetail.getItemCode(),itemDetail.getBrand(),itemDetail.getQtyOnHand(),itemDetail.getUnitPrice(), itemDetail.getDescription());
                item.setQtyOnHand(itemDetail.getQtyOnHand());
                boolean isUpdated = itemDAO.update(item);
                System.out.println("4");
                if (!isUpdated) {
                    System.out.println("5rol");
                    connection.rollback();
                    return false;
                }
                for (DamageDetailDTO damages : damageDetailList) {
                    DamageDetail damageData = new DamageDetail(damages.getDamageId(), damages.getItemCode(), damages.getDiscription(), damages.getQty(), damages.getDate());
                    boolean isAddedDetails = damageDetailDAO.add(damageData);
                    System.out.println("6");
                    if (!isAddedDetails) {
                        System.out.println("7rol");
                        connection.rollback();
                        return false;
                    }
                    for (ItemDetailDTO itemDetail1 : itemData) {
                        ItemDetail itemD = new ItemDetail();
                        itemD.setItemCode_FK(itemDetail1.getItemCode());
                        itemD.setQtyOnHand(itemDetail1.getQtyOnHand());
                        boolean isUpdate = itemDetailDAO.updateFromItemCode(itemD);
                        System.out.println("8");
                        if (!isUpdate) {
                            System.out.println("9rol");
                            connection.rollback();
                            return false;
                        }

                    }
                }

            }

        }
        System.out.println("comit");
        connection.commit();
        connection.setAutoCommit(true);
        return true;

    }

}
