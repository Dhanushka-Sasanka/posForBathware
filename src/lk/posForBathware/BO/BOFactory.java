/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO;

import lk.posForBathware.BO.custome.impl.BatchBOImpl;
import lk.posForBathware.BO.custome.impl.BatchDetailBOImpl;
import lk.posForBathware.BO.custome.impl.CreditCustomerBOImpl;
import lk.posForBathware.BO.custome.impl.CustomerBOImpl;
import lk.posForBathware.BO.custome.impl.CustomerOrderBO;
import lk.posForBathware.BO.custome.impl.CustomerOrderDetailBOImpl;
import lk.posForBathware.BO.custome.impl.DamageBOImpl;
import lk.posForBathware.BO.custome.impl.DamageDeatilBOImpl;
import lk.posForBathware.BO.custome.impl.GRNFillingReportBOImpl;
import lk.posForBathware.BO.custome.impl.ItemBOImpl;
import lk.posForBathware.BO.custome.impl.ItemDetailBOImpl;
import lk.posForBathware.BO.custome.impl.PlaceDamageNoteImpl;
import lk.posForBathware.BO.custome.impl.PlaceOrderBOImpl;
import lk.posForBathware.BO.custome.impl.PlaceSrnBOImpl;
import lk.posForBathware.BO.custome.impl.QueryBOImpl;
import lk.posForBathware.BO.custome.impl.SRNBOImpl;
import lk.posForBathware.BO.custome.impl.SRNDetailBOImpl;
import lk.posForBathware.BO.custome.impl.SupplierBOImpl;

/**
 *
 * @author Danushka
 */
public class BOFactory {

    private static BOFactory boFactoy;

    public enum BOTypes {

        BATCH, BATCHDETAIL, CREDITCUSTOMER, CUSTOMER, CUSTOMERORDER, CUSTOMERORDERDETAIL, DAMAGE,
        DAMAGEDETAIL, GRN, GRNDETAIL, ITEM, ITEMDETAIL, SUPPLIERORDER, PAYMENT, SRN, SRNDETAIL, SUPPLIER,
        SUPPLIERORDERDETAIL, SUPPLIERPAYMENTDETAIL, GRNFILLINGREPORT, PLACESRN, QUERY, PLACEORDER, PLACEDAMAGENOTE;
    }

    public static BOFactory getBOFactory() {
        if (boFactoy == null) {
            return new BOFactory();
        }
        return boFactoy;
    }

    public SuperBO getSuperBO(BOTypes types) throws Exception {
        switch (types) {
            case BATCH:
                return (SuperBO) new BatchBOImpl();
            case BATCHDETAIL:
                return (SuperBO) new BatchDetailBOImpl();
            case CREDITCUSTOMER:
                return (SuperBO) new CreditCustomerBOImpl();
            case CUSTOMER:
                return (SuperBO) new CustomerBOImpl();

            case CUSTOMERORDER:
                return (SuperBO) new CustomerOrderBO();
            case CUSTOMERORDERDETAIL:
                return (SuperBO) new CustomerOrderDetailBOImpl();
            case DAMAGE:
                return (SuperBO) new DamageBOImpl();
            case QUERY:
                return (SuperBO) new QueryBOImpl();
            case SUPPLIER:
                return (SuperBO) new SupplierBOImpl();
            case GRNFILLINGREPORT:
                return (SuperBO) new GRNFillingReportBOImpl();
            case PLACESRN:
                return (SuperBO) new PlaceSrnBOImpl();
            case SRN:
                return (SuperBO) new SRNBOImpl();
            case SRNDETAIL:
                return (SuperBO) new SRNDetailBOImpl();
            case ITEM:
                return (SuperBO) new ItemBOImpl();
            case ITEMDETAIL:
                return (SuperBO) new ItemDetailBOImpl();
            case PLACEORDER:
                return (SuperBO) new PlaceOrderBOImpl();
            case PLACEDAMAGENOTE:
                return (SuperBO) new PlaceDamageNoteImpl();
           case DAMAGEDETAIL:    
               return (SuperBO) new DamageDeatilBOImpl();
//            case GRN:
//            case GRNDETAIL:
//            
//
//            case ITEMDETAIL:
            default:
                return null;

        }

    }
}
