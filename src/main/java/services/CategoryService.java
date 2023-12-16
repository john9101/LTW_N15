package services;

import dao.CategoryDAO;
import dao.CategoryDAOImplement;
import models.ID;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static CategoryService INSTANCE;

    private CategoryService() {
    }

    public static CategoryService getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new CategoryService();
        return INSTANCE;
    }

    public List<Integer> checkIDValid(String[] idString) {
        List<Integer> result = new ArrayList<>();
        CategoryDAO dao = new CategoryDAOImplement();
        for (String s : idString) {
            try {
                int id = Integer.parseInt(s);
                if (!dao.getCategory(id).isEmpty()) result.add(id);
            } catch (NumberFormatException ignored) {
            }
        }
        return result;
    }
}
