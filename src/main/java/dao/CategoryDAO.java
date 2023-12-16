package dao;

import models.Category;

import java.util.List;

public class CategoryDAO {
    public List<Category> getAllCategory() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, nameType ")
                .append("FROM categories");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Category.class);
    }

    public List<Category> getCategory(int id) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, nameType ")
                .append("FROM categories ")
                .append("WHERE id = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Category.class, id);
    }
}
