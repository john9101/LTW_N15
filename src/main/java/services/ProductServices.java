package services;

import dao.ProductDAO;
import dao.ProductDAOImplement;
import models.ID;
import models.Product;

import java.util.List;

public class ProductServices {
    private static ProductServices INSTANCE;

    private ProductServices() {
    }

    public static ProductServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new ProductServices();
        return INSTANCE;
    }

    public List<ID> findIdByName(String name) {
        ProductDAO productDAO = new ProductDAOImplement();
        return productDAO.findIdByName(name);
    }
}
