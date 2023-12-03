package controller;

import models.Sliders;
import services.HomeServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "HomeController", value = "/Home")
public class HomeController extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Map<String, Object>> listNewProducts = HomeServices.getINSTANCE().getListNewProducts(false);
        List<Sliders> listSlideShow = HomeServices.getINSTANCE().getListSlideShow();
        request.setAttribute("list_slide_show", listSlideShow);
        request.setAttribute("list_new_products", listNewProducts);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}