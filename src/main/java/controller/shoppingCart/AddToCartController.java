package controller.shoppingCart;

import models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCartController", value = "/AddToCart")
public class AddToCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int productId = Integer.parseInt(request.getParameter("productId"));
        HttpSession session = request.getSession(true);
        User userAuth = (User) session.getAttribute("auth");
        if(userAuth == null){
            response.sendRedirect("signIn.jsp");
        }else{
            int userAuthId = userAuth.getId();
            int quantityRequired;
            try {
                quantityRequired = Integer.parseInt(request.getParameter("quantity"));
                if(quantityRequired <= 0){
                    quantityRequired = 1;
                }
            }catch (NumberFormatException exception){
                quantityRequired = 1;
            }
        }
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