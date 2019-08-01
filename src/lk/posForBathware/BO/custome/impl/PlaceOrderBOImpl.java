/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.BO.custome.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.posForBathware.BO.custome.PlaceOrderBO;
import lk.posForBathware.dao.DAOFactory;
import lk.posForBathware.dao.SuperDAO;
import lk.posForBathware.dao.custome.BatchDAO;
import lk.posForBathware.dao.custome.CustomerDAO;
import lk.posForBathware.dao.custome.CustomerOrderDAO;
import lk.posForBathware.dao.custome.CustomerOrderDetailDAO;
import lk.posForBathware.dao.custome.ItemDAO;
import lk.posForBathware.dao.custome.ItemDetailDAO;
import lk.posForBathware.dbConnection.DBConnection;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.CustomerDTO;
import lk.posForBathware.model.DTO.CustomerOrderDTO;
import lk.posForBathware.model.DTO.CustomerOrderDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.entity.Batch;
import lk.posForBathware.model.entity.Customer;
import lk.posForBathware.model.entity.CustomerOrder;
import lk.posForBathware.model.entity.CustomerOrderDetail;
import lk.posForBathware.model.entity.Item;
import lk.posForBathware.model.entity.ItemDetail;

/**
 *
 * @author Danushka
 */
public class PlaceOrderBOImpl implements PlaceOrderBO {

    private CustomerDAO cashCustomerDAO;
    private CustomerOrderDAO customerOrderDAO;
    private CustomerOrderDetailDAO customerOrderDetailDAO;
    private BatchDAO batchDAO;
    private ItemDetailDAO itemDetailDAO;
    private ItemDAO itemDAO;

    public PlaceOrderBOImpl() {
        try {
            cashCustomerDAO = (CustomerDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.CUSTOMER);
            customerOrderDAO = (CustomerOrderDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.CUSTOMERORDER);
            customerOrderDetailDAO = (CustomerOrderDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.CUSTOMERORDERDETAIL);
            batchDAO = (BatchDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.BATCH);
            itemDetailDAO = (ItemDetailDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEMDETAIL);
            itemDAO = (ItemDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOTypes.ITEM);

        } catch (Exception ex) {
            Logger.getLogger(PlaceOrderBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean addPlaceOrder(CustomerOrderDTO order, ArrayList<CustomerOrderDetailDTO> orderDetails, ArrayList<BatchDTO> batchs, ArrayList<ItemDetailDTO> itemDetails, ArrayList<ItemDTO> item) throws Exception {

        Connection connection = DBConnection.getDBConnection().getConnection();

        connection.setAutoCommit(false);

        CustomerOrder customerOrder = new CustomerOrder(order.getInvoiceNo(), order.getDate(), order.getCutomerId(), order.getCCustomerId());

        System.out.println("1");
        if (order.getCCustomerId() != null) {

            boolean isOrderAdded = customerOrderDAO.add(customerOrder);

            System.out.println("2");
            if (!isOrderAdded) {
                System.out.println("3");
                connection.rollback();
                return false;
            }
        } if(order.getCutomerId() != null) {
            Customer customer = new Customer(order.getCutomerId());
            boolean isAdddedCashCustomer = cashCustomerDAO.add(customer);
            System.out.println("55");
            if (!isAdddedCashCustomer) {
                System.out.println("56");
                connection.rollback();
                return false;
            }
            boolean isOrderAdded = customerOrderDAO.add(customerOrder);

            System.out.println("cash2");
            if (!isOrderAdded) {
                System.out.println("cash3");
                connection.rollback();
                return false;
            }

            for (CustomerOrderDetailDTO orders : orderDetails) {
                CustomerOrderDetail orderData = new CustomerOrderDetail(orders.getBatchId(), orders.getInvoiceNo(), orders.getQty(), orders.getUnitPrice(), orders.getAmount(), orders.getDate());
                boolean isOrderDetailsAdded = customerOrderDetailDAO.add(orderData);
                System.out.println("4");
                if (!isOrderDetailsAdded) {
                    System.out.println("4rol");
                    connection.rollback();
                    return false;

                }
                for (BatchDTO batch : batchs) {

                    Batch search = batchDAO.search(batch.getBatchID());
                    if (!search.getBatchID_PK().equals(orders.getBatchId())) {
                        System.out.println("5rol");
                        connection.rollback();
                        return false;
                    }
                    System.out.println("6");
                    for (ItemDetailDTO itemDetail : itemDetails) {
                        ItemDetail orderItems = new ItemDetail(itemDetail.getItemCode(), itemDetail.getBacthId(), itemDetail.getQtyOnHand());
                        boolean isUpdated = itemDetailDAO.update(orderItems);
                        System.out.println("7");
                        if (!isUpdated) {
                            System.out.println("8 rol");
                            connection.rollback();
                            return false;
                        }
                        for (ItemDTO itemDTO : item) {

                            Item itemEntity = new Item();
                            itemEntity.setItemCode_PK(itemDTO.getItemCode());
                            itemEntity.setQtyOnHand(itemDTO.getQtyOnHand());

                            boolean isItemUpdated = itemDAO.update(itemEntity);
                            System.out.println("14");
                            if (!isItemUpdated) {
                                System.out.println("15rol");
                                connection.rollback();
                                return false;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("comit");
        connection.commit();
        connection.setAutoCommit(true);
        System.out.println("last");
        return true;

    }

}
