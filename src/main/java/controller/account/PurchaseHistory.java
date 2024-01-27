package controller.account;

import models.Order;
import models.OrderDetail;
import models.Product;
import models.User;
import services.HistoryService;

import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
        System.out.println(status);

        if (status == null || status.equalsIgnoreCase("tất cả")){
            List<Order> listOrder = HistoryService.getINSTANCE().getOrderByUserId(auth.getId());

            List<Integer> listOrderId = new ArrayList<>();
            for (Order orders:listOrder) {
                listOrderId.add(orders.getId());
            }
            List<OrderDetail> listOrderDetail = HistoryService.getINSTANCE().getOrderDetailByOrderId(listOrderId);

            for(OrderDetail orderdetails:listOrderDetail) {
                HistoryService.getINSTANCE().getProductInOrderDetail(orderdetails.getId());
            }

            request.setAttribute("listPurchaseHistory", listOrderDetail);
        }else{
            List<Order> listOrder = HistoryService.getINSTANCE().getOrderByUserIdAndStatusOrder(auth.getId(), status);

            if (status.equalsIgnoreCase("HOÀN THÀNH")){
                List<OrderDetail> listOrderDetailNotReview = HistoryService.getINSTANCE().getOrderDetailNotReview(auth.getId());

                request.setAttribute("OrderDetailNotReview", listOrderDetailNotReview);
            }

            List<Integer> listOrderId = new ArrayList<>();
            for (Order orders:listOrder) {
                listOrderId.add(orders.getId());
            }
            List<OrderDetail> listOrderDetail = HistoryService.getINSTANCE().getOrderDetailByOrderId(listOrderId);

            System.out.println(listOrder);
//            System.out.println(listOrderDetailNotReview);
            for(OrderDetail orderdetails:listOrderDetail) {
                HistoryService.getINSTANCE().getProductInOrderDetail(orderdetails.getId());
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