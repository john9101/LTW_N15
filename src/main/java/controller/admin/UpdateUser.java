package controller.admin;

import dao.UserDAO;
import dao.UserDAOImplement;
import models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UpdateUser", value = "/UpdateUser")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("userID");
        try {
            int id = Integer.parseInt(idString);
            UserDAO userDAO = new UserDAOImplement();
            List<User> user = userDAO.getUserByID(id);
            request.setAttribute("user", user.get(0));
            request.getRequestDispatcher("adminUsers.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userIdString = request.getParameter("userID");
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String birthDayString = request.getParameter("birthDay");

        try {
            int userId = Integer.parseInt(userIdString);
            Date birthDay = Date.valueOf(birthDayString);

            UserDAO userDAO = new UserDAOImplement();
            userDAO.updateUserByID(userId, username, fullName, gender, email, phone, address, birthDay);

            response.sendRedirect(request.getContextPath() + "/AdminUser");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
            throw e;
        }
    }
}