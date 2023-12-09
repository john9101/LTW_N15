package services;

import dao.*;
import models.Image;
import models.ProductCart;
import models.Review;

import java.util.List;

public class ProductCartServices {
    private static ProductCartServices INSTANCE;

    private ProductCartServices() {
    }

    public static ProductCartServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new ProductCartServices();
        return INSTANCE;
    }

    private int calculateStar(ProductCart productCart) {
        ReviewDAO reviewDAO = new ReviewDAOImplement();
        List<Review> list = reviewDAO.getReviewStar(productCart.getId());
        productCart.setReviews(list.size());
        if (list.isEmpty()) return 0;
        int totalStar = 0;
        for (Review item : list) {
            totalStar += item.getRatingStar();
        }
        return totalStar / list.size();
    }

    public List<ProductCart> getAllProductCart() {
        ProductCartDAO productCartDAO = new ProductCartDAOImplement();
        List<ProductCart> productCartList = productCartDAO.getCartAllProduct();
        ImageDAO imageDAO = new ImageDAO();
        for (ProductCart productCart : productCartList) {
//           Get thumbnail
            int productId = productCart.getId();
            List<Image> imageList = imageDAO.getThumbnail(productId);
            productCart.setNameImage(imageList.getFirst().getNameImage());
//           Calculate starRating
            int star = calculateStar(productCart);
            productCart.setStar(star);
        }
        return productCartList;
    }
}
