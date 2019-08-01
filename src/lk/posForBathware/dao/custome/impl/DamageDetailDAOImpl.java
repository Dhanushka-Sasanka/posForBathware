/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.DamageDetailDAO;
import lk.posForBathware.model.entity.DamageDetail;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public class DamageDetailDAOImpl implements DamageDetailDAO {

    @Override
    public boolean add(DamageDetail entity) throws Exception {
        String sql = "INSERT into DAMAGEDETAIL values (?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getDamageId_FK(), entity.getItemCode_FK(), entity.getDiscription(), entity.getQty(), entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "Delete from DamageDetail where damegeID = ?";
        return CrudOperation.executeUpdate(sql,id);
    }

    @Override
    public DamageDetail search(String id) throws Exception {
        DamageDetail item = null;
        String sql = "Select * from DamageDetail where ItemCode = ? and batchId = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        while (rst.next()) {
            item = new DamageDetail(
                    rst.getString("DamegeID"),
                    rst.getString("ItemCode"),
                    rst.getString("Discription"),
                    rst.getInt("QTY"),
                    rst.getString("Date"));

        }
        return item;
    }

    @Override
    public boolean update(DamageDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DamageDetail> getAll() throws Exception {
        ArrayList<DamageDetail> list = new ArrayList<>();
        String sql = "SELECT * from DamageDetail";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            DamageDetail damages = new DamageDetail(rst.getString("DamegeID"), rst.getString("itemCode"), rst.getString("Discription"), rst.getInt("qty"), rst.getString("date"));
            list.add(damages);
        }
        return list;
    }

}
