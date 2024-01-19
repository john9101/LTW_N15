package services;

import dao.CategoryDAO;
import models.Category;

import java.util.List;

public class AdminCategoryServices {
    private static AdminCategoryServices INSTANCE;
    private CategoryDAO categoryDAO;

    private AdminCategoryServices() {
        categoryDAO = new CategoryDAO();
    }

    public static AdminCategoryServices getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new AdminCategoryServices();
        return INSTANCE;
    }

    public List<Category> getCategories() {
        return categoryDAO.getAllCategory();
    }
}
