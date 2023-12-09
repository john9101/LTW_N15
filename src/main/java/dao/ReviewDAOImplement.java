package dao;

import models.Review;

import java.util.List;

public class ReviewDAOImplement implements ReviewDAO {
    @Override
    public Review selectById(int id) {
        return null;
    }

    @Override
    public int insert(Review o) {
        return 0;
    }

    @Override
    public int insertAll(List<Review> list) {
        return 0;
    }

    @Override
    public int delete(Review o) {
        return 0;
    }

    @Override
    public int deleteAll(List<Review> list) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public List<Review> getReviewStar(int productId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ratingStar ")
                .append("FROM products JOIN (order_details JOIN reviews ON order_details.id = reviews.orderDetailId) ON products.id = order_details.productId ")
                .append("WHERE products.id = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Review.class, productId);
    }
}
