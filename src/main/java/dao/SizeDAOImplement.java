package dao;

import models.Category;
import models.ID;
import models.Size;

import java.util.List;

public class SizeDAOImplement implements SizeDAO {
    @Override
    public List<Size> getAllSize() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT nameSize").append(" FROM sizes");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), Size.class);
    }

    @Override
    public List<ID> getIdProduct(String size) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT productId ").append(" FROM sizes ").append("WHERE nameSize = ?");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), ID.class, size);
    }
}
