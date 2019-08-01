/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.QueryDAO;
import lk.posForBathware.model.DTO.CustomeDTO;
import lk.posForBathware.model.TM.ItemFormTM;

/**
 *
 * @author Danushka
 */
public class QueryDAOImpl implements QueryDAO {

    @Override
    public CustomeDTO batchIdItemCodeJoin(String batchid) throws Exception {
        CustomeDTO customeDTO = null;
        String sql = "select itemDetail.BatchId , Item.ItemCode , Item.Discription , Item.qtyOnhand ,Item.unitprice  from item inner Join itemDetail on item.itemCode = itemDetail.itemCode where itemDetail.BatchId = ? ";

        ResultSet rst = CrudOperation.executeQuery(sql, batchid);
        while (rst.next()) {
            customeDTO = new CustomeDTO(rst.getString("BatchId"), rst.getString("ItemCode"), rst.getString("Discription"), rst.getInt("qtyOnhand"), rst.getDouble("unitprice"));

        }
        return customeDTO;
    }

    @Override
    public ArrayList<ItemFormTM> allItemDetail() throws Exception {
        ArrayList<ItemFormTM> item = new ArrayList<>();
        String sql = "select itemDetail.BatchId , Item.ItemCode ,Item.Brand , Item.Discription , Item.qtyOnhand ,Item.unitprice from item inner Join itemDetail on item.itemCode = itemDetail.itemCode";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            ItemFormTM itemForm = new ItemFormTM(
                    rst.getString("BatchId"),
                    rst.getString("ItemCode"),
                    rst.getString("Brand"),
                    rst.getString("Discription"),
                    rst.getInt("qtyOnhand"),
                    rst.getDouble("UnitPrice")
            );
            item.add(itemForm);

        }
        return item;
    }

}
