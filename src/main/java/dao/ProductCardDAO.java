package dao;

import models.ID;
import models.ProductCard;

import java.util.List;

public interface ProductCardDAO extends DAO<ProductCardDAO> {
    public List<ProductCard> getCartAllProduct();

    public List<ProductCard> getProducts(int limit, int pageNumber);

    public int getQuantityProduct();

    List<ProductCard> findById(List<ID> listId);

    List<ProductCard> pagingAndFilter(List<ID> listId, int pageNumber, int limit);

}
