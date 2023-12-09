package dao;

import models.Image;
import models.ProductCart;

import java.util.List;

public class ProductCartDAOImplement implements ProductCartDAO {
    @Override
    public ProductCartDAO selectById(int id) {
        return null;
    }

    @Override
    public int insert(ProductCartDAO o) {
        return 0;
    }

    @Override
    public int insertAll(List<ProductCartDAO> list) {
        return 0;
    }

    @Override
    public int delete(ProductCartDAO o) {
        return 0;
    }

    @Override
    public int deleteAll(List<ProductCartDAO> list) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public List<ProductCart> getCartAllProduct() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, `name`, originalPrice, salePrice ")
                .append("FROM products ")
                .append("WHERE products.visibility = 1 ");
        List<ProductCart> list = GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCart.class);
        return list;
    }

}
