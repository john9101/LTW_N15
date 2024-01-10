package services.order;

import dao.order.OrderDao;
import dao.order.OrderStatusDao;
import models.OrderStatus;

import java.util.List;

public class OrderStatusServices {

    private OrderStatusDao orderStatusDao;
    private static OrderStatusServices INSTANCE;

    public OrderStatusServices() {
        orderStatusDao = new OrderStatusDao();
    }

    public static OrderStatusServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new OrderStatusServices();
        return INSTANCE;
    }

    public List<OrderStatus> getListAllOrderStatus(){
        return orderStatusDao.getListAllOrderStatus();
    }
}
