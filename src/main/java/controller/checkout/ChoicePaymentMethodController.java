package controller.checkout;

import models.PaymentMethod;
import models.ShoppingCart;
import models.User;
import services.CheckoutServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChoicePaymentMethodController", value = "/ChoicePaymentMethod")
public class ChoicePaymentMethodController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int paymentMethodId = 0;
        try {
            paymentMethodId = Integer.parseInt((String) request.getAttribute("paymentMethodId"));
        }catch (NumberFormatException exception){
            exception.printStackTrace();
        }
        PaymentMethod paymentMethod = CheckoutServices.getINSTANCE().getPaymentMethodById(paymentMethodId);
        HttpSession session = request.getSession(true);
        User userAuth = (User) session.getAttribute("auth");
        String userIdCart = String.valueOf(userAuth.getId());
        ShoppingCart cart = (ShoppingCart) request.getAttribute(userIdCart);
        cart.setPaymentMethod(paymentMethod);
        session.setAttribute(userIdCart, cart);
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