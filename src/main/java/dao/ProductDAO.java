package dao;

import models.ID;
import models.Product;

import java.util.List;

public interface ProductDAO {
    public List<ID> findIdByName(String name);
}
