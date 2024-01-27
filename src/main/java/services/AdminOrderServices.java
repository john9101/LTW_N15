package services;

import dao.OrderDetailDAO;
import dao.order.OrderDao;
import dao.order.OrderStatusDao;
import dao.order.TransactionStatusDao;
import models.*;
import utils.FormatCurrency;

import java.util.List;
import java.util.Map;

public class AdminOrderServices {

    private OrderDao orderDao;
    private OrderStatusDao orderStatusDao;
    private TransactionStatusDao transactionStatusDao;

    private OrderDetailDAO orderDetailDAO;

    private static AdminOrderServices INSTANCE;

    public AdminOrderServices() {
        orderDao = new OrderDao();
        orderStatusDao = new OrderStatusDao();
        transactionStatusDao = new TransactionStatusDao();
        orderDetailDAO = new OrderDetailDAO();
    }
    public static AdminOrderServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AdminOrderServices();
        return INSTANCE;
    }

    public List<OrderStatus> getListAllOrderStatus(){
        return orderStatusDao.getListAllOrderStatus();
    }

    public List<TransactionStatus> getListAllTransactionStatus(){
        return transactionStatusDao.getListAllTransactionStatus();
    }

    public OrderStatus getOrderStatusById(int orderStatusId){
        return orderStatusDao.getOrderStatusById(orderStatusId);
    }

    public TransactionStatus getTransactionStatusById(int transactionStatusId){
        return transactionStatusDao.getTransactionStatusById(transactionStatusId);
    }

    public List<Order> getListAllOrders(){
        return orderDao.getListAllOrders();
    }

    public List<Order> getListOrdersBySearchFilter(Map<Object, List<String>> mapFilterSectionOrders, String contentSearch, String searchSelect, String startDate, String endDate) {
        return orderDao.getListOrdersBySearchFilter(mapFilterSectionOrders, contentSearch, searchSelect, startDate, endDate);
    }

    public List<PaymentMethod> getListAllPaymentMethodManage(){
        return orderDao.getListAllPaymentMethodManage();
    }

    public List<DeliveryMethod> getListAllDeliveryMethodManage(){
        return orderDao.getListAllDeliveryMethodManage();
    }

    public PaymentMethod getPaymentMethodMangeById(int id){
        return orderDao.getPaymentMethodMangeById(id);
    }

    public DeliveryMethod getDeliveryMethodManageById(int id){
        return orderDao.getDeliveryMethodManageById(id);
    }

//    public List<Order> getListOrderById(String orderId){
//        return orderDao.getListOrderByPartialId(orderId);
//    }

//    public List<Order> getListOrderByCustomerName(String customerName){
//        return orderDao.getListOrderByCustomerName(customerName);
//    }

    public Order getOrderById(String id){
        return orderDao.getOrderById(id);
    }

//    public void updateOrderStatusIdByOrderId(int orderStatusId , String orderId){
//        orderDao.updateOrderStatusIdByOrderId(orderStatusId, orderId);
//    }
//
//    public void updateTransactionStatusIdByOrderId(int transactionStatusId , String orderId){
//        orderDao.updateTransactionStatusIdByOrderId(transactionStatusId,orderId);
//    }

    public void removeOrderByMultipleId(String[] MultipleId){
        orderDao.removeOrderByMultipleId(MultipleId);
    }

    public void cancelOrderByMultipleId(String[] multipleId){
        orderDao.cancelOrderByArrayMultipleId(multipleId);
    }

    public List<OrderDetail> getListOrderDetailByOrderId(String orderId){
        return orderDetailDAO.getListOrderDetailByOrderId(orderId);
    }

    public void updateStatusByOrderId(String orderId, int orderStatusId, int transactionStatusId){
        orderDao.updateStatusByOrderId(orderId, orderStatusId, transactionStatusId);
    }

    public Voucher getVoucherById(int id){
        return orderDao.getVoucherById(id);
    }

    public String getTotalPriceFormatByOrderId(String orderId){
        Order order = orderDao.getOrderById(orderId);
        List<OrderDetail> listOrderDetail = orderDetailDAO.getListOrderDetailByOrderId(orderId);
        double totalPrice = 0;
        for (OrderDetail orderDetail :listOrderDetail) {
            totalPrice += orderDetail.getPrice();
        }

        if(order.getVoucherId() != 0){
            Voucher voucher = getVoucherById(order.getVoucherId());
            totalPrice  *= (1 - voucher.getDiscountPercent());
        }
        return FormatCurrency.vietNamCurrency(totalPrice);
    }


}
