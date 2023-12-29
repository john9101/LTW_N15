package controller.checkout;

import models.PaymentMethod;
import models.DeliveryMethod;
import services.CheckoutServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/Checkout")
public class CheckoutController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher = null;
        if(action != null){
            switch (action) {
                case "choiceDeliveryMethod" -> {
                    String deliveryMethodId = request.getParameter("deliveryMethodId");
                    request.setAttribute("deliveryMethodId", deliveryMethodId);
                    requestDispatcher = request.getRequestDispatcher("ChoiceDeliveryMethod");
                    requestDispatcher.forward(request, response);
                }
                case "choicePaymentMethod" -> {
                    String paymentMethodId = request.getParameter("paymentMethodId");
                    request.setAttribute("paymentMethodId", paymentMethodId);
                    requestDispatcher = request.getRequestDispatcher("ChoicePaymentMethod");
                    requestDispatcher.forward(request, response);
                }
            }

            if(action.equals("addDeliveryInfo") || action.equals("editDeliveryInfo")){
                String fullName = request.getParameter("fullName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                request.setAttribute("fullName", fullName);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("address", address);

                if(action.equals("addDeliveryInfo")){
                    requestDispatcher = request.getRequestDispatcher("AddDeliveryInfo");
                    requestDispatcher.forward(request, response);
                }

                if(action.equals("editDeliveryInfo")){
                    String deliveryInfoKey = request.getParameter("deliveryInfoKey");
                    request.setAttribute("deliveryInfoKey", deliveryInfoKey);
                    requestDispatcher = request.getRequestDispatcher("EditDeliveryInfo");
                    requestDispatcher.forward(request, response);
                }
            }
        }else{
            String typeEdit = request.getParameter("typeEdit");
            if(typeEdit != null) {
                String deliveryInfoKey = request.getParameter("deliveryInfoKey");
                request.setAttribute("deliveryInfoKey", deliveryInfoKey);
                switch (typeEdit) {
                    case "removeDeliveryInfo" -> {
                        String statusChoice = request.getParameter("statusChoice");
                        request.setAttribute("statusChoice", statusChoice);
                        requestDispatcher = request.getRequestDispatcher("RemoveDeliveryInfo");
                        requestDispatcher.forward(request, response);
                    }
                    case "choiceDeliveryInfo" -> {
                        requestDispatcher = request.getRequestDispatcher("ChoiceDeliveryInfo");
                        requestDispatcher.forward(request, response);
                    }
                }
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DeliveryMethod> listDeliveryMethod = CheckoutServices.getINSTANCE().getAllInformationDeliveryMethod();
        List<PaymentMethod> listPaymentMethod = CheckoutServices.getINSTANCE().getAllPaymentMethod();
        request.setAttribute("listDeliveryMethod",listDeliveryMethod);
        request.setAttribute("listPaymentMethod", listPaymentMethod);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("checkout.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}