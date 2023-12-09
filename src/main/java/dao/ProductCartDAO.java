package dao;

import models.ProductCart;

import java.util.List;

public interface ProductCartDAO extends DAO<ProductCartDAO> {
    public List<ProductCart> getCartAllProduct();

}
