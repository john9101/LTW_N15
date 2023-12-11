package controller;

import models.User;
import services.ContactServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ContactController", value = "/Contact")
public class ContactController extends HttpServlet implements Serializable {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, Object>> listContactSubjects = ContactServices.getINSTANCE().getListContactSubjects();
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("list_contact_subjects", listContactSubjects);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        request.setAttribute("fullName", fullName);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("subject", subject);

        if(subject == null) {
            subject = "Thắc mắc chung";
        }

        boolean validationFullName = validationFullName(request,fullName);
        boolean validationPhone = validationPhone(request, phone);
        boolean validationEmail = validationEmail(request, email);

        if(validationFullName && validationPhone && validationEmail){
            int subjectId = ContactServices.getINSTANCE().getIdContactSubjectByName(subject);
            User userAuth = (User) request.getSession(true).getAttribute("auth");
            int userAuthId;
            if(userAuth != null){
                userAuthId = userAuth.getId();
            }else{
                userAuthId = 0;
            }
            ContactServices.getINSTANCE().addNewRecordUserContact(userAuthId, fullName, phone, email, subjectId, message);
            String successNotification = successNotificationHTML("Bạn đã gửi liên hệ thành công");
            request.removeAttribute("fullName");
            request.removeAttribute("phone");
            request.removeAttribute("email");
            request.removeAttribute("subject");
            request.setAttribute("successNotification",successNotification);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("contact.jsp");
        requestDispatcher.forward(request, response);
    }

    private String successNotificationHTML(String successNotification){
        return "<span class=\"success__notification\">" + successNotification + "</span>";
    }

    private boolean validationFullName(HttpServletRequest request, String fullName)  throws ServletException, IOException{
        if(fullName == null || fullName.trim().isEmpty()){
            request.setAttribute("fullNameError", "Vui lòng bạn nhập họ và tên");
            return false;
        }
        return true;
    }

    private boolean validationPhone(HttpServletRequest request, String phone) throws ServletException, IOException{
        if(phone == null || phone.trim().isEmpty()){
            request.setAttribute("phoneError", "Vui lòng bạn nhập số điện thoại");
            return false;
        }else{
            Pattern  patternPhone = Pattern.compile("^\\+?(?:\\d\\s?){9,13}$");
            Matcher matcherPhone = patternPhone.matcher(phone);
            if(!matcherPhone.matches()){
                request.setAttribute("phoneError", "Vui lòng bạn nhập số điện thoại hợp lệ (Số điện thoại gồm 10 bắt đầu bằng số 0)");
                return false;
            }else{
                return true;
            }
        }
    }

    private boolean validationEmail(HttpServletRequest request, String email) throws ServletException, IOException{
//        String demoRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]+$";
        if(email == null || email.trim().isEmpty()){
            request.setAttribute("emailError", "Vui lòng bạn nhập email");
            return false;
        }else{
            Pattern patternEmail = Pattern.compile("^\\w+@\\w+\\.[A-Za-z]+$");
            Matcher matcherEmail = patternEmail.matcher(email);
            if(!matcherEmail.matches()){
                request.setAttribute("emailError", " Vui lòng bạn nhập email hơp lệ (Cấu trúc email: tên_email@tên_miền) <br/> Ví dụ: yourname@example.com");
                return false;
            }else{
                return true;
            }
        }
    }
}