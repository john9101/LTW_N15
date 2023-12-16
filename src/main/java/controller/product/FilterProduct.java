package controller.product;

import models.ID;
import models.Product;
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
        String pageNumber = request.getParameter("pageNumber");
        int page;
        try {
            page = Integer.parseInt(pageNumber);
        } catch (NumberFormatException e) {
            page = 1;
        }
        System.out.println(filterByColor);
        System.out.println(filterByMoneyRange);
        System.out.println(filterByCategoryId);
        System.out.println(filterBySize);
        List<List<Integer>> listId = new ArrayList<>();
        if (filterByColor != null) {
            listId.add(filterBySize);
        }
        if (filterByCategoryId != null) {
            listId.add(filterByCategoryId);
        }
        if (filterByMoneyRange != null) {
            listId.add(filterByMoneyRange);
        }
        if (filterBySize != null) {
            listId.add(filterBySize);
        }
        List<Integer> listIDFiltered = findCommonIDs(listId);
        List<Product> productCardFiltered = ProductCardServices.getINSTANCE().filter(listIDFiltered, page);
        int quantityPage = ProductCardServices.getINSTANCE().getQuantityPage(listIDFiltered.size());

        // Getting the request URL
        StringBuffer requestURL = request.getRequestURL();

        // Getting the query string (parameters)
        String queryString = request.getQueryString();

        // Combining the request URL and query string to get the full URL with parameters
        if (queryString != null) {
            requestURL.append("?").append(queryString);
        }

        request.setAttribute("requestURL", requestURL);
        request.setAttribute("productCardList", productCardFiltered);
        request.setAttribute("quantityPage", quantityPage);

        request.getRequestDispatcher("productBuying.jsp").forward(request, response);

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