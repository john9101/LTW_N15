package controller.admin;

import dao.UserDAO;
import dao.UserDAOImplement;
import models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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

    }
}