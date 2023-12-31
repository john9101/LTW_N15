package controller.admin.product;

import models.Product;
import models.Review;
import org.json.JSONObject;
import services.ProductServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin-show-product", value = "/admin-show-product")
public class ShowProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String idParameter = request.getParameter("id");

        int id;
        try {
            id = Integer.parseInt(idParameter.trim());
        } catch (NumberFormatException e) {
            response.sendError(404);
            return;
        }


        Product product = ProductServices.getINSTANCE().getProductByProductId(id);
        if (product == null) {
            response.sendError(404);
            return;
        }
        JSONObject jsonObject = new JSONObject(product);
        response.getWriter().write(jsonObject.toString());
    }
}