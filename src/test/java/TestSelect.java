import dao.GeneralDao;
import dao.UserDAO;
import database.DBProperties;
import database.JDBIConnector;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSelect {
    public static void main(String[] args) {
//        System.out.println(GeneralDao.executeQueryWithSingleTable("SELECT id, fullname, username FROM users", User.class));
        String sql = "SELECT products.`name`, images.nameImage, products.originalPrice, products.salePrice " +
                "FROM products JOIN images ON products.id = images.productId " +
                "WHERE products.visibility = ? ";
        List<Map<String, Object>> result = GeneralDao.executeQueryWithJoinTables(sql, 1);

        for (Map<String, Object> row : result) {
            System.out.println(row);
        }
    }
}
