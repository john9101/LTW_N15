package dao;

import models.Products;
import models.Sliders;

import javax.management.ObjectName;
import java.util.List;
import java.util.Map;

public class HomeDao {
    public List<Sliders> getListSlideShow() {
        return GeneralDao.executeQueryWithSingleTable("SELECT nameSlide, nameImage FROM sliders WHERE visibility = 1", Sliders.class);
    }
    public List<Map<String, Object>> getListTrendingProducts(boolean isSeeMore) {
        StringBuilder sql = new StringBuilder("SELECT products.id, products.`name`, products.salePrice, products.originalPrice, images.nameImage, SUM(order_details.quanlityRequired) AS TotalQuantity FROM products");
        sql.append(" INNER JOIN order_details ON products.id = order_details.productId INNER JOIN images ON products.id = images.productId");
        sql.append(" WHERE products.visibility = 1");
        sql.append(" GROUP BY products.id, products.`name`, products.salePrice, products.originalPrice, images.nameImage");
        sql.append(" HAVING TotalQuantity >= ?");
        sql.append(" ORDER BY TotalQuantity DESC");
        if(!isSeeMore){
            sql.append(" LIMIT 6");
        }
        return GeneralDao.executeQueryWithJoinTables(sql.toString(), 10);
    }

    public List<Map<String, Object>> getListNewProducts(boolean isSeeMore) {
        StringBuilder sql = new StringBuilder("SELECT products.name, products.originalPrice, products.salePrice, images.nameImage FROM products");
        sql.append(" INNER JOIN images ON products.id = images.productId");
        sql.append(" WHERE products.visibility = 1 AND products.createAt >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)");
        if (!isSeeMore) {
            sql.append(" LIMIT 6");
        }
        return GeneralDao.executeQueryWithJoinTables(sql.toString());
    }
}
