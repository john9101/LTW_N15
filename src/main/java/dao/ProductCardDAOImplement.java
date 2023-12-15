package dao;

import models.ID;
import models.ProductCard;

import java.util.List;

public class ProductCardDAOImplement implements ProductCardDAO {
    @Override
    public ProductCardDAO selectById(int id) {
        return null;
    }

    @Override
    public int insert(ProductCardDAO o) {
        return 0;
    }

    @Override
    public int insertAll(List<ProductCardDAO> list) {
        return 0;
    }

    @Override
    public int delete(ProductCardDAO o) {
        return 0;
    }

    @Override
    public int deleteAll(List<ProductCardDAO> list) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public List<ProductCard> getCartAllProduct() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, `name`, originalPrice, salePrice ")
                .append("FROM products ")
                .append("WHERE visibility = 1 ");
        List<ProductCard> list = GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class);
        return list;
    }

    @Override
    public List<ProductCard> getProducts(int limit, int pageNumber) {
        int offset = (pageNumber - 1) * limit;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, `name`, originalPrice, salePrice ")
                .append("FROM products ")
                .append("WHERE visibility = 1 ")
                .append("LIMIT ")
                .append(limit)
                .append(" OFFSET ")
                .append(offset);

        List<ProductCard> list = GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class);
        return list;
    }

    @Override
    public int getQuantityProduct() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id FROM products where visibility = 1");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class).size();
    }

    @Override
    public List<ProductCard> findById(List<ID> listId) {
        StringBuilder listIdString = new StringBuilder();
        for (int i = 0; i < listId.size(); i++) {
            if (i == 0)
                listIdString.append(listId.get(i).getId());
            listIdString.append(", ").append(listId.get(i).getId());
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, `name`, originalPrice, salePrice ")
                .append("FROM products ")
                .append("WHERE visibility = 1 ")
                .append("AND id IN (")
                .append(listIdString)
                .append(")");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class);
    }

    @Override
    public List<ProductCard> pagingAndFilter(List<ID> listId, int pageNumber, int limit) {
        int offset = (pageNumber - 1) * limit;
        StringBuilder listIdString = new StringBuilder();
        if (listId != null && !listId.isEmpty()) {
            listIdString.append("AND id IN (");
            for (int i = 0; i < listId.size(); i++) {
                if (i == 0)
                    listIdString.append(listId.get(i).getId());
                listIdString.append(", ").append(listId.get(i).getId());
            }
            listIdString.append(")");
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, `name`, originalPrice, salePrice ")
                .append("FROM products ")
                .append("WHERE visibility = 1 ")
                .append(listIdString)
                .append(" LIMIT ")
                .append(limit)
                .append(" OFFSET ")
                .append(offset);
        System.out.println(sql.toString());
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class);
    }
}
