package dao.order;

import dao.GeneralDao;
import models.OrderStatus;

import java.util.List;

public class OrderStatusDao {

    public List<OrderStatus> getListAllOrderStatus(){
        String sql = "SELECT id, typeStatus FROM order_statuses";
        return GeneralDao.executeQueryWithSingleTable(sql, OrderStatus.class);
    }
}
