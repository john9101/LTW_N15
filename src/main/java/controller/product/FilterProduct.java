package controller.product;

import com.google.gson.Gson;
import models.ID;
import models.ProductCard;
import services.ProductCardServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "filterProduct", value = "/filterProduct")
public class FilterProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] categoryId = (String[]) request.getAttribute("categoryId");
        String[] moneyRange = request.getParameterValues("moneyRange");
        String[] size = request.getParameterValues("size");
        String[] color = request.getParameterValues("color");


//        Filter and save list after filter into servletContext
//        String pageNumber  = request.getParameter("pageNumber");
//        HashSet<ID> setIdProductFiltered = new HashSet<>();
//        List<ID> filterByName = (List<ID>) request.getAttribute("filterByName");
//        System.out.println(filterByName);
//        if (filterByName != null) {
//            setIdProductFiltered.addAll(filterByName);
//        }
//        String pageNumberParameter = request.getParameter("pageNumber");
//        int pageNumber;
//        if (pageNumberParameter == null) {
//            pageNumber = 1;
//        } else {
//            pageNumber = Integer.parseInt(pageNumberParameter);
//        }
//        List<ProductCard> productCardFiltered = ProductCardServices.getINSTANCE().filter(new ArrayList<>(setIdProductFiltered), pageNumber);
//
//        if (request.getParameter("requestType") != null && request.getParameter("requestType").equals("json")) {
//            Gson gson = new Gson();
//            System.out.println("json call");
//            String json = gson.toJson(productCardFiltered);
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write(json);
//        } else {
//            request.setAttribute("productCardList", productCardFiltered);
//            request.getRequestDispatcher("productBuying.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }



}