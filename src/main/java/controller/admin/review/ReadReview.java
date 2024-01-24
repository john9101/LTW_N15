package controller.admin.review;

import models.OrderDetail;
import models.Parameter;
import models.Product;
import models.Review;
import org.json.JSONArray;
import org.json.JSONObject;
import services.AdminReviewServices;
import services.ProductCardServices;
import services.ReviewServices;
import utils.ProductFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "adminReadReview", value = "/admin-read-review")
public class ReadReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String idParameter = request.getParameter("id");
        int reviewId;
        try {
            reviewId = Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            response.sendError(404);
            return;
        }
        Review review = AdminReviewServices.getINSTANCE().getReview(reviewId);
        if (review == null) {
            response.sendError(404);
            return;
        }
        OrderDetail orderDetail = ReviewServices.getINSTANCE().getOrderDetail(review.getOrderDetailId());
        String size = orderDetail.getSizeRequired();
        String color = orderDetail.getColorRequired();
        int quantity = orderDetail.getQuantityRequired();
        int productId = orderDetail.getProductId();
        String image = ProductFactory.getListImagesByProductId(productId).get(0).getNameImage();
        String nameProduct = ProductCardServices.getINSTANCE().getNameProductById(productId);
        String nameCategory = ProductCardServices.getINSTANCE().getNameCategoryById(productId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", nameProduct);
        jsonObject.put("image", image);
        jsonObject.put("category", nameCategory);
        jsonObject.put("sizeRequired", size);
        jsonObject.put("colorRequired", color);
        jsonObject.put("quantityRequired", quantity);
        jsonObject.put("feedback", review.getFeedback());
        jsonObject.put("stars", review.getRatingStar());
        response.getWriter().write(jsonObject.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(404);
    }

}