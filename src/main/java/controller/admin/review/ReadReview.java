package controller.admin.review;

import models.OrderDetail;
import models.Parameter;
import models.Review;
import org.json.JSONArray;
import services.AdminReviewServices;
import services.ProductCardServices;
import services.ReviewServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminReadReview", value = "/admin-read-review")
public class ReadReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParameter = request.getParameter("id");
        int reviewId;
        try {
            reviewId = Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            response.sendError(404);
            return;
        }
        Review review = AdminReviewServices.getINSTANCE().getReview(reviewId);
        System.out.println(review.getFeedback());
        OrderDetail orderDetail = ReviewServices.getINSTANCE().getOrderDetail(review.getOrderDetailId());

        String color = orderDetail.getColorRequired();
        String[] sizes = readSizes(orderDetail.getSizeRequired());
        int quantity = orderDetail.getQuantityRequired();
        int productId = orderDetail.getProductId();
        String nameProduct = ProductCardServices.getINSTANCE().getNameProductById(productId);
        List<Parameter> listParameter = ProductCardServices.getINSTANCE().getParameterByIdCategory(productId);
        request.setAttribute("review", review);
        request.setAttribute("orderDetailId", review.getOrderDetailId());
        request.setAttribute("productId", productId);
        request.setAttribute("nameProduct", nameProduct);
        request.setAttribute("listParameter", listParameter);
        request.setAttribute("color", color);
        request.setAttribute("sizes", sizes);
        request.setAttribute("quantity", quantity);
        request.getRequestDispatcher("adminReviewForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private String[] readSizes(String sizesJson) {
        JSONArray jsonArray = new JSONArray(sizesJson);
        String[] sizes = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            sizes[i] = jsonArray.getString(i);
        }
        return sizes;
    }
}