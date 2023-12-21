package controller;

import models.PaymentMethod;
import models.Shipping;
import services.CheckoutServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/Checkout")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shipping> listInfoShipping = CheckoutServices.getINSTANCE().getAllInformationShipping();
        List<PaymentMethod> listPaymentMethod = CheckoutServices.getINSTANCE().getAllPaymentMethod();
        request.setAttribute("listInfoShipping",listInfoShipping);
        request.setAttribute("listPaymentMethod", listPaymentMethod);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("checkout.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}