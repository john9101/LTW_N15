package controller.product;

import models.ProductCard;
import services.ProductCardServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "pagingProduct", value = "/pagingProduct")
public class Paging extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = (String) request.getParameter("page");
        System.out.println(page);
        try {
            int pageNumber = Integer.parseInt(page);
            List<ProductCard> productCardList = ProductCardServices.getINSTANCE().getProducts(pageNumber);
            request.setAttribute("productCardList", productCardList);
            request.getRequestDispatcher("productBuying.jsp").forward(request, response);
        } catch (NumberFormatException numberFormatException) {
            response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}