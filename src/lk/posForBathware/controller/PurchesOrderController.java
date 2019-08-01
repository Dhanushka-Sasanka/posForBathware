/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.posForBathware.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.posForBathware.BO.BOFactory;
import lk.posForBathware.BO.SuperBO;
import lk.posForBathware.BO.custome.CreditCustomerBO;
import lk.posForBathware.BO.custome.ItemBO;
import lk.posForBathware.BO.custome.ItemDetailBO;
import lk.posForBathware.BO.custome.PlaceOrderBO;
import lk.posForBathware.BO.custome.QueryBO;
import lk.posForBathware.model.DTO.BatchDTO;
import lk.posForBathware.model.DTO.CustomeDTO;
import lk.posForBathware.model.DTO.CustomerOrderDTO;
import lk.posForBathware.model.DTO.CustomerOrderDetailDTO;
import lk.posForBathware.model.DTO.ItemDTO;
import lk.posForBathware.model.DTO.ItemDetailDTO;
import lk.posForBathware.model.TM.PurchesOrderTM;
import lk.posForBathware.model.entity.CreditCustomer;
import lk.posForBathware.util.IDJenerator;

/**
 * FXML Controller class
 *
 * @author Danushka
 */
public class PurchesOrderController implements Initializable {

    @FXML
    private JFXComboBox<String> customerCmbo;
    @FXML
    private ListView<String> customerListView;
    @FXML
    private JFXTextField txtReferance;
    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtNIC;
    @FXML
    private JFXTextField txtMobileNo;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXComboBox<String> searchCombo;

    @FXML
    private JFXButton btnRefresh;
    @FXML
    private TableColumn<PurchesOrderTM, String> columnBatch;

    @FXML
    private TableColumn<PurchesOrderTM, Number> colUnitPrice;
    @FXML
    private JFXButton btnAddToCart;
    @FXML
    private JFXComboBox<String> comboBatchId;
    @FXML
    private JFXTextField txtDiscription;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQtyOnHand;

    private static ArrayList<String> allBatchIds;
    private static ObservableList<PurchesOrderTM> orderitems;
    private  CustomeDTO item;
    private static String value;
    @FXML
    private TableView<PurchesOrderTM> orderTable;
    @FXML
    private TableColumn<PurchesOrderTM, Number> colQty;
    @FXML
    private JFXTextField txtTotal;
    @FXML
    private JFXTextField txtOrderUnitprice;
    @FXML
    private JFXTextField txtOrderQty;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXDatePicker orderDate;
    @FXML
    private JFXTextField txtInvoiceNo;
    @FXML
    private JFXButton btnExit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadComboCustomer();
//      treeTableViewItems();
//        loadCustomerIdListView();
        setTextColur();
        loadAllItemsCombo();
        getTableColumnData();
        loadToTable();
        orderDate.setValue(LocalDate.now());

