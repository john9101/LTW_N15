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

    public List<Review> getReview(int productId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT userId, ratingStar, feedback, reviewDate ")
                .append("FROM users JOIN (reviews JOIN (order_details JOIN products ")
                .append("ON products.id = order_details.productId) ")
                .append("ON reviews.orderDetailId = order_details.id) ")
                .append("ON users.id = reviews.userId ")
                .append("WHERE products.id = ?;");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Review.class, productId);
    }
}
