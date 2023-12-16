package dao;

import models.Category;

import java.util.List;

public interface CategoryDAO {
    public List<Category> getAllCategory();

    public List<Category> getCategory(int id);
}
