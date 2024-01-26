package dao;

import models.OrderDetail;

import java.util.List;

public class OrderDetailDAO {
    public List<OrderDetail> getOrderDetailById(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT productId, sizeRequired, colorRequired, quantityRequired, price ")
                .append("FROM order_details ")
                .append("WHERE id = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), OrderDetail.class, id);
    }

    public List<OrderDetail> getListOrderDetailByOrderId(String orderId){
        StringBuilder sql = new StringBuilder("SELECT id, orderId, productId, productName, sizeRequired, colorRequired, quantityRequired, price ");
        sql.append(" FROM order_details WHERE orderId = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), OrderDetail.class, orderId);
    }

    public static void main(String[] args) {

    }
}