        //Set ID Auto Increment
        try {

            txtInvoiceNo.setText(IDJenerator.getNewID("CustomerOrder", "InvoiceNo", "I"));

        } catch (SQLException ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadComboCustomer() {
        //ScustomerCmbo = new JFXComboBox<>();
        // customerCmbo.setFocusColor(new Color(0.5, 0.2, 0.3, 0.5));
        customerCmbo.getItems().addAll(
                "Cash Customer",
                "Credit Customer"
        );

    }

    private void loadCustomerIdListView() {

        try {

            CreditCustomerBO creditCustmerBO = (CreditCustomerBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.CREDITCUSTOMER);
            ArrayList<String> allCustomerIds = creditCustmerBO.getAllCreditCustomerIds();
            ObservableList<String> allCusIds = FXCollections.observableArrayList(allCustomerIds);
//            allCusIds.get(0).getCustomerId_PK();
            customerListView.getItems().addAll(allCusIds);
            customerListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            customerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    try {
                        if (observable != null) {

                            String value = observable.getValue();
                            CreditCustomer searchCustomer = creditCustmerBO.searchCustomer(value);
                            txtReferance.setText(searchCustomer.getCustomerId_PK());
                            txtName.setText(searchCustomer.getCustomerName());
                            txtNIC.setText(searchCustomer.getNic());
                            txtMobileNo.setText(Integer.toString(searchCustomer.getTeleNo()));
                            txtEmail.setText(searchCustomer.getEmail());
                        }

                    } catch (Exception ex) {
                        Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

//            creditCustmerBO.searchCustomer(selectedID);
        } catch (Exception ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadAllItemsCombo() {

        try {
            ItemBO itemBO = (ItemBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ITEM);

            ArrayList<ItemDTO> allItems = itemBO.getAllItem();
            for (ItemDTO allItem : allItems) {
                searchCombo.getItems().addAll(allItem.getItemCode());
//                searchCombo.setEditable(true);
//                TextFields.bindAutoCompletion(searchCombo.getEditor(), searchCombo.getItems());

            }

            searchCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (newValue != null) {

//            searchCombo.getSelectionModel().clearSelection();
//            System.out.println("121212");
                        if (comboBatchId.getItems() != null) {
                            comboBatchId.getSelectionModel().clearSelection();

                        }
                        try {
//                        comboBatchId.getItems().clear();
//                        String itemcode = observable.getValue();
//                        System.out.println("observerble" + itemcode);
                            System.out.println("new value" + newValue);

                            ItemDetailBO itemDetailBO = (ItemDetailBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ITEMDETAIL);
                            allBatchIds = itemDetailBO.getAllBatchIds(newValue);
                            comboBatchId.getItems().clear();
                            if (allBatchIds.equals(allBatchIds == null)) {
                                comboBatchId.getItems().clear();
                                System.out.println("no batch ...!");
                            }

                            for (String allBatchId : allBatchIds) {

                                boolean addAll = comboBatchId.getItems().add(allBatchId);
                                if (!addAll) {
                                    System.out.println("no Batch Detect ...!");
                                    comboBatchId.getItems().clear();

                                }
                            }

                        } catch (Exception ex) {
                            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            
            comboBatchId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                    try {
                        if (newValue != null) {

                            ItemDetailBO itemDetailBO = (ItemDetailBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.ITEMDETAIL);
                            ItemDetailDTO batchcode = itemDetailBO.searchBatchAndItemCode(searchCombo.getValue(), newValue);
                            if (batchcode != null) {
                                int qtyOnhand = 0;
                                int row = isRowAvailable(batchcode.getItemCode(), batchcode.getBacthId());
                                if (row >= 0) {
                                    qtyOnhand = orderitems.get(row).getQty();

                                }
                                QueryBO queryBO = (QueryBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.QUERY);

                                item = queryBO.batchIdItemCodeJoin(newValue);
                                txtDiscription.setText(item.getDiscription());
                                txtUnitPrice.setText(Double.toString(item.getUnitprice()));
                                txtQtyOnHand.setText(Integer.toString(item.getQtyOnhand() - qtyOnhand));
                            }

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
            });

            txtDiscription.setEditable(false);
            txtUnitPrice.setEditable(false);

        } catch (Exception ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadCreditCustomerIdsToListView() {

    }

    private void setTextColur() {
        txtReferance.setStyle("-fx-text-inner-color: red;");
        txtName.setStyle("-fx-text-inner-color: red;");
        txtNIC.setStyle("-fx-text-inner-color: red;");
        txtMobileNo.setStyle("-fx-text-inner-color: red;");
        txtEmail.setStyle("-fx-text-inner-color: red;");
    }

    @FXML
    private void customerSelectCombo(ActionEvent event) {
        try {
            String selectedCustomer = customerCmbo.getSelectionModel().getSelectedItem();
            if (selectedCustomer.equalsIgnoreCase("Credit Customer")) {
                boolean cheakIsEmtyFeild = cheakIsEmtyFeild();
                if (cheakIsEmtyFeild) {
                    txtReferance.clear();
                    clearAllFeids();
                    loadCustomerIdListView();
                    setVisibleTrueAllCustomerFeilds();
                }
                loadCustomerIdListView();
                setVisibleTrueAllCustomerFeilds();
            }

            if (selectedCustomer.equalsIgnoreCase("Cash Customer")) {
                setVisibleFalseAllustomerFilds();
                txtReferance.setText(IDJenerator.getNewID("Customer", "CustomerID", "C"));
                boolean cheakIsEmtyFeild = cheakIsEmtyFeild();
                if (!cheakIsEmtyFeild) {
                    clearAllFeids();
                    setVisibleFalseAllustomerFilds();

                }
                clearAllFeids();
            }
        } catch (Exception ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setVisibleTrueAllCustomerFeilds() {
        txtReferance.setVisible(true);
        txtName.setVisible(true);
        txtNIC.setVisible(true);
        txtMobileNo.setVisible(true);
        txtEmail.setVisible(true);

    }

    private void setVisibleFalseAllustomerFilds() {
        customerListView.getItems().clear();
        txtReferance.setVisible(true);
        txtName.setVisible(false);
        txtNIC.setVisible(false);
        txtMobileNo.setVisible(false);
        txtEmail.setVisible(false);

    }

    private void clearAllFeids() {

//        txtReferance.clear();
        txtName.clear();
        txtNIC.clear();
        txtMobileNo.clear();
        txtEmail.clear();
//        customerCmbo.getSelectionModel().clearSelection();
//            customerListView.getItems().clear();
        if (searchCombo != null & comboBatchId != null) {
            searchCombo.getSelectionModel().clearSelection();
//      treeTableView.set.clear();
            comboBatchId.getSelectionModel().clearSelection();
        }
        txtDiscription.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
    }

    private void clearAllItemFeilds() {

        txtDiscription.clear();
        txtUnitPrice.clear();
        txtQtyOnHand.clear();
        txtOrderQty.clear();
        txtOrderUnitprice.clear();

    }

    private String getDate() {
        String value = orderDate.getValue() != null ? orderDate.getValue().toString() : "";
        if (!value.equals(""));

        return value;
    }

    private boolean cheakIsEmtyFeild() {
        boolean isRefEmty = txtReferance.getText().trim().isEmpty();
        if (!isRefEmty) {
            System.out.println("10");
            boolean isNameEmty = txtName.getText().trim().isEmpty();
            System.out.println("11");
            if (!isNameEmty) {
                System.out.println("12");
                boolean isNICEmty = txtNIC.getText().trim().isEmpty();
                if (!isNICEmty) {
                    System.out.println("13");
                    boolean isMobilemty = txtMobileNo.getText().trim().isEmpty();
                    if (!isMobilemty) {
                        System.out.println("14");
                        boolean isEmailEmty = txtEmail.getText().trim().isEmpty();
                        if (!isEmailEmty) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @FXML
    private void btnrefreshAction(ActionEvent event) {
        txtReferance.clear();
        clearAllFeids();
    }

    @FXML
    private void btnAddToCartAction(ActionEvent event) {
        String item = searchCombo.getSelectionModel().getSelectedItem();
        String batch = comboBatchId.getSelectionModel().getSelectedItem();
        String discription = txtDiscription.getText();
        double orderprise = Double.parseDouble(txtOrderUnitprice.getText());
        int orderQty = Integer.parseInt(txtOrderQty.getText());
        double amount = orderprise * orderQty;

        boolean validUnitPrice = isValidUnitPrice(orderprise);
        boolean valiedQty = isValiedQty(orderQty);
        if (validUnitPrice == true && valiedQty == true) {
            txtOrderUnitprice.clear();
            txtOrderQty.clear();
            if (item != null && batch != null) {
                int rowCount = isRowAvailable(item, batch);
                if (rowCount == -1) {
                    orderitems.add(new PurchesOrderTM(batch, item, discription, orderprise, orderQty, amount));

                } else {
                    int currentQty = orderitems.get(rowCount).getQty();
                    double currentAmount = orderitems.get(rowCount).getAmount();
                    orderitems.set(rowCount, new PurchesOrderTM(item, batch, discription, orderprise, orderQty + currentQty, amount + currentAmount));
                }

            }
        }
        calculateTotal();
        clearAllItemFeilds();

    }

    private int isRowAvailable(String sItemID, String batchID) {

        for (int i = 0; i < orderTable.getItems().size(); i++) {
            String itmID = orderTable.getColumns().get(0).getCellObservableValue(i).getValue().toString();
            String bID = orderTable.getColumns().get(1).getCellObservableValue(i).getValue().toString();
            return (itmID.equals(sItemID) && bID.equals(batchID)) ? i : -1;
        }
        return -1;
    }

    private void getTableColumnData() {

    }

    private void comboItemClicked(ActionEvent event) {

    }

//       searchCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//           @Override
//           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//               String value = newValue;
//               System.out.println(value);
//           }
//       });
    @FXML

    private void mouseClicked(MouseEvent event) {

    }

    @FXML
    private void comboBatchId(ActionEvent event) {

    }

    private void loadToTable() {
        orderTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchId"));
        orderTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        orderTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("discription"));
        orderTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        orderTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qty"));
        orderTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("amount"));

        orderitems = FXCollections.observableArrayList();
        orderTable.setItems(orderitems);
    }

    private void calculateTotal() {

        double total = 0;
        for (int i = 0; i < orderTable.getItems().size(); i++) {
            Object cellData = orderTable.getColumns().get(5).getCellData(i);
            total += Double.parseDouble(cellData.toString());
        }
        txtTotal.setText(Double.toString(total));

    }

    @FXML
    private void orderTableKeyPressed(KeyEvent event) {
        if (orderTable.getSelectionModel().getSelectedIndex() >= 0) {
            if (event.getCode().equals(KeyCode.DELETE)) {
                orderitems.remove(orderTable.getSelectionModel().getSelectedIndex());
                calculateTotal();
            }
        }

    }

    private boolean isValidUnitPrice(double orderprice) {
        double lablePrice = Double.parseDouble(txtUnitPrice.getText());
        if (orderprice < lablePrice) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "You haven't permission to sell this above price .!", ButtonType.OK);
            alert.showAndWait();
            return false;
        } else {
            return true;
        }

    }

    private boolean isValiedQty(int orderqty) {
        int qtyonhand = Integer.parseInt(txtQtyOnHand.getText());
        if (orderqty > qtyonhand) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You haven't Sufficent stock .!", ButtonType.OK);
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    @FXML
    private void SaveBtnAction(ActionEvent event) {
        try {
            PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOTypes.PLACEORDER);
            boolean isAddPlaceOrder = placeOrderBO.addPlaceOrder(getCustomerOrderDetails(), getOrderDetails(), getBatchIdDetail(), getItemDetails(), getItemData());
            if (isAddPlaceOrder) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Palce Order Added Success ...!", ButtonType.OK);
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Palce Order Added Faild ...!", ButtonType.OK);
                alert.showAndWait();

            }
        } catch (Exception ex) {
            Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private CustomerOrderDTO getCustomerOrderDetails() {
        CustomerOrderDTO order = null;
        String invoiceNo = txtInvoiceNo.getText();
        String customerId = txtReferance.getText();

        String selectedCustomer = customerCmbo.getSelectionModel().getSelectedItem();
        if (selectedCustomer.equalsIgnoreCase("Credit Customer")) {
            if (selectedCustomer != null) {
                customerListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                String selectcustomer = customerListView.getSelectionModel().getSelectedItem();
                if (selectcustomer != null) {
                    order = new CustomerOrderDTO(invoiceNo, getDate(), null, selectcustomer);
                }
            }
            return order;

        }
        if (selectedCustomer.equalsIgnoreCase("Cash Customer")) {
            try {
                txtReferance.setText(IDJenerator.getNewID("Customer", "CustomerId", "C"));
            } catch (Exception ex) {
                Logger.getLogger(PurchesOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (selectedCustomer != null) {
                order = new CustomerOrderDTO(invoiceNo, getDate(), customerId, null);

            }
        }
        return order;

    }

    private ArrayList<CustomerOrderDetailDTO> getOrderDetails() {
        ArrayList<CustomerOrderDetailDTO> orderDetails = new ArrayList<>();
        for (PurchesOrderTM item1 : orderTable.getItems()) {
            orderDetails.add(new CustomerOrderDetailDTO(item1.getBatchId(), txtInvoiceNo.getText(), item1.getQty(), item1.getUnitPrice(), item1.getAmount(), getDate()));

        }
        return orderDetails;

    }

    private ArrayList<BatchDTO> getBatchIdDetail() {
        ArrayList<BatchDTO> batch = new ArrayList<>();

        for (PurchesOrderTM item1 : orderTable.getItems()) {

            batch.add(new BatchDTO(item1.getBatchId(), item1.getQty()));
        }
        return batch;

    }

    private ArrayList<ItemDetailDTO> getItemDetails() {
        ArrayList<ItemDetailDTO> itemDetails = new ArrayList<>();
        for (PurchesOrderTM item1 : orderTable.getItems()) {
            itemDetails.add(new ItemDetailDTO(item1.getItemCode(), item1.getBatchId(), item1.getQty()));
        }
        return itemDetails;
    }

    private ArrayList<ItemDTO> getItemData() {
        ArrayList<ItemDTO> item = new ArrayList<>();
        for (PurchesOrderTM item1 : orderTable.getItems()) {
            ItemDTO itemdto = new ItemDTO();
            itemdto.setItemCode(item1.getItemCode());
            itemdto.setQtyOnHand(item1.getQty());

            item.add(itemdto);
        }
        return item;

    }

    @FXML
    private void ExitBtnAction(ActionEvent event) {

    }
}
