package dao;

import models.Review;

import java.util.List;

public interface ReviewDAO extends DAO<Review> {
    public List<Review> getReviewStar(int productId);
}
