package controller.authentication;

import models.User;
import services.AuthenticateServices;
import utils.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "signUp", value = "/signUp")
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        System.out.println(username + "\n" + email + "\n" + password + "\n" + confirmPassword);

        Validation validation = AuthenticateServices.getINSTANCE().checkSignUp(username, email, password, confirmPassword);
        Map<String, String> mapErrorPassword = AuthenticateServices.getINSTANCE().checkPasswordTemplate(password);
        if (validation.getObjReturn() != null && mapErrorPassword.isEmpty()) {
            User newUser = (User) validation.getObjReturn();
            AuthenticateServices.getINSTANCE().createUser(newUser);
            request.setAttribute("sendMail", "Send Mail Success");
        } else {
            request.setAttribute("usernameError", validation.getFieldUsername());
            request.setAttribute("emailError", validation.getFieldEmail());
            request.setAttribute("passwordError", validation.getFieldPassword());
            request.setAttribute("passwordConfirmError", validation.getFieldConfirmPassword());

            request.setAttribute("charUpper", mapErrorPassword.get("char-upper"));
            request.setAttribute("charMinLength", mapErrorPassword.get("char-min-length"));
            request.setAttribute("charLower", mapErrorPassword.get("char-lower"));
            request.setAttribute("charNumber", mapErrorPassword.get("char-number"));
            request.setAttribute("charSpecial", mapErrorPassword.get("char-special"));
            request.setAttribute("noSpace", mapErrorPassword.get("no-space"));
        }
        request.getRequestDispatcher("signUp.jsp").forward(request, response);
    }
}