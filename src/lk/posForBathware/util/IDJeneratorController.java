/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.dbConnection.DBConnection;

/**
 *
 * @author Danushka
 */
public class IDJeneratorController {

    public static String getLastID(String tablName, String colName) throws SQLException, Exception {
        String sql = "SELECT " + colName + " FROM " + tablName + " ORDER BY 1 DESC LIMIT 1";
        Connection connection = DBConnection.getDBConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

}
