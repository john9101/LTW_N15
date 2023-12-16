package dao;

import models.Review;

import java.util.List;

public class ReviewDAO {

    public List<Review> getReviewStar(int productId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ratingStar ")
                .append("FROM products JOIN (order_details JOIN reviews ON order_details.id = reviews.orderDetailId) ON products.id = order_details.productId ")
                .append("WHERE products.id = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Review.class, productId);
    }
}
