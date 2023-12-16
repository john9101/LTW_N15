package utils;

import dao.ReviewDAO;
import dao.ReviewDAOImplement;
import models.*;
import services.HomeServices;
import services.ProductServices;

import java.util.List;

public class ProductFactory {

    public static Products getProductById(int productId){
        return ProductServices.getINSTANCE().getProductByProductId(productId);
    }

    public static List<Images> getListImagesByProductId(int productId){
        return ProductServices.getINSTANCE().getListImagesByProductId(productId);
    }

    public static List<Colors> getListColorsByProductId(int productId){
        return ProductServices.getINSTANCE().getListColorsByProductId(productId);
    }

    public static List<Sizes> getListSizesByProductId(int productId){
        return ProductServices.getINSTANCE().getListSizesByProductId(productId);
    }

    public static double getPriceSizeByName(String nameSize, int productId){
        return ProductServices.getINSTANCE().getPriceSizeByName(nameSize, productId);
    }

    public static int calculateStar(Products product) {
        ReviewDAO reviewDAO = new ReviewDAOImplement();
        List<Review> list = reviewDAO.getReviewStar(product.getId());
        if (list.isEmpty()) return 0;
        int totalStar = 0;
        for (Review item : list) {
            totalStar += item.getRatingStar();
        }
        return totalStar / list.size();
    }
}
