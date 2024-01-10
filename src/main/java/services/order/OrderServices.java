package services.order;

import dao.HomeDao;
import dao.order.OrderDao;
import services.HomeServices;

public class OrderServices {

    private OrderDao orderDao;
    private static OrderServices INSTANCE;

    public OrderServices() {
        orderDao = new OrderDao();
    }

    public static OrderServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new OrderServices();
        return INSTANCE;
    }
}
