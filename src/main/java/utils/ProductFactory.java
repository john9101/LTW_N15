package utils;

import dao.ReviewDAO;
import models.*;
import services.ProductServices;

import java.util.List;

public class ProductFactory {

    public static Product getProductById(int productId){
        return ProductServices.getINSTANCE().getProductByProductId(productId);
    }

    public static List<Image> getListImagesByProductId(int productId){
        return ProductServices.getINSTANCE().getListImagesByProductId(productId);
    }

    public static List<Color> getListColorsByProductId(int productId){
        return ProductServices.getINSTANCE().getListColorsByProductId(productId);
    }

    public static List<Size> getListSizesByProductId(int productId){
        return ProductServices.getINSTANCE().getListSizesByProductId(productId);
    }

    public static double getPriceSizeByName(String nameSize, int productId){
        return ProductServices.getINSTANCE().getPriceSizeByName(nameSize, productId);
    }

    public static int calculateStar(Product product) {
        ReviewDAO reviewDAO = new ReviewDAO();
        List<Review> list = reviewDAO.getReviewStar(product.getId());
        if (list.isEmpty()) return 0;
        int totalStar = 0;
        for (Review item : list) {
            totalStar += item.getRatingStar();
        }
        return totalStar / list.size();
    }
}
