package controller.checkout;

import models.DeliveryInfo;
import models.ShoppingCart;
import models.User;
import services.IMailServices;
import services.MailPlaceOrderService;
import services.MailResetPasswordServices;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "PlaceOrderController", value = "/PlaceOrder")
public class PlaceOrderController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(true);
        User userAuth = (User) session.getAttribute("auth");
        String userIdCart = String.valueOf(userAuth.getId());
        ShoppingCart cart = (ShoppingCart) session.getAttribute(userIdCart);
        DeliveryInfo deliveryInfoBuyer = cart.getDeliveryInfo();
        String fullNameBuyer = deliveryInfoBuyer.getFullName();
        String emailBuyer = deliveryInfoBuyer.getEmail();
        String phoneBuyer = deliveryInfoBuyer.getPhone();
        String addressBuyer = deliveryInfoBuyer.getAddress();
        Timestamp timestampCurrent = Timestamp.valueOf(LocalDateTime.now());

        IMailServices mailPlaceOrderService = new MailPlaceOrderService(emailBuyer, emailBuyer, timestampCurrent);
        try {
            mailPlaceOrderService.send();
        } catch (MessagingException e) {
            System.out.println(111);
            throw new RuntimeException(e);
        }
        response.getWriter().print("Bạn đã đặt hàng thành công");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}