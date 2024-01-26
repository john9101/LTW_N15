package dao;

import models.*;

import java.util.List;

public class DashboadDAO {
    public  int countUser(){
        String querry = "SELECT id FROM users";
        return  GeneralDao.executeQueryWithSingleTable(querry, User.class).size();
    }
    public  int countProduct(){
        String querry = "SELECT id FROM products";
        return  GeneralDao.executeQueryWithSingleTable(querry, Product.class).size();
    }
    public  int countOrder(){
        String querry = "SELECT id FROM orders";
        return  GeneralDao.executeQueryWithSingleTable(querry, Order.class).size();
    }
    public  int countReview(){
        String querry = "SELECT id FROM reviews";
        return  GeneralDao.executeQueryWithSingleTable(querry, Review.class).size();
    }
    public List<OrderDetail> getTop5Product(){
        String querry = "SELECT products.id, products.name, SUM(quantityRequired)\n" +
                "FROM order_details  INNER JOIN products ON products.id = order_details.productId\n" +
                "GROUP BY products.id, products.name\n" +
                "ORDER BY SUM(quantityRequired) DESC\n" +
                "LIMIT 5";
        return GeneralDao.executeQueryWithSingleTable(querry, OrderDetail.class);
    }
    public List<Product> getTop5ProductName(int productId){
        String querry="SELECT name FROM products WHERE id=?";
        return GeneralDao.executeQueryWithSingleTable(querry, Product.class, productId);
    }
    public List<OrderDetail> getTop5ProductQuantity(int productId){
        String querry="SELECT quantityRequired FROM order_details WHERE productId=?";
        return GeneralDao.executeQueryWithSingleTable(querry, OrderDetail.class, productId);
    }


}
