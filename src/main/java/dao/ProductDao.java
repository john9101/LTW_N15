package dao;

import models.Colors;
import models.Images;
import models.Products;
import models.Sizes;

import java.util.List;

public class ProductDao {
    public List<Images> getListImagesByProductId(int productId){
        String sql = "SELECT id, nameImage, productId FROM Images WHERE productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Images.class, productId);
    }

    public List<Colors> getListColorsByProductId(int productId){
        String sql = "SELECT id, codeColor, productId FROM colors WHERE productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Colors.class, productId);
    }

    public List<Sizes> getListSizesByProductId(int productId){
        String sql = "SELECT id, nameSize, productId, sizePrice FROM sizes WHERE productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Sizes.class, productId);
    }

    public double getPriceSizeByName(String nameSize, int productId){
        String sql = "SELECT sizePrice FROM sizes WHERE nameSize = ? AND productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Sizes.class,nameSize, productId).get(0).getSizePrice();
    }

    public Products getProductByProductId(int productId){
        String sql = "SELECT id, `name`, `description`, salePrice, originalPrice FROM products WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Products.class, productId).get(0);
    }
}
