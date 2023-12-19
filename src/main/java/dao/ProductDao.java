package dao;

import models.*;

import java.util.List;

public class ProductDAO {
    public List<Image> getListImagesByProductId(int productId) {
        String sql = "SELECT id, nameImage, productId FROM Images WHERE productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Image.class, productId);
    }

    public List<Color> getListColorsByProductId(int productId) {
        String sql = "SELECT id, codeColor, productId FROM colors WHERE productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Color.class, productId);
    }

    public List<Size> getListSizesByProductId(int productId) {
        String sql = "SELECT id, nameSize, productId, sizePrice FROM sizes WHERE productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Size.class, productId);
    }

    public double getPriceSizeByName(String nameSize, int productId) {
        String sql = "SELECT sizePrice FROM sizes WHERE nameSize = ? AND productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Size.class, nameSize, productId).get(0).getSizePrice();
    }

    public Product getProductByProductId(int productId) {
        String sql = "SELECT id, `name`, `description`, salePrice, originalPrice FROM products WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Product.class, productId).get(0);
    }


}
