package controller.checkout;

import models.CartProduct;
import models.ShoppingCart;
import models.User;
import services.CheckoutServices;
import services.IMailServices;
import services.MailPlaceOrderService;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "SuccessOrderController", value = "/SuccessOrder")
public class SuccessOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User userAuth = (User) session.getAttribute("auth");
        String userIdCart = String.valueOf(userAuth.getId());
        ShoppingCart cart = (ShoppingCart) session.getAttribute(userIdCart);
        int invoiceNo = Integer.parseInt(request.getParameter("invoiceNo"));
        String dateOrder = LocalDate.now().toString();
        String fullNameBuyer = cart.getDeliveryInfo().getFullName();
        String emailBuyer = cart.getDeliveryInfo().getEmail();
        String phoneBuyer = cart.getDeliveryInfo().getPhone();
        String addressBuyer = cart.getDeliveryInfo().getAddress();
        int paymentMethodId = cart.getPaymentMethod().getId();
        Integer voucherId = null;
        Integer deliveryMethodId = null;
        try {
            voucherId = cart.getVoucherApplied().getId();
            deliveryMethodId = cart.getDeliveryMethod().getId();
            CheckoutServices.getINSTANCE().addNewOrder(invoiceNo, userAuth.getId(), dateOrder, fullNameBuyer, emailBuyer, phoneBuyer, addressBuyer, deliveryMethodId, paymentMethodId, "", voucherId);
        }catch (NullPointerException exception){
            exception.printStackTrace();
            CheckoutServices.getINSTANCE().addNewOrder(invoiceNo, userAuth.getId(), dateOrder, fullNameBuyer, emailBuyer, phoneBuyer, addressBuyer, deliveryMethodId, paymentMethodId, "", voucherId);
        }

        for(int productId : cart.getShoppingCartMap().keySet()){
            for (CartProduct cartProduct: cart.getShoppingCartMap().get(productId)) {
                CheckoutServices.getINSTANCE().addEachOrderDetail(invoiceNo, productId, cartProduct.getSize().getNameSize(), cartProduct.getColor().getCodeColor(), cartProduct.getQuantity(), cartProduct.getPriorityPrice());
            }
        }

        IMailServices mailPlaceOrderService = new MailPlaceOrderService(cart, dateOrder, invoiceNo);
        try {
            mailPlaceOrderService.send();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        session.removeAttribute(userIdCart);
        request.setAttribute("invoiceNo",invoiceNo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("successOrder.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}