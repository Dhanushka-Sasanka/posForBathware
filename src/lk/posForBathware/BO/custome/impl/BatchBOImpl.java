/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.BatchBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.custome.BatchDAO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.entity.Batch;

/**
 *
 * @author Danushka
 */
public class BatchBOImpl implements BatchBO {

    private BatchDAO batchDAO;

    public BatchBOImpl() {
        try {
            batchDAO = (BatchDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.BATCH);
        } catch (Exception ex) {
            Logger.getLogger(BatchBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean addBatch(BatchDTO dto) throws Exception {
        Batch batch = new Batch(dto.getBatchID(), dto.getUnitPrice());
        return batchDAO.add(batch);

    }

    @Override
    public boolean deleteBatch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBatch(BatchDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchDTO searchBatch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<BatchDTO> getAllBatch() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
