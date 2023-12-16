package services;

import dao.HomeDao;
import dao.ProductDao;
import models.Colors;
import models.Images;
import models.Products;
import models.Sizes;

import java.util.List;

public class ProductServices {

    private ProductDao productDao;
    private static ProductServices INSTANCE;

    public ProductServices() {
        productDao = new ProductDao();
    }

    public static ProductServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new ProductServices();
        return INSTANCE;
    }

    public List<Images> getListImagesByProductId(int productId){
        return productDao.getListImagesByProductId(productId);
    }

    public List<Colors> getListColorsByProductId(int productId){
        return productDao.getListColorsByProductId(productId);
    }

    public List<Sizes> getListSizesByProductId(int productId){
        return productDao.getListSizesByProductId(productId);
    }

    public double getPriceSizeByName(String nameSize, int productId){
        return productDao.getPriceSizeByName(nameSize, productId);
    }

    public Products getProductByProductId(int productId){
        return productDao.getProductByProductId(productId);
    }
}
