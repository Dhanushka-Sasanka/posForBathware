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
import lk.posForBathware.BO.custome.PlaceSrnBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.BatchDAO;
import lk.posForBathware.dao.custome.ItemDAO;
import lk.posForBathware.dao.custome.ItemDetailDAO;
import lk.posForBathware.dao.custome.SRNDAO;
import lk.posForBathware.dao.custome.SRNDetailDAO;
import lk.posForBathware.dbConnection.DBConnection;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.DTO.SRNDTO;
import lk.posForBathware.model.DTO.SRNDetailDTO;
import lk.posForBathware.model.entity.Item;
import lk.posForBathware.model.entity.ItemDetail;
import lk.posForBathware.model.entity.SRN;
import lk.posForBathware.model.entity.SRNDetail;

/**
 *
 * @author Danushka
 */
public class PlaceSrnBOImpl implements PlaceSrnBO {

    private SRNDAO srnDAO;
    private SRNDetailDAO srnDetailDAO;
    private BatchDAO batchDAO;
    private ItemDetailDAO itemDetailDAO;
    private ItemDAO itemDAO;

    public PlaceSrnBOImpl() {
        try {
            srnDAO = (SRNDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.SRN);
            srnDetailDAO = (SRNDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.SRNDETAIL);
            batchDAO = (BatchDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.BATCH);
            itemDetailDAO = (ItemDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEMDETAIL);
            itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEM);
        } catch (Exception ex) {
            Logger.getLogger(PlaceSrnBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean addSrnNote(SRNDTO srndto, ArrayList<SRNDetailDTO> srnDetail, ArrayList<BatchDTO> batchIds, ArrayList<ItemDTO> itemCodes, ArrayList<ItemDetailDTO> itemDetail, ArrayList<ItemDTO> itemDTO) {
        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            connection.setAutoCommit(false);
            SRN srn = new SRN(srndto.getSrnId());
            boolean isSrnAdded = srnDAO.add(srn);
            if (!isSrnAdded) {
                System.out.println("1");
                connection.rollback();
                return false;
            }
            for (SRNDetailDTO srnData : srnDetail) {
                SRNDetail srnDetails = new SRNDetail(srnData.getSrnId(), srnData.getBatchId(), srnData.getDiscription(), srnData.getQty(), srnData.getDate());
                boolean isSrnDetailAdded = srnDetailDAO.add(srnDetails);
                System.out.println("2");
                if (!isSrnDetailAdded) {
                    System.out.println("3roll");
                    connection.rollback();
                    return false;
                }
                for (BatchDTO batchid : batchIds) {

                    String searchBatchId = batchDAO.searchBatchId(batchid.getBatchID());

                    System.out.println("4");

                    if (searchBatchId == null) {
                        System.out.println("5roll");
                        connection.rollback();
                        return false;

                    }
                    for (ItemDTO itemCode : itemCodes) {
                        String searchItemcode = itemDAO.searchItemCode(itemCode.getItemCode());
                        System.out.println("6");
                        if (searchItemcode == null) {
                            System.out.println("7roll");
                            connection.rollback();
                            return false;
                        }

                        while (!batchIds.isEmpty() & !itemCodes.isEmpty()) {

                            System.out.println("8");

                            for (ItemDetailDTO item : itemDetail) {
                                ItemDetail itemDetails = new ItemDetail(item.getItemCode(), item.getBacthId(), item.getQtyOnHand());
                                System.out.println("9");
                                boolean isItemUpdated = itemDetailDAO.update(itemDetails);
                                if (!isItemUpdated) {
                                    System.out.println("10roll");
                                    connection.rollback();
                                    return false;
                                }
                                for (ItemDTO items : itemDTO) {
                                    
                                    Item itemEntity = new Item(items.getItemCode(), items.getBrand(), items.getQtyOnHand(), items.getUnitPrice(), items.getDescription());
                                    boolean isItemQtyUpdated = itemDAO.update(itemEntity);
                                    System.out.println("11");
                                    if (!isItemQtyUpdated) {
                                        System.out.println("12roll");
                                        connection.rollback();
                                        return false;

                                    }
                                }
                                System.out.println("12comit");
                                connection.commit();
                                connection.setAutoCommit(true);
                                return true;
                            }
                        }
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(PlaceSrnBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
