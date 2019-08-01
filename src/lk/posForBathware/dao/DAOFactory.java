/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.dao;

import lk.posForBathware.dao.custome.impl.BatchDAOImpl;
import lk.posForBathware.dao.custome.impl.BatchDetailDAOImpl;
import lk.posForBathware.dao.custome.impl.CreditCustomerDAOImpl;
import lk.posForBathware.dao.custome.impl.CustomerDAOImpl;
import lk.posForBathware.dao.custome.impl.CustomerOrderDAOImpl;
import lk.posForBathware.dao.custome.impl.CustomerOrderDetailDAOImpl;
import lk.posForBathware.dao.custome.impl.DamageDAOImpl;
import lk.posForBathware.dao.custome.impl.DamageDetailDAOImpl;
import lk.posForBathware.dao.custome.impl.GRNDAOImple;
import lk.posForBathware.dao.custome.impl.GRNDetailDAOImpl;
import lk.posForBathware.dao.custome.impl.ItemDAOImpl;
import lk.posForBathware.dao.custome.impl.ItemDetailDAOImpl;
import lk.posForBathware.dao.custome.impl.PaymentDAOImpl;
import lk.posForBathware.dao.custome.impl.QueryDAOImpl;
import lk.posForBathware.dao.custome.impl.SRNDAOImpl;
import lk.posForBathware.dao.custome.impl.SRNDetaiDAOlImpl;
import lk.posForBathware.dao.custome.impl.SupplierDAOImpl;
import lk.posForBathware.dao.custome.impl.SupplierOrderDAOImpl;

/**
 *
 * @author Danushka
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes {
        BATCH, BATCHDETAIL, CREDITCUSTOMER, CUSTOMER, CUSTOMERORDER, CUSTOMERORDERDETAIL, DAMAGE,
        DAMAGEDETAIL, GRN, GRNDETAIL, ITEM, ITEMDETAIL, SUPPLIERORDER, PAYMENT, SRN, SRNDETAIL, SUPPLIER,
        SUPPLIERORDERDETAIL, SUPPLIERPAYMENTDETAIL ,QUERY;

    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();

        }
        return daoFactory;
    }

    public SuperDAO getSuperDAO(DAOTypes types) throws Exception {
        switch (types) {

            case BATCH:
                return (SuperDAO) new BatchDAOImpl();
            case BATCHDETAIL:
                return (SuperDAO) new BatchDetailDAOImpl();

            case CREDITCUSTOMER:
                return (SuperDAO) new CreditCustomerDAOImpl();

            case CUSTOMER:
                return (SuperDAO) new CustomerDAOImpl();
            case CUSTOMERORDER:
                return (SuperDAO) new CustomerOrderDAOImpl();
            case CUSTOMERORDERDETAIL:
                return (SuperDAO) new CustomerOrderDetailDAOImpl();
            case DAMAGE:
                return (SuperDAO) new DamageDAOImpl();
            case DAMAGEDETAIL:
                return (SuperDAO) new DamageDetailDAOImpl();
            case GRN:
                return (SuperDAO) new GRNDAOImple();
            case GRNDETAIL:
                return (SuperDAO) new GRNDetailDAOImpl();
            case ITEM:
                return (SuperDAO) new ItemDAOImpl();
            case ITEMDETAIL:
                return (SuperDAO) new ItemDetailDAOImpl();
            case SUPPLIERORDER:
                return (SuperDAO) new SupplierDAOImpl();
            case PAYMENT:
                return (SuperDAO) new PaymentDAOImpl();
            case SRN:
                return (SuperDAO) new SRNDAOImpl();
            case SRNDETAIL:
                return (SuperDAO) new SRNDetaiDAOlImpl();
            case SUPPLIER:
                return (SuperDAO) new SupplierDAOImpl();
            case SUPPLIERORDERDETAIL:
                return (SuperDAO) new SupplierOrderDAOImpl();
//            case SUPPLIERPAYMENTDETAIL:
             case QUERY:
                return (SuperDAO) new QueryDAOImpl();   
             
            default:
                return null;

        }

    }
}
