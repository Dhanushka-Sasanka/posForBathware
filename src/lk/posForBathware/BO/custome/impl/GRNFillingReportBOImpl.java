/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.GRNFillingReportBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.BatchDAO;
import lk.posForBathware.dao.custome.BatchDetailDAO;
import lk.posForBathware.dao.custome.GRNDAO;
import lk.posForBathware.dao.custome.GRNDetailDAO;
import lk.posForBathware.dao.custome.ItemDAO;
import lk.posForBathware.dao.custome.ItemDetailDAO;
import lk.posForBathware.dbConnection.DBConnection;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.BatchDetailDTO;
import lk.posForBathware.model.DTO.GRNDTO;
import lk.posForBathware.model.DTO.GRNDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.entity.Batch;
import lk.posForBathware.model.entity.BatchDetail;
import lk.posForBathware.model.entity.GRN;
import lk.posForBathware.model.entity.GRNDetail;
import lk.posForBathware.model.entity.Item;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public class GRNFillingReportBOImpl implements GRNFillingReportBO {

    private BatchDAO batchDAO;
    private GRNDAO grndao;
    private BatchDetailDAO batchDetailDAO;
    private ItemDAO itemDAO;
    private ItemDetailDAO itemDetailDAO;
    private GRNDetailDAO grnDetailDAO;
    private Connection connection;

    public GRNFillingReportBOImpl() throws Exception {
//        batchBO = (BatchBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.BATCH);
//        grnbo = (GRNBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.GRN);
//        batchDetailBO = (BatchDetailBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.BATCHDETAIL);
//        itemBO = (ItemBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ITEM);
//        itemDetailBO = (ItemDetailBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ITEMDETAIL);

        batchDAO = (BatchDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.BATCH);
        grndao = (GRNDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.GRN);
        batchDetailDAO = (BatchDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.BATCHDETAIL);
        itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEM);
        itemDetailDAO = (ItemDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEMDETAIL);
        grnDetailDAO = (GRNDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.GRNDETAIL);
    }

    @Override
    public boolean putGRNReport(BatchDTO batchDTO, GRNDTO grnDTO, ArrayList<BatchDetailDTO> batchDetails, ItemDTO itemDTO, ArrayList<GRNDetailDTO> grnDetails, ArrayList<ItemDetailDTO> itemDetails) {

        try {
            connection = DBConnection.getDBConnection().getConnection();
            connection.setAutoCommit(false);
            System.out.println("1");
            Batch batch = new Batch(batchDTO.getBatchID(), batchDTO.getUnitPrice());
            boolean isAddedBatch = batchDAO.add(batch);
            if (!isAddedBatch) {
                connection.rollback();
                return false;
            }
            System.out.println("2");
            GRN grn = new GRN(grnDTO.getGrnId(), grnDTO.getDiscription(), grnDTO.getDate());
            boolean isAddedGrn = grndao.add(grn);
            System.out.println("3");
            if (!isAddedGrn) {
                connection.rollback();
                return false;
            }
            System.out.println("4");
            for (BatchDetailDTO batchDetail : batchDetails) {
                BatchDetail addbatch = new BatchDetail(batchDetail.getBatchId(), batchDetail.getGrnId(), batchDetail.getQty(), batchDetail.getUnitPrice(), batchDetail.getDate());
                boolean isAddedBatchDetail = batchDetailDAO.add(addbatch);
                System.out.println("5");
                if (!isAddedBatchDetail) {
                    connection.rollback();
                    return false;
                }
                System.out.println("6");

                Item item = new Item(itemDTO.getItemCode(), itemDTO.getBrand(), itemDTO.getQtyOnHand(), itemDTO.getUnitPrice(), itemDTO.getDescription());
                boolean isAddedItem = itemDAO.add(item);
                System.out.println("7");
                if (!isAddedItem) {
                    connection.rollback();
                    return false;
                }
                System.out.println("8");
                for (GRNDetailDTO grnDetail : grnDetails) {
                    GRNDetail grndata = new GRNDetail(grnDetail.getGrnId(), grnDetail.getItemCode(), grnDetail.getQty(), grnDetail.getUnitPrice(), grnDetail.getDate());
                    boolean isAddedGrnDetail = grnDetailDAO.add(grndata);
                    System.out.println("9");
                    if (!isAddedGrnDetail) {
                        connection.rollback();
                        return false;
                    }
                    System.out.println("10");
                }
                for (ItemDetailDTO itemData : itemDetails) {
                    ItemDetail itemDetail = new ItemDetail(itemData.getItemCode(), itemData.getBacthId(), itemData.getQtyOnHand());
                    boolean isAddedItemDetail = itemDetailDAO.add(itemDetail);
                    if (!isAddedItemDetail) {
                        connection.rollback();
                        return false;
                    }
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(GRNFillingReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(GRNFillingReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(GRNFillingReportBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
