package dao;

import models.ID;
import models.Product;
import models.ProductCard;
import utils.MoneyRange;

import java.util.List;

public class ProductCardDAO {

    public List<ProductCard> getCartAllProduct() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, `name`, originalPrice, salePrice ")
                .append("FROM products ")
                .append("WHERE visibility = 1 ");
        List<ProductCard> list = GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class);
        return list;
    }

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

    public int getQuantityProduct() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id FROM products where visibility = 1");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), ProductCard.class).size();
    }

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

    public List<Product> getIdProductByCategoryId(List<String> listIdCategory) {
        StringBuilder categoryIdQuery = new StringBuilder();
        if (!listIdCategory.isEmpty()) {
            categoryIdQuery.append("AND categoryId IN (");
            for (int i = 0; i < listIdCategory.size(); i++) {
                if (i != 0) {
                    categoryIdQuery.append(", ");
                }
                categoryIdQuery.append(listIdCategory.get(i));
            }
            categoryIdQuery.append(")");
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id ")
                .append("FROM products  ")
                .append("WHERE visibility = 1 ")
                .append(categoryIdQuery);
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Product.class);
    }

    public List<Product> getIdProductByColor(List<String> listCodeColor) {
        StringBuilder colorQuery = new StringBuilder();
        if (!listCodeColor.isEmpty()) {
            colorQuery.append("AND colors.codeColor IN (");
            for (int i = 0; i < listCodeColor.size(); i++) {
                if (i != 0) {
                    colorQuery.append(", ");
                }
                colorQuery.append("\'")
                        .append(listCodeColor.get(i))
                        .append("\'");
            }
            colorQuery.append(")");
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT products.id ")
                .append("FROM products JOIN colors ON products.id = colors.productId ")
                .append("WHERE visibility = 1 ")
                .append(colorQuery);
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Product.class);
    }

    public List<Product> getIdProductBySize(List<String> listSize) {
        StringBuilder sizeQuery = new StringBuilder();
        if (!listSize.isEmpty()) {
            sizeQuery.append("AND sizes.nameSize IN (");
            for (int i = 0; i < listSize.size(); i++) {
                if (i != 0) {
                    sizeQuery.append(", ");
                }
                sizeQuery.append("\'")
                        .append(listSize.get(i))
                        .append("\'");
            }
            sizeQuery.append(")");
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT products.id ")
                .append("FROM products JOIN sizes ON products.id = sizes.productId ")
                .append("WHERE visibility = 1 ")
                .append(sizeQuery);
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Product.class);
    }


    public List<Product> getIdProductByMoneyRange(List<MoneyRange> moneyRangeList) {
        StringBuilder moneyRangeQuery = new StringBuilder();

        for (int i = 0; i < moneyRangeList.size(); i++) {
            if (i != 0) {
                moneyRangeQuery.append(" OR ");
            }
            moneyRangeQuery.append("( originalPrice BETWEEN ")
                    .append(moneyRangeList.get(i).getFrom()).
                    append(" AND ").append(moneyRangeList.get(i).getTo())
                    .append(" )");
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id ")
                .append("FROM products ")
                .append("WHERE visibility = 1 ")
                .append("AND ")
                .append(moneyRangeQuery);
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Product.class);
    }
}
