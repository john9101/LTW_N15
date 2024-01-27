package controller.authentication;

import models.User;
import models.UserSessionAccess;
import services.AuthenticateServices;
import utils.Validation;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "signIn", value = "/signIn")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        Validation validation = AuthenticateServices.getINSTANCE().checkSignIn(username, password);

        if (validation.getObjReturn() != null) {
            User userAuth = (User) validation.getObjReturn();
            HttpSession session = request.getSession(true);
            session.setAttribute("auth", userAuth);

            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("usernameError", validation.getFieldUsername());
            request.setAttribute("passwordError", validation.getFieldPassword());
            request.getRequestDispatcher("signIn.jsp").forward(request, response);
        }
    }
}



