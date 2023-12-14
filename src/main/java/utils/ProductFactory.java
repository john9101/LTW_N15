package utils;

import models.Images;
import services.HomeServices;

import java.util.List;

public class ProductFactory {

    public static List<Images> getListImagesByProductId(int productId){
        return HomeServices.getINSTANCE().getListImagesByProductId(productId);
    }
}
