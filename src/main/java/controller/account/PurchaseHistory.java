package controller.account;

import dao.OrderDAO;
import models.Order;
import models.OrderDetail;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseHistory", value = "/PurchaseHistory")
public class PurchaseHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User auth = (User) session.getAttribute("auth");

        String status = request.getParameter("status");

        if (status == null || status.equalsIgnoreCase("tất cả")){
            OrderDAO order = new OrderDAO();
            List<Order> listOrder = order.getOrderByUserId(auth.getId());

            List<Integer> listOrderId = new ArrayList<>();
            for (Order orders:listOrder) {
                listOrderId.add(orders.getId());
            }
            List<OrderDetail> listOrderDetail = order.getOrderDetailByOrderId(listOrderId);

            for(OrderDetail orderdetails:listOrderDetail) {
                order.getProductInOrderDetail(orderdetails.getId());
            }

            request.setAttribute("listPurchaseHistory", listOrderDetail);
        }else{
            List<Order> listOrder = new ArrayList<>();
            OrderDAO order = new OrderDAO();
            if (status.equalsIgnoreCase("HOÀN THÀNH")) {
                listOrder = order.getOrderByUserIdAndStatusOrder(auth.getId(), status);
            } else {
                listOrder = order.getOrderByUserIdAndStatusOrder(auth.getId(), status);
            }
            List<Integer> listOrderId = new ArrayList<>();
            for (Order orders:listOrder) {
                listOrderId.add(orders.getId());
            }
            List<OrderDetail> listOrderDetail = order.getOrderDetailByOrderId(listOrderId);

            for(OrderDetail orderdetails:listOrderDetail) {
                order.getProductInOrderDetail(orderdetails.getId());
            }
            request.setAttribute("listPurchaseHistory", listOrderDetail);
        }
        request.setAttribute("tag",status);
        request.getRequestDispatcher("purchaseHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}