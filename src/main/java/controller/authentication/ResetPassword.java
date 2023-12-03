package controller.authentication;

import services.AuthenticateServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "resetPassword", value = "/resetPassword")
public class ResetPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String tokenVerify = request.getParameter("token-reset-password");
        boolean status = AuthenticateServices.getINSTANCE().resetPassword(email, tokenVerify);
        if (status) {
            request.setAttribute("email", email);
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
        } else {
            response.sendError(404);
        }
    }
}