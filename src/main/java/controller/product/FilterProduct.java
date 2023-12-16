package controller.product;

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
        List<Integer> filterByColor = (List<Integer>) request.getAttribute("filterByColor");
        List<Integer> filterByCategoryId = (List<Integer>) request.getAttribute("filterByCategoryId");
        List<Integer> filterByMoneyRange = (List<Integer>) request.getAttribute("filterByMoneyRange");
        List<Integer> filterBySize = (List<Integer>) request.getAttribute("filterBySize");

        System.out.println(filterByColor);
        System.out.println(filterByMoneyRange);
        System.out.println(filterByCategoryId);
        System.out.println(filterBySize);
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

    private List<Integer> findCommonIDs(List<List<Integer>> lists) {
        if (lists.isEmpty()) return null;
        if (lists.size() == 1) return lists.get(0);
        List<Integer> result = new ArrayList<>();
        result = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            result.retainAll(lists.get(i));
        }
        return result;
    }

}