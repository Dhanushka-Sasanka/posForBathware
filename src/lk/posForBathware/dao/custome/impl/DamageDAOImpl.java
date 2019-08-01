/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao.custome.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.posForBathware.dao.CrudOperation;
import lk.posForBathware.dao.custome.DamageDAO;
import lk.posForBathware.model.entity.Damage;

/**
 *
 * @author Danushka
 */
public class DamageDAOImpl implements DamageDAO {

    @Override
    public boolean add(Damage entity) throws Exception {
        String sql = "Insert INTO DAMAGE values(?,?)";
        return CrudOperation.executeUpdate(sql, entity.getDamageId(), entity.getDate());
    }

    @Override
    public boolean delete(String id) throws Exception {

        String sql = "DELETE FROM DAMAGE where DamegeId = ?";
        return CrudOperation.executeUpdate(sql, id);
    }

    @Override
    public Damage search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Damage entity) throws Exception {
        String sql = "Update Damage set date = ? where DamegeId = ?";
        return CrudOperation.executeUpdate(sql, entity.getDate(), entity.getDamageId());
    }

    @Override
    public ArrayList<Damage> getAll() throws Exception {
        ArrayList<Damage> damageList = new ArrayList<>();
        String sql = "SELECT * from DAMAGE";
        ResultSet rst = CrudOperation.executeQuery(sql);
        while (rst.next()) {
            Damage damag = new Damage(rst.getString("DamegeID"), rst.getString("date"));
            damageList.add(damag);
        }
        return damageList;

    }

}
