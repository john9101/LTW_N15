package controller.account;

import models.Order;
import models.OrderDetail;
import models.User;
import services.HistoryService;

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

        String statusString = request.getParameter("status");
        List<Order> listOrder;
        if (statusString == null || statusString.equalsIgnoreCase("tất cả")) {
            listOrder = HistoryService.getINSTANCE().getOrderByUserId(auth.getId());
        } else {
            int status;
            try {
                status = Integer.parseInt(statusString);
            } catch (NumberFormatException e) {
                response.sendError(404);
                return;
            }
            listOrder = HistoryService.getINSTANCE().getOrderByUserIdAndStatusOrder(auth.getId(), status);
            if (status == 4) {
                List<OrderDetail> listOrderDetailNotReview = HistoryService.getINSTANCE().getOrderDetailNotReview(auth.getId());
                System.out.println(listOrderDetailNotReview);
                request.setAttribute("OrderDetailNotReview", listOrderDetailNotReview);
            }
        }

        List<String> listOrderId = new ArrayList<>();
        for (Order orders : listOrder) {
            listOrderId.add(orders.getId());
        }

        List<OrderDetail> listOrderDetail = HistoryService.getINSTANCE().getOrderDetailByOrderId(listOrderId);

        for (OrderDetail orderdetails : listOrderDetail) {
            HistoryService.getINSTANCE().getProductInOrderDetail(orderdetails.getId());
        }
        System.out.println(listOrderDetail);
        request.setAttribute("listPurchaseHistory", listOrderDetail);
        request.setAttribute("tag", statusString);
        request.getRequestDispatcher("purchaseHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}