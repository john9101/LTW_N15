package controller;

import services.ContactServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Serializable;

@WebServlet(name = "ContactController", value = "/Contact")
public class ContactController extends HttpServlet implements Serializable {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        if(subject == null){
            subject = "Thắc mắc chung";
        }
        String message = request.getParameter("message");
        ContactServices.getINSTANCE().addNewRecordUserContact(fullName, phone, email, subject, message);

        String successNotification = successNotificationHTML("Bạn đã gửi liên hệ thành công");
        request.setAttribute("successNotification",successNotification);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact.jsp");
        requestDispatcher.forward(request, response);
    }

    private String successNotificationHTML(String successNotification){
        return "<span class=\"success__notification\">" + successNotification + "</span>";
    }
}