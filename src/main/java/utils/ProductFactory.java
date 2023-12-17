package utils;

import dao.ReviewDAO;
import models.*;
import services.ProductCardServices;
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

    public static int getReviewCount(int productId) {
        return ProductCardServices.getINSTANCE().getReviewCount(productId);
    }
    public static int calculateStar(int productId) {
       return ProductCardServices.getINSTANCE().calculateStar(productId);
    }
}
