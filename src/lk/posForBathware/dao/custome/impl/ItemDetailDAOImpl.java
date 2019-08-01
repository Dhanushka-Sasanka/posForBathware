/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.ItemDetailDAO;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public class ItemDetailDAOImpl implements ItemDetailDAO {

    @Override
    public boolean add(ItemDetail entity) throws Exception {
        String sql = "INSERT into ItemDetail values(?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getItemCode_FK(), entity.getBacthId_FK(), entity.getQtyOnHand());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemDetail search(String id) throws Exception {
        ItemDetail item = null;
        String sql = "Select * from ItemDetail where ItemCode = ? and batchId = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        while (rst.next()) {
            item = new ItemDetail(
                    rst.getString("ItemCode"),
                    rst.getString("BatchId"),
                    rst.getInt("QtyOnHand"));

        }
        return item;
    }

    @Override
    public boolean update(ItemDetail entity) throws Exception {
        String sql = "UPDATE ItemDetail set QtyOnHand = QtyOnHand - ? where itemCode = ? and batchId = ?";
        return CrudOperation.executeUpdate(sql, entity.getQtyOnHand(), entity.getItemCode_FK(), entity.getBacthId_FK());

    }

    @Override
    public ArrayList<ItemDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllBatchIds(String itemCode) throws Exception {
        ArrayList<String> batchList = new ArrayList<>();
        String sql = "Select BatchId from ItemDetail where itemCode = ? ";
        ResultSet rst = CrudOperation.executeQuery(sql, itemCode);
        while (rst.next()) {
            String batchid = rst.getString("BatchId");
            batchList.add(batchid);
        }
        return batchList;
    }

    @Override
    public ItemDetail searchBatchAndItemCode(String itemCode, String batchId) throws Exception {
        ItemDetail itemDetail = new ItemDetail();

        String sql = "Select batchid, itemcode ,QtyOnhand from itemDetail where itemCode =  ?  and Batchid  = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, itemCode, batchId);
        while (rst.next()) {

            itemDetail.setItemCode_FK(rst.getString("ItemCode"));
            itemDetail.setBacthId_FK(rst.getString("BatchId"));
            itemDetail.setQtyOnHand(Integer.parseInt(rst.getString("QtyOnHand")));

        }
        return itemDetail;
    }

    @Override
    public boolean updateFromItemCode(ItemDetail entity) throws Exception {
        String sql = "Update ItemDetail set QtyOnhand = QtyOnhand - ? where itemCode = ?";
        return CrudOperation.executeUpdate(sql, entity.getQtyOnHand(), entity.getItemCode_FK());

    }
}
