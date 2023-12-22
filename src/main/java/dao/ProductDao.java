package dao;

import models.*;

import java.util.List;

public class ProductDao {
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
        String sql = "SELECT id, `name`, categoryId, `description`, salePrice, originalPrice FROM products WHERE id = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Product.class, productId).get(0);
    }

    public Size getSizeByNameSizeWithProductId(String nameSize, int productId) {
        String sql = "SELECT id, sizePrice, nameSize FROM sizes WHERE nameSize = ? AND productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Size.class, nameSize, productId).get(0);
    }

    public Color getColorByCodeColorWithProductId(String codeColor, int productId) {
        String sql = "SELECT id, codeColor FROM colors WHERE codeColor = ? AND productId = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Color.class, codeColor, productId).get(0);
    }

    public List<Product> getIdProductByName(String name) {
        String sql = "SELECT id, name FROM products WHERE name = ?";
        return GeneralDao.executeQueryWithSingleTable(sql, Product.class, name);
    }

    //    Update
    public boolean addProduct(Product product) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO products (name, categoryId, description, originalPrice, salePrice, visibility, createAt) ")
                .append("VALUES (?,?,?,?,?,?,?) ");
        GeneralDao.executeAllTypeUpdate(sql.toString(), product.getName(), product.getCategoryId(), product.getDescription(), product.getOriginalPrice(), product.getSalePrice(), product.isVisibility(), product.getCreateAt());
        return true;
    }

    public boolean addColors(Color[] colors) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO colors (codeColor, productId) ")
                .append("VALUES ");
        for (int i = 0; i < colors.length; i++) {
            sql.append(" (")
                    .append(colors[i].getCodeColor())
                    .append(", ")
                    .append(colors[i].getProductId()).append(") ");

        }
        GeneralDao.executeAllTypeUpdate(sql.toString());
        return true;
    }

    public boolean addImages(Image[] images) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO images (nameImage, productId) ")
                .append("VALUES ");
        for (int i = 0; i < images.length; i++) {
            sql.append(" (")
                    .append(images[i].getNameImage())
                    .append(", ")
                    .append(images[i].getProductId()).append(") ");

        }
        GeneralDao.executeAllTypeUpdate(sql.toString());
        return true;
    }

    public boolean addSizes(Size[] sizes) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO sizes (nameSize, productId, sizePrice) ")
                .append("VALUES ");
        for (int i = 0; i < sizes.length; i++) {
            sql.append(" (")
                    .append(sizes[i].getNameSize())
                    .append(", ")
                    .append(sizes[i].getProductId())
                    .append(", ")
                    .append(sizes[i].getSizePrice())
                    .append(") ");

        }
        GeneralDao.executeAllTypeUpdate(sql.toString());
        return true;
    }
}
