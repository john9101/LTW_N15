package dao;

import models.ID;

import java.util.List;

public class ProductDAOImplement implements ProductDAO {
    @Override
    public List<ID> findIdByName(String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id ")
                .append("FROM products ")
                .append("WHERE name LIKE CONCAT('% ', ?, ' %') ")
                .append("OR name LIKE CONCAT(?, ' %') ")
                .append("OR name LIKE CONCAT('% ', ?) ");
        return GeneralDao.executeQueryWithSingleTable(sql.toString(), ID.class, name, name, name);
    }
}
