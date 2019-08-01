/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.ItemDAO;
import lk.posForBathware.model.entity.Item;

/**
 *
 * @author Danushka
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean add(Item entity) throws Exception {
        String sql = "INSERT into item values (?,?,?,?,?)";
        return CrudOperation.executeUpdate(sql, entity.getItemCode_PK(), entity.getBrand(), entity.getQtyOnHand(), entity.getUnitPrice(), entity.getDescription());
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Item entity) throws Exception {
        String sql = "UPDATE Item set  QtyOnHand = QtyOnHand  - ? where ItemCode = ?";
        return CrudOperation.executeUpdate(sql, entity.getQtyOnHand(), entity.getItemCode_PK());
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ArrayList<Item> itemList = new ArrayList<>();
        String sql = "SELECT * from Item";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            Item item = new Item(rst.getString("itemCode"), rst.getString("Brand"), rst.getInt("QtyOnHand"), rst.getDouble("unitPrice"), rst.getString("discription"));
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public String searchItemCode(String id) throws Exception {
        String itemcode = null;
        String sql = "SELECT itemcode from Item where itemCode = ?";
        ResultSet rst = CrudOperation.executeQuery(sql, id);
        while (rst.next()) {
            itemcode = rst.getString("ItemCode");
        }
        return itemcode;
    }

}
