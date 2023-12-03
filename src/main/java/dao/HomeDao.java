package dao;

import models.Products;
import models.Sliders;

import java.util.List;
import java.util.Map;

public class HomeDao {

    public List<Sliders> getListSlideShow() {
        return GeneralDao.executeQueryWithSingleTable("SELECT nameSlide, nameImage FROM sliders WHERE visibility = 1", Sliders.class);
    }

    public List<Products> getListTrendingProducts() {
        return GeneralDao.executeQueryWithSingleTable("", Products.class);
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
