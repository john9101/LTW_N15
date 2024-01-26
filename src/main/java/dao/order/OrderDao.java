package dao.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GeneralDao;
import database.JDBIConnector;
import models.*;

import java.util.*;

public class OrderDao {

    public List<Order> getListAllOrders() {
        String sql = "SELECT id, userId, dateOrder, deliveryMethodId, paymentMethodId, fullName, email, phone, address, orderStatusId, transactionStatusId, voucherId FROM orders";
        return GeneralDao.executeQueryWithSingleTable(sql, Order.class);
    }

    public List<PaymentMethod> getListAllPaymentMethodManage(){
        String sql = "SELECT id, typePayment FROM payment_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, PaymentMethod.class);
    }

    public List<DeliveryMethod> getListAllDeliveryMethodManage(){
        String sql = "SELECT id, typeShipping, description, shippingFee FROM delivery_methods";
        return GeneralDao.executeQueryWithSingleTable(sql, DeliveryMethod.class);
    }

    public List<Order> getListOrdersBySearchFilter(Map<Object, List<String>> mapFilterSectionOrders, String contentSearch, String searchSelect, String startDate, String endDate) {
        StringBuilder sql = new StringBuilder("SELECT id, userId, dateOrder, deliveryMethodId, paymentMethodId, fullName, email, phone, address, orderStatusId, transactionStatusId, voucherId FROM orders WHERE 1=1");
        if(searchSelect.equals("orderId")){
            sql.append(" AND id LIKE ?");
        }else if(searchSelect.equals("customerName")){
            sql.append(" AND fullName LIKE ?");
        }

        for(Object objectRepresent : mapFilterSectionOrders.keySet()){
            List<String> arrayIdSectionFilter = mapFilterSectionOrders.get(objectRepresent);
            String fillEntry = String.join(",", arrayIdSectionFilter);
            if(objectRepresent instanceof DeliveryMethod){
                sql.append(" AND deliveryMethodId");
            }else if(objectRepresent instanceof PaymentMethod){
                sql.append(" AND paymentMethodId");
            } else if (objectRepresent instanceof OrderStatus) {
                sql.append(" AND orderStatusId");
            } else if (objectRepresent instanceof TransactionStatus) {
                sql.append(" AND transactionStatusId");
            }
            sql.append(" IN(").append(fillEntry).append(")");
        }

        String surrStartDateFmt = String.format("'%s'", startDate);
        String surrEndDateFmt = String.format("'%s'", endDate);

        if(!startDate.isEmpty() && !endDate.isEmpty()) {
            sql.append(" AND dateOrder BETWEEN ").append(surrStartDateFmt).append(" AND ").append(surrEndDateFmt);
        }else if(!startDate.isEmpty()){
            sql.append(" AND dateOrder >= ").append(surrStartDateFmt);
        }else if(!endDate.isEmpty()){
            sql.append(" AND dateOrder <= ").append(surrEndDateFmt);
        }

        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Order.class, "%" + contentSearch + "%");
    }

    public PaymentMethod getPaymentMethodMangeById(int id){
        String sql = "SELECT id, typePayment FROM payment_methods WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, PaymentMethod.class, id).get(0);
    }

    public DeliveryMethod getDeliveryMethodManageById(int id){
        String sql = "SELECT id, typeShipping, description, shippingFee FROM delivery_methods WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, DeliveryMethod.class, id).get(0);
    }

    public Order getOrderById(String id){
        StringBuilder sql = new StringBuilder("SELECT id, userId, dateOrder, deliveryMethodId, paymentMethodId, fullName, email, phone, address, orderStatusId, transactionStatusId, voucherId");
        sql.append(" FROM orders WHERE id = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Order.class, id).get(0);
    }

//    public List<Order> getListOrderByPartialId(String orderId){
//        StringBuilder sql = new StringBuilder("SELECT id, userId, dateOrder, deliveryMethodId, paymentMethodId, fullName, email, phone, address, orderStatusId, transactionStatusId, voucherId");
//        sql.append(" FROM orders WHERE id LIKE ?");
//        String surrOrderIdFmt = "%" + orderId + "%";
//        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Order.class, surrOrderIdFmt);
//    }

//    public List<Order> getListOrderByCustomerName(String customerName){
//        StringBuilder sql = new StringBuilder("SELECT id, userId, dateOrder, deliveryMethodId, paymentMethodId, fullName, email, phone, address, orderStatusId, transactionStatusId, voucherId");
//        sql.append(" FROM orders WHERE fullName LIKE ?");
//        String surrCustomerNameFmt = "%" + customerName + "%";
//        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Order.class, surrCustomerNameFmt);
//    }

//    public void updateOrderStatusIdByOrderId(int orderStatusId , String orderId){
//        String sql = "UPDATE orders SET orderStatusId ? WHERE id = ?";
//        GeneralDao.executeAllTypeUpdate(sql, orderStatusId, orderId);
//    }
//
//    public void updateTransactionStatusIdByOrderId(int transactionStatusId , String orderId){
//        String sql = "UPDATE orders SET transactionStatusId ? WHERE id = ?";
//        GeneralDao.executeAllTypeUpdate(sql, transactionStatusId, orderId);
//    }

    public void removeOrderByMultipleId(String[] multipleId){
        String fillEntry = String.format("'%s'", String.join("','", multipleId));
        StringBuilder sql = new StringBuilder("DELETE orders, order_details FROM");
        sql.append(" orders INNER JOIN order_details ON orders.id = order_details.orderId");
        sql.append(" WHERE orders.id IN(" + fillEntry + ")");
        GeneralDao.executeAllTypeUpdate(sql.toString());
    }

    public void cancelOrderByArrayMultipleId(String[] multipleId){
        String fillEntry = String.format("'%s'", String.join("','", multipleId));
        String sql = "UPDATE orders SET orderStatusId = 5 WHERE id IN (" + fillEntry + ")";
        GeneralDao.executeAllTypeUpdate(sql);
    }

    public static void updateStatusByOrderId(String orderId, int orderStatusId, int transactionStatusId){
        String sql = "UPDATE orders SET orderStatusId = ?, transactionStatusId = ? WHERE id = ?";
        GeneralDao.executeAllTypeUpdate(sql, orderStatusId, transactionStatusId, orderId);
    }

    public Voucher getVoucherById(int id){
        String sql = "SELECT id, code, description, minimumPrice, discountPercent FROM vouchers WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Voucher.class, id).get(0);
    }

//    public static void main(String[] args) {
//        System.out.println(getVoucherById(1));
//        String[] list1 = {"1"};
//        String[] list2 = {"1", "2"};
//        Map<Object, List<String>> map = new HashMap<>();
//        map.put(new DeliveryMethod(), list1);
//        map.put(new PaymentMethod(), list2);
//
//        System.out.println(getListOrdersByFilterSection(map, "2022-10-01", "2022-10-30"));
//        System.out.println(getListAllOrders());
//        System.out.println(getListOrderByCustomerName("N"));
//        String sql = "SELECT id FROM orders";
//        List<Order> list = GeneralDao.executeQueryWithSingleTable(sql, Order.class);
//        for (Order order: list) {
//            System.out.println(order.getId());
//        }
//    }

    public static void main(String[] args) throws JsonProcessingException {
//        String[] multipleOrderId = {"0194e6c", "1223sh"};
//        cancelOrderByArrayMultipleId(multipleOrderId);
//        updateStatusByOrderId("0194e6c", 1, 2);
    }
}
