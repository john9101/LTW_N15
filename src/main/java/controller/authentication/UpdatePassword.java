package controller.authentication;

import services.AuthenticateServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updatePassword", value = "/updatePassword")
public class UpdatePassword extends HttpServlet {
    String updateSuccess = "";
    String errorPassword = "Mật khẩu phải có tối thiểu 6 kí tự";
    String errorPasswordConfirm = "Mật khẩu nhập lại không trùng khớp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        int countError = 0;

        if (password.length() < 6) {
            request.setAttribute("errorEmail", errorPassword);
            countError++;
        }
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorConfirm", errorPasswordConfirm);
            countError++;
        }
        if (countError == 0) {
            AuthenticateServices.getINSTANCE().updatePassword(email, password);
            request.setAttribute("updateSuccess", updateSuccess);
        }

    }
}