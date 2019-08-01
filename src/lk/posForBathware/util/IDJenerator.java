/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.util;

import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author Danushka
 */
public class IDJenerator {

    public static String getNewID(String tableName, String colName, String prifix) throws  Exception {
        String lastId = IDJeneratorController.getLastID(tableName, colName);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prifix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(5);
            numberFormat.setGroupingUsed(false);
            String newID = numberFormat.format(id);
            return prifix + newID;
        } else {
            return prifix + "001";
        }
    }
}
