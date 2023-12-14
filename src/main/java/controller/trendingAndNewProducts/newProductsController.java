package controller.trendingAndNewProducts;

import models.Products;
import services.HomeServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "newProductsController", value = "/newProducts")
public class newProductsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> listAllNewProducts = HomeServices.getINSTANCE().getListNewProducts(true);
        int page = 0, itemsPerPage = 8;
        int size = listAllNewProducts.size();
        int totalPage = (size % itemsPerPage == 0 ? (size / itemsPerPage) : ((size / itemsPerPage)) + 1);

        String xPage = request.getParameter("page");
        if (xPage == null) {
            page = 1;
        } else {
            try {
                page = Integer.parseInt(xPage);
            }catch (NumberFormatException exception){
                exception.printStackTrace();
            }
        }

        int start, end;
        start = (page - 1) * itemsPerPage;
        end = Math.min(page * itemsPerPage, size);
        List<Products> listProductsPerPage = getListProductsPerPage(listAllNewProducts, start, end);

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("listProductsPerPage", listProductsPerPage);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("newProducts.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public List<Products> getListProductsPerPage(List<Products> listProducts, int start, int end) {
        List<Products> listProductsPerPage = new ArrayList<>();
        for (int i = start; i < end; i++) {
            listProductsPerPage.add(listProducts.get(i));
        }
        return listProductsPerPage;
    }
}